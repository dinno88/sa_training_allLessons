import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Exam0102Controller {
    /* Fields */
    Exam0102Book[] books = new Exam0102Book[0]; // Inisialisasi array buku kosong
    int bookCount = 0;

    /* Constructor */
    public Exam0102Controller() {
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
        System.out.printf("%n%-3s %-40s %-15s %-20s %-15s %-10s%n", "No", "JUDUL", "ISBN", "PENERBIT", "HARGA", "HALAMAN");
        System.out.printf("===========================================================================================================%n");
        if (countBook == 0) {
            System.out.printf("Belum ada data buku.%n");
            System.out.printf("===========================================================================================================%n");         
            return;
        }
        for (int count = 0; count < countBook; count++) {
            Exam0102Book book = books[count];
            double price = book.getPrice();

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
            String formattedPrice = currencyFormat.format(price);

            System.out.printf(new Locale("in", "ID"), "%3d %-40s %-15s %-20s %-15s %-10d%n",
                    count + 1, book.getTitle(), book.getIsbn(), book.getPublisher(), formattedPrice, book.getPage());

        }
        System.out.printf("===========================================================================================================%n");
    }

    private Scanner scanner = new Scanner(System.in);

    public void addData() {
        // Tambah data
        System.out.printf("%nTambah Data Buku%n");

        String title = "";
        while (title.isEmpty()) {
            System.out.printf("Judul buku: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.printf("Judul tidak boleh kosong. Mohon masukkan judul buku.%n");
            }
        }

        String isbn = "";
        while (isbn.isEmpty() || !isbn.matches("\\d+")) {
            System.out.printf("ISBN buku: ");
            isbn = scanner.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.printf("ISBN tidak boleh kosong. Mohon masukkan ISBN buku.%n");
            } else if (!isbn.matches("\\d+")) {
                System.out.printf("ISBN hanya boleh berisi angka. Mohon masukkan ISBN buku yang valid.%n");
            }
        }

        String publisher = "";
        while (publisher.isEmpty()) {
            System.out.printf("Penerbit buku: ");
            publisher = scanner.nextLine().trim();
            if (publisher.isEmpty()) {
                System.out.printf("Penerbit tidak boleh kosong. Mohon masukkan penerbit buku.%n");
            }
        }

        float price = 0;
        while (price <= 0) {
            System.out.printf("Harga buku: ");
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
            System.out.printf("Jumlah halaman buku: ");
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
        Exam0102Book newBook = new Exam0102Book(title, isbn, publisher, price, page);
        addBook(newBook);

        // Tampilkan data baru yang baru saja diinput
            System.out.printf("%nData buku baru:%n");
            System.out.printf("============%n");
            displayBookInfo(newBook);

            // Menunggu masukan sebelum melanjutkan
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
            Exam0102Book bookToUpdate = books[bookIndex];

            System.out.printf("Judul baru: ");
            String newTitle = scanner.nextLine();
            bookToUpdate.setTitle(newTitle);

            System.out.printf("Penerbit baru: ");
            String newPublisher = scanner.nextLine();
            bookToUpdate.setPublisher(newPublisher);

            System.out.printf("Harga baru: ");
            float newPrice = Float.parseFloat(scanner.nextLine());
            bookToUpdate.setPrice(newPrice);

            System.out.printf("Halaman baru: ");
            int newPage = Integer.parseInt(scanner.nextLine());
            bookToUpdate.setPage(newPage);

            System.out.printf("%nData Buku Lama:%n");
            System.out.printf("============%n");
            displayBookInfo(oldBook);

            System.out.printf("%nData Buku Baru:%n");
            System.out.printf("============%n");
            displayBookInfo(bookToUpdate);

            books[bookIndex] = bookToUpdate;
            System.out.printf("Data buku dengan ISBN " + isbnToEdit + " telah diubah.");
        } else {
            System.out.printf("Buku dengan ISBN " + isbnToEdit + " tidak ditemukan.");
        }
    }   
        private void displayBookInfo(Exam0102Book book) {
        System.out.printf("Judul: %s%n", book.getTitle());
        System.out.printf("ISBN: %s%n", book.getIsbn());
        System.out.printf("Penerbit: %s%n", book.getPublisher());
        System.out.printf("Harga: %.2f%n", book.getPrice());
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
        } else {
            System.out.printf("Buku dengan ISBN " + isbnToDelete + " tidak ditemukan.");
        }
    }

    private void addBook(Exam0102Book book) {
        Exam0102Book[] newBooks = new Exam0102Book[books.length + 1];
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

        Exam0102Book[] newBooks = new Exam0102Book[books.length - 1];
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
        Exam0102Controller controller = new Exam0102Controller();
        controller.readData();
    }
}