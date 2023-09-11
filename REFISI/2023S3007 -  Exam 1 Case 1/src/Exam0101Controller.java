import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Exam0101Controller {
    /*Fields*/
    Exam0101BookStore store = new Exam0101BookStore();
    Exam0101Book[] books;

    /*Constructor*/
    public Exam0101Controller() {
        System.out.printf("Controller Constructor invoke.. %n");
    }

    /*Method ReadData*/
    public void readData() {
        Scanner scanner = new Scanner(System.in);
        String inputData;
        int countBook, count;

        /*Read Book Store Info*/
        System.out.printf("%n Program Pengelola Data Buku%n");
        System.out.printf("Informasi Toko Buku%n");
		  // Validasi Nama Toko
		    do {
		        System.out.printf("Nama Toko:");
		        inputData = scanner.nextLine();
		        if (inputData.trim().isEmpty()) {
		            System.out.printf("Nama Toko harus diisi.%n");
		        }
		    } while (inputData.trim().isEmpty());
		    store.setName(inputData);

		    // Validasi Alamat Toko
		    do {
		        System.out.printf("Alamat:");
		        inputData = scanner.nextLine();
		        if (inputData.trim().isEmpty()) {
		            System.out.printf("Alamat Toko harus diisi.%n");
		        }
		    } while (inputData.trim().isEmpty());
		    store.setAddress(inputData); 

			do {
			    System.out.printf("%nJumlah Buku:");
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
			books = new Exam0101Book[countBook];

        for (count = 0; count < countBook; count++) {
            Exam0101Book book = new Exam0101Book();
            System.out.printf("%nBuku ke-%d%n", count + 1);
			do {
			    System.out.printf("ISBN:");
			    inputData = scanner.nextLine();
			    	if (inputData.trim().isEmpty()) {
			           System.out.printf("ISBN tidak boleh kosong.%n");
			        } else if (!inputData.matches("\\d+")) {
			           System.out.printf("ISBN harus berupa angka bulat.%n");
			        }
			    } while (inputData.trim().isEmpty() || !inputData.matches("\\d+"));
			book.setIsbn(inputData);

			do {
			        System.out.printf("JUDUL:");
			        inputData = scanner.nextLine();
			        if (inputData.trim().isEmpty()) {
			            System.out.printf("Judul tidak boleh kosong.%n");
			        }
			    } while (inputData.trim().isEmpty());
			    book.setTitle(inputData);

			do {
			        System.out.printf("PENERBIT:");
			        inputData = scanner.nextLine();
			        if (inputData.trim().isEmpty()) {
			            System.out.printf("Penerbit tidak boleh kosong.%n");
			        }
			    } while (inputData.trim().isEmpty());
			    book.setPublisher(inputData);

			float price = 0.0f;
            while (true) {
                System.out.printf("HARGA:");
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
                System.out.printf("HALAMAN:");
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

            books[count] = book;
        }
    }
	public void sortingData() {
	    quickSortByPriceDescending(books, 0, books.length - 1);
	}

	private void quickSortByPriceDescending(Exam0101Book[] arr, int low, int high) {
	    if (low < high) {
	        int partitionIndex = partitionByPriceDescending(arr, low, high);

	        quickSortByPriceDescending(arr, low, partitionIndex - 1);
	        quickSortByPriceDescending(arr, partitionIndex + 1, high);
	    }
	}

	private int partitionByPriceDescending(Exam0101Book[] arr, int low, int high) {
	    float pivot = arr[high].getPrice();
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (arr[j].getPrice() >= pivot) {
	            i++;
	            swap(arr, i, j);
	        }
	    }

	    swap(arr, i + 1, high);
	    return i + 1;
	}

	private void swap(Exam0101Book[] arr, int i, int j) {
	    Exam0101Book temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

    public void showData() {
        int countBook = books.length;
        System.out.printf("%nInformasi Toko Buku");
        System.out.printf("Nama Toko: %s%n", store.getName());
        System.out.printf("Alamat: %s%n", store.getAddress());
		System.out.printf("%nDaftar Buku yang diurutkan berdasarkan harga tertinggi%n");
        System.out.printf("%n%-3s %-40s %-15s %-20s %-15s %-10s%n", "No", "JUDUL", "ISBN", "PENERBIT", "HARGA", "HALAMAN");
        System.out.printf("===========================================================================================================%n");

        for (int count = 0; count < countBook; count++) {
        Exam0101Book book = books[count];
        double price = book.getPrice();
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String formattedPrice = currencyFormat.format(price);

        System.out.printf(new Locale("in", "ID"), "%3d %-40s %-15s %-20s %-15s %-10d%n",
                count + 1, book.getTitle(), book.getIsbn(), book.getPublisher(), formattedPrice, book.getPage());

        }
        System.out.printf("===========================================================================================================%n");
    }
}
