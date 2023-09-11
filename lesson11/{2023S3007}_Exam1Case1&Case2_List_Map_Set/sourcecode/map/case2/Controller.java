package edu.satraining.lesson11.map.exam1.case2.controller;

import edu.satraining.lesson11.map.exam1.case2.model.Book;

import java.util.AbstractList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Map;
import java.util.HashMap;

public class Controller {
    /* Fields */
   Map<String, Book> bookMap = new HashMap<>();
    private final Scanner scanner1;

    /* Constructor */
    public Controller() {
        scanner1 = new Scanner(System.in);
        initMenuMap();
        System.out.printf("Controller Constructor invoked.. %n");
    }

    private void initMenuMap() {
		// TODO Auto-generated method stub
		
	}

	public void readData() {
        Map<String, Runnable> menuMap = new HashMap<>();
        menuMap.put("S", this::showData);
        menuMap.put("A", this::addData);
        menuMap.put("E", this::editData);
        menuMap.put("D", this::deleteData);
        menuMap.put("X", () -> {
            System.out.println("Aplikasi ditutup.");
            scanner1.close();
            System.exit(0);
        });

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
                String inputData = scanner1.nextLine().toUpperCase();

                Runnable selectedAction = menuMap.get(inputData);
                if (selectedAction != null) {
                    selectedAction.run();
                } else {
                    throw new IllegalArgumentException("Input tidak valid: " + inputData);
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%nPilihan tidak valid. Mohon pilih menu yang benar.%n");
            }
        }
    }
	public void showData() {
        Consumer<Void> showDataAction = (unused) -> {
            Map<String, Book> books = null;
			@SuppressWarnings("null")
			int countBook = books.size();

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
                @SuppressWarnings("unlikely-arg-type")
				Book book = books.get(count); // Menggunakan metode get() pada ArrayList
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
        };

        showDataAction.accept(null);
    }

    private Scanner scanner = new Scanner(System.in);

    public void addData() {
        // Tambah data
        System.out.printf("%nTambah Data Buku%n");

        String title = "";
        while (title.isEmpty()) {
            System.out.printf("Judul         : ");
            title = scanner1.nextLine().trim();
            if (title.isEmpty()) {
                System.out.printf("Judul tidak boleh kosong. Mohon masukkan judul buku.%n");
            }
        }

        String isbn = "";
        while (isbn.isEmpty() || !isbn.matches("\\d+")) {
            System.out.printf("ISBN          : ");
            isbn = scanner1.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.printf("ISBN tidak boleh kosong. Mohon masukkan ISBN buku.%n");
            } else if (!isbn.matches("\\d+")) {
                System.out.printf("ISBN hanya boleh berisi angka. Mohon masukkan ISBN buku yang valid.%n");
            }
        }

        String publisher = "";
        while (publisher.isEmpty()) {
            System.out.printf("Penerbit      : ");
            publisher = scanner1.nextLine().trim();
            if (publisher.isEmpty()) {
                System.out.printf("Penerbit tidak boleh kosong. Mohon masukkan penerbit buku.%n");
            }
        }

        float price = 0;
        while (price <= 0) {
            System.out.printf("Harga         : ");
            try {
                price = Float.parseFloat(scanner1.nextLine());
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
                page = Integer.parseInt(scanner1.nextLine());
                if (page <= 0) {
                    System.out.printf("Jumlah halaman harus lebih dari 0. Mohon masukkan jumlah halaman buku.");
                }
            } catch (NumberFormatException e) {
                System.out.printf("Format jumlah halaman tidak valid. Mohon masukkan angka yang valid.");
            }
        }

        // Tambahkan buku baru ke dalam
        Book newBook = new Book(title, isbn, publisher, price, page);
        Map<String, Book> books = null;
        addBook(newBook, books); 
		String newBookId = String.valueOf(books.size() + 1);
        books.put(newBookId, newBook);

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
        scanner1.nextLine();
    }


	public void editData() {
        Consumer<Void> editDataAction = (unused) -> {
            System.out.printf("%nEdit Data Buku%n");
            System.out.printf("Masukkan ISBN buku yang ingin diubah: ");
            String isbnToEdit = scanner.nextLine();

            int bookIndex = -1;
            Map<String, Book> books = null;
			for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getIsbn().equals(isbnToEdit)) {
                    bookIndex = i;
                    break;
                }
            }

            if (bookIndex != -1) {
                Book oldBook = books.get(bookIndex);
                Book bookToUpdate = oldBook.clone();

                System.out.printf("Judul         : ");
                String newTitle = scanner.nextLine();
                bookToUpdate.setTitle(newTitle);

                System.out.printf("Penerbit      : ");
                String newPublisher = scanner.nextLine();
                bookToUpdate.setPublisher(newPublisher);

                float newPrice = 0;
                while (newPrice <= 0) {
                    System.out.printf("Harga         : ");
                    try {
                        newPrice = Float.parseFloat(scanner.nextLine());
                        if (newPrice <= 0) {
                            System.out.printf("Harga harus lebih dari 0. Mohon masukkan harga buku.%n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.printf("Format harga tidak valid. Mohon masukkan angka yang valid.%n");
                    }
                }
                bookToUpdate.setPrice(newPrice);

                int newPage = 0;
                while (newPage <= 0) {
                    System.out.printf("Jumlah Halaman: ");
                    try {
                        newPage = Integer.parseInt(scanner.nextLine());
                        if (newPage <= 0) {
                            System.out.printf("Jumlah halaman harus lebih dari 0. Mohon masukkan jumlah halaman buku.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.printf("Format jumlah halaman tidak valid. Mohon masukkan angka yang valid.");
                    }
                }
                bookToUpdate.setPage(newPage);

                System.out.printf("%nData Saat ini:%n");
                System.out.println("=============");
                displayBookInfo(oldBook);

                System.out.printf("%nData Terbaru:%n");
                System.out.println("=============");
                displayBookInfo(bookToUpdate);

                System.out.printf("%nData buku dengan ISBN " + isbnToEdit + " Berhasil diubah.%n");
                ((AbstractList) books).set(bookIndex, bookToUpdate);

                System.out.printf("%nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            } else {
                System.out.printf("Buku dengan ISBN " + isbnToEdit + " tidak ditemukan.");
            }
        };

        editDataAction.accept(null);
    }

	private void displayBookInfo(Book oldBook) {
		// TODO Auto-generated method stub
		
	}

	public void deleteData() {
        Consumer<Void> deleteDataAction = (unused) -> {
            System.out.printf("Masukkan ISBN buku yang ingin dihapus: ");
            String isbnToDelete = scanner.nextLine();

            int bookIndex = -1;
            Map<String, Book> books = null;
			for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getIsbn().equals(isbnToDelete)) {
                    bookIndex = i;
                    break;
                }
            }

            if (bookIndex != -1) {
                books.remove(bookIndex);
                System.out.printf("Buku dengan ISBN " + isbnToDelete + " telah dihapus.");
                System.out.printf("%nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            } else {
                System.out.printf("Buku dengan ISBN " + isbnToDelete + " tidak ditemukan.");
            }
        };

        deleteDataAction.accept(null);
    }

	private void addBook(Book book, Map<String, Book> booksMap) {
		booksMap.put(book.getIsbn(), book);
    }

    private void removeBook(int index) {
        Map<String, Book> books = null;
		if (index < 0 || index >= books.size()) {
            System.out.printf("Indeks buku tidak valid.");
            return;
        }
        books.remove(index);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        Map<String, Runnable> menuMap = new HashMap<>();
        menuMap.put("A", controller::addData);
        menuMap.put("E", controller::editData);
        menuMap.put("D", controller::deleteData);

        controller.readData();
    }
}