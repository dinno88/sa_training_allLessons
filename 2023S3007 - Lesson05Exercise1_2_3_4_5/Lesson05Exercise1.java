import java.util.Scanner;

public class Lesson05Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String panjang;
        int p;

        System.out.printf("Masukkan panjang segitiga (3-15): ");
        panjang = scanner.nextLine();
        p = Integer.parseInt(panjang);

        if(p < 3 || p > 15){
            System.out.printf("%nPanjang Segitiga harus berada dalam rentang angka minimal: 3 dan maksimal: 15%n");
                return;
            }
        for(int i = 1; i <= p; i++){
            for(int x = 1; x <= p - i; x++){
                System.out.printf(" ");
            }
            for(int x = 1; x <= i; x++){
                System.out.printf("*");
            }
            System.out.printf("%n");
        }
        
    }
}

