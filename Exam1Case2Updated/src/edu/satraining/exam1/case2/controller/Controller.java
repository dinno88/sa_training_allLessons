package edu.satraining.exam1.case2.controller;

import edu.satraining.exam1.case2.model.Book;

import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Controller {
    /* Fields */
    Book[] books = new Book[0]; // Inisialisasi array buku kosong
    int bookCount = 0;

    /* Constructor */
    public Controller() {
        System.out.printf("Controller Constructor invoked.. %n");
    }

 public void readData() {
        Scanner scanner = new Scanner(System.in);
        String inputData, title, isbn, publisher;
        int page, countBook, count;
        float price;
        while (true) {
            try {
                System.out.printf("%nMenu Aplikasi%n");
                System.out.printf("=============%n");
                System.out.printf("[S] Tampilkan Data%n");
                System.out.printf("[A] Tambah Data%n");
                System.out.printf("[E] Ubah Data%n");
                System.out.printf("[D] Hapus Data%n");
                System.out.printf("[X] Exit%n");
                System.out.printf("==============%n%n");
                System.out.printf("Pilih menu [S/ A/ E/ D/ X]:");
                inputData = scanner.nextLine();
                if (inputData.equalsIgnoreCase("S")) {
                    showData();
                } else if (inputData.equalsIgnoreCase("A")) {
                    addData();
                } else if (inputData.equalsIgnoreCase("E")) {
                    editData();
                } else if (inputData.equalsIgnoreCase("D")) {
                    deleteData();
                } else if (inputData.equalsIgnoreCase("X")) {
                    System.out.println("Aplikasi ditutup.");
                    scanner.close();
                    System.exit(0);
                } else {
                    throw new IllegalArgumentException("Input tidak valid: " + inputData);
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%nPilihan tidak valid. Mohon pilih menu yang benar.%n");
            }
        }
    }

    public void showData() {
        int countBook = books.length;

        System.out.printf("%nDaftar Data Buku%n");
        System.out.printf("%n%-3s %-40s %-15s %-20s %20s %10s%n", "No", "JUDUL", "ISBN", "PENERBIT", "HARGA", "HALAMAN");
        System.out.printf("==================================================================================================================%n");
        
        if (countBook == 0) {
            System.out.printf("Belum ada data buku.%n");
            System.out.printf("==================================================================================================================%n");
            System.out.print("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();      
            return;
        }

        for (int count = 0; count < countBook; count++) {
            Book book = books[count];
            double price = book.getPrice();

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
            String formattedPrice = currencyFormat.format(price);
            // Add space between currency symbol and amount
            formattedPrice = formattedPrice.replace("Rp", "Rp     ");

            System.out.printf(new Locale("in", "ID"), "%3d %-40s %-15s %-20s %20s %10d%n",
                    count + 1, book.getTitle(), book.getIsbn(), book.getPublisher(), formattedPrice, book.getPage());
        }

        System.out.printf("==================================================================================================================%n");
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    private Scanner scanner = new Scanner(System.in);

    public void addData() {
        // Tambah data
        System.out.printf("%nTambah Data Buku%n");

        String title = "";
        while (title.isEmpty()) {
            System.out.printf("Judul         : ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.printf("Judul tidak boleh kosong. Mohon masukkan judul buku.%n");
            }
        }

        String isbn = "";
        while (isbn.isEmpty() || !isbn.matches("\\d+")) {
            System.out.printf("ISBN          : ");
            isbn = scanner.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.printf("ISBN tidak boleh kosong. Mohon masukkan ISBN buku.%n");
            } else if (!isbn.matches("\\d+")) {
                System.out.printf("ISBN hanya boleh berisi angka. Mohon masukkan ISBN buku yang valid.%n");
            }
        }

        String publisher = "";
        while (publisher.isEmpty()) {
            System.out.printf("Penerbit      : ");
            publisher = scanner.nextLine().trim();
            if (publisher.isEmpty()) {
                System.out.printf("Penerbit tidak boleh kosong. Mohon masukkan penerbit buku.%n");
            }
        }

        float price = 0;
        while (price <= 0) {
            System.out.printf("Harga         : ");
            try {
                price = Float.parseFloat(scanner.nextLine());
                if (price <= 0) {
                    System.out.printf("Harga harus lebih dari 0. Mohon masukkan harga buku.%n");
                }
            } catch (NumberFormatException e) {
                System.out.printf("Format harga tidak valid. Mohon masukkan angka yang valid.%n");
            }
        }

        int page = 0;
        while (page <= 0) {
            System.out.printf("Jumlah halaman: ");
            try {
                page = Integer.parseInt(scanner.nextLine());
                if (page <= 0) {
                    System.out.printf("Jumlah halaman harus lebih dari 0. Mohon masukkan jumlah halaman buku.");
                }
            } catch (NumberFormatException e) {
                System.out.printf("Format jumlah halaman tidak valid. Mohon masukkan angka yang valid.");
            }
        }

        // Tambahkan buku baru ke dalam array book
        Book newBook = new Book(title, isbn, publisher, price, page);
        addBook(newBook);
            // Tampilkan data buku baru yang baru saja diinput
            System.out.printf("%nTambah Data:%n");
            System.out.printf("=================================%n");
            System.out.printf("Judul         : %s%n", newBook.getTitle());
            System.out.printf("ISBN          : %s%n", newBook.getIsbn());
            System.out.printf("Penerbit      : %s%n", newBook.getPublisher());
            System.out.printf("Harga         : Rp. %.2f%n", newBook.getPrice());
            System.out.printf("Jumlah Halaman: %d%n", newBook.getPage());
            System.out.printf("=================================%n");
            System.out.printf("Data di atas berhasil ditambahkan.%n");
            System.out.printf("%nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
    }


    public void editData() {
        // Edit data
        System.out.printf("%nEdit Data Buku%n");
        System.out.printf("Masukkan ISBN buku yang ingin diubah: ");
        String isbnToEdit = scanner.nextLine();

        int bookIndex = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(isbnToEdit)) {
                bookIndex = i;
                break;
            }
        }

        if (bookIndex != -1) {
            Book oldBook = books[bookIndex];
            Book bookToUpdate = oldBook.clone(); // Create a clone of the old book to store the original data

            System.out.printf("Judul         : ");
            String newTitle = scanner.nextLine();
            bookToUpdate.setTitle(newTitle);

            System.out.printf("Penerbit      : ");
            String newPublisher = scanner.nextLine();
            bookToUpdate.setPublisher(newPublisher);

            System.out.printf("Harga         : ");
            float newPrice = Float.parseFloat(scanner.nextLine());
            bookToUpdate.setPrice(newPrice);

            System.out.printf("Jumlah Halaman: ");
            int newPage = Integer.parseInt(scanner.nextLine());
            bookToUpdate.setPage(newPage);
            
            // Display old data
            System.out.printf("%nData Saat ini:%n");
            System.out.println("=============");
            displayBookInfo(oldBook);

            // Display new data
            System.out.printf("%nData Terbaru:%n");
            System.out.println("=============");
            displayBookInfo(bookToUpdate);

            System.out.printf("%nData buku dengan ISBN " + isbnToEdit + " Berhasil diubah.%n");

            // Update the books array with the new data
            books[bookIndex] = bookToUpdate;

            System.out.printf("%nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        } else {
            System.out.printf("Buku dengan ISBN " + isbnToEdit + " tidak ditemukan.");
        }
    }

    private void displayBookInfo(Book book) {
        System.out.printf("Judul         : %s%n", book.getTitle());
        System.out.printf("ISBN          : %s%n", book.getIsbn());
        System.out.printf("Penerbit      : %s%n", book.getPublisher());
        System.out.printf("Harga         : Rp. %.2f%n", book.getPrice());
        System.out.printf("Jumlah Halaman: %d%n", book.getPage());
    }



    public void deleteData() {
        System.out.printf("Masukkan ISBN buku yang ingin dihapus: ");
        String isbnToDelete = scanner.nextLine();

        int bookIndex = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(isbnToDelete)) {
                bookIndex = i;
                break;
            }
        }

        if (bookIndex != -1) {
            removeBook(bookIndex);
            System.out.printf("Buku dengan ISBN " + isbnToDelete + " telah dihapus.");
            System.out.printf("%nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        } else {
            System.out.printf("Buku dengan ISBN " + isbnToDelete + " tidak ditemukan.");
        }
    }

    private void addBook(Book book) {
        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        newBooks[newBooks.length - 1] = book;
        books = newBooks;
    }

    private void removeBook(int index) {
        if (index < 0 || index >= books.length) {
            System.out.printf("Indeks buku tidak valid.");
            return;
        }

        Book[] newBooks = new Book[books.length - 1];
        int newIndex = 0;
        for (int i = 0; i < books.length; i++) {
            if (i != index) {
                newBooks[newIndex] = books[i];
                newIndex++;
            }
        }
        books = newBooks;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readData();
    }
}