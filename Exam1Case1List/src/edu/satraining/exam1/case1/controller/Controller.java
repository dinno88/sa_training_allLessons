package edu.satraining.exam1.case1.controller;

import edu.satraining.exam1.case1.model.Book;
import edu.satraining.exam1.case1.model.BookStore;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Controller {
    /*Fields*/
    BookStore store = new BookStore();
    List<Book> books = new ArrayList<>();

    /*Constructor*/
    public Controller() {
        System.out.printf("Controller Constructor invoke.. %n");
    }

    /*Method ReadData*/
    public void readData() {
        Scanner scanner = new Scanner(System.in);
        String inputData;
        int countBook, count;

        /*Read Book Store Info*/
        System.out.printf("%nProgram Pengelola Data Buku%n");
        System.out.printf("Informasi Toko Buku%n");
		  // Validasi Nama Toko
		    do {
		        System.out.printf("Nama Toko  : ");
		        inputData = scanner.nextLine();
		        if (inputData.trim().isEmpty()) {
		            System.out.printf("Nama Toko harus diisi.%n");
		        }
		    } while (inputData.trim().isEmpty());
		    store.setName(inputData);

		    // Validasi Alamat Toko
		    do {
		        System.out.printf("Alamat	   : ");
		        inputData = scanner.nextLine();
		        if (inputData.trim().isEmpty()) {
		            System.out.printf("Alamat Toko harus diisi.%n");
		        }
		    } while (inputData.trim().isEmpty());
		    store.setAddress(inputData); 

			do {
			    System.out.printf("%nJumlah Buku: ");
			    inputData = scanner.nextLine();
			    try {
			        countBook = Integer.parseInt(inputData);
			        if (countBook <= 0) {
			            System.out.printf("Jumlah Buku harus lebih besar dari 0%n.");
			        }
			    } catch (NumberFormatException e) {
			        System.out.printf("Masukkan angka bulat yang valid.%n");
			        countBook = 0; // Mengatur ulang nilai countBook agar perulangan berlanjut
			    }
			} while (countBook <= 0);
			// books = new Book[countBook];

        for (count = 0; count < countBook; count++) {
            Book book = new Book();
            System.out.printf("%nBuku ke-%d%n", count + 1);
			do {
			    System.out.printf("     ISBN : ");
			    inputData = scanner.nextLine();
			    	if (inputData.trim().isEmpty()) {
			           System.out.printf("ISBN tidak boleh kosong.%n");
			        } else if (!inputData.matches("\\d+")) {
			           System.out.printf("ISBN harus berupa angka bulat.%n");
			        }
			    } while (inputData.trim().isEmpty() || !inputData.matches("\\d+"));
			book.setIsbn(inputData);

			do {
			        System.out.printf("    JUDUL : ");
			        inputData = scanner.nextLine();
			        if (inputData.trim().isEmpty()) {
			            System.out.printf("Judul tidak boleh kosong.%n");
			        }
			    } while (inputData.trim().isEmpty());
			    book.setTitle(inputData);

			do {
			        System.out.printf(" PENERBIT : ");
			        inputData = scanner.nextLine();
			        if (inputData.trim().isEmpty()) {
			            System.out.printf("Penerbit tidak boleh kosong.%n");
			        }
			    } while (inputData.trim().isEmpty());
			    book.setPublisher(inputData);

			float price = 0.0f;
            while (true) {
                System.out.printf("    HARGA : ");
                inputData = scanner.nextLine();
                if (inputData.trim().isEmpty()) {
                    System.out.printf("Harga tidak boleh kosong.%n");
                    continue;
                }
                try {
                    price = Float.parseFloat(inputData);
                    break;
                } catch (NumberFormatException e) {
                    System.out.printf("Harga harus diisi dengan angka.%n");
                }
            }
            book.setPrice(price);

            // Validasi Halaman (harus angka dan tidak boleh kosong)
            int page = 0;
            while (true) {
                System.out.printf("  HALAMAN : ");
                inputData = scanner.nextLine();
                if (inputData.trim().isEmpty()) {
                    System.out.printf("Halaman tidak boleh kosong.%n");
                    continue;
                }
                try {
                    page = Integer.parseInt(inputData);
                    break;
                } catch (NumberFormatException e) {
                    System.out.printf("Halaman harus diisi dengan angka.%n");
                }
            }
            book.setPage(page);

            books.add(book);
        }
    }
	
	public void sortingData() {
        quickSortByPriceDescending(books, 0, books.size() - 1);
    }

	private void quickSortByPriceDescending(List<Book> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionByPriceDescending(arr, low, high);

            quickSortByPriceDescending(arr, low, partitionIndex - 1);
            quickSortByPriceDescending(arr, partitionIndex + 1, high);
        }
    }

    private int partitionByPriceDescending(List<Book> arr, int low, int high) {
        float pivot = arr.get(high).getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j).getPrice() >= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(List<Book> arr, int i, int j) {
        Book temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public void showData() {
        int countBook = books.size();
        System.out.printf("%nInformasi Toko Buku%n");
        System.out.printf("Nama Toko : %s%n", store.getName());
        System.out.printf("Alamat    : %s%n", store.getAddress());
        System.out.printf("%nDaftar Data Buku diurutkan berdasarkan harga teritinggi%n");
        System.out.printf("%n%-3s %-40s %-15s %-20s %20s %10s%n", "No", "JUDUL", "ISBN", "PENERBIT", "HARGA", "HALAMAN");
        System.out.printf("==================================================================================================================%n");
        
        int count = 1; // Menggunakan variabel count untuk nomor urut
        for (Book book : books) {
            double price = book.getPrice();

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
            String formattedPrice = currencyFormat.format(price);
            // Add space between currency symbol and amount
            formattedPrice = formattedPrice.replace("Rp", "Rp     ");

            System.out.printf(new Locale("in", "ID"), "%3d %-40s %-15s %-20s %20s %10d%n",
                    count, book.getTitle(), book.getIsbn(), book.getPublisher(), formattedPrice, book.getPage());

            count++; // Naikkan nomor urut setiap iterasi
        }

        System.out.printf("==================================================================================================================%n");

    }
}
