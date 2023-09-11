import java.util.Scanner;

public class Lesson05Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String panjang, sisi;
        int p;

        System.out.printf("Program Membuat Segitiga Siku-siku%n");
        do{
            System.out.printf("Sisi Tegak rata [U]Atas, [T]Bawah, [B] Atas Bawah: ");
            sisi = scanner.nextLine();
        }while(!sisi.equalsIgnoreCase("U") && !sisi.equalsIgnoreCase("u") && !sisi.equalsIgnoreCase("T") && !sisi.equalsIgnoreCase("t") && !sisi.equalsIgnoreCase("B") && !sisi.equalsIgnoreCase("b"));
        do{
            System.out.printf("Masukkan panjang segitiga (3-15): ");
            panjang = scanner.nextLine();
            try{
            p = Integer.parseInt(panjang);
            } catch (NumberFormatException e){
                p = -1;
            }  
        }while(p < 3 || p > 15);
        if(sisi.equals("U") || sisi.equals("u")){
            for(int i = 1; i <= p; i++){
                for(int x = 1; x <= p - i; x++){
                    System.out.printf(" ");
                }
                for(int x = 1; x <= 2 * i - 1; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }
        }else if(sisi.equals("T") || sisi.equals("t")){
            for(int i = p; i >= 1; i--){
                for(int x = 1; x <= p - i; x++){
                    System.out.printf(" ");
                }
                for(int x = 1; x <= 2 * i - 1; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }
        }else if(sisi.equals("B") || sisi.equals("b")){
            for(int i = 1; i <= p; i++){
                for(int x = 1; x <= p - i; x++){
                    System.out.printf(" ");
                }
                for(int x = 1; x <= 2 * i - 1; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }for(int i = p; i >= 1; i--){
                for(int x = 1; x <= p - i; x++){
                    System.out.printf(" ");
                }
                for(int x = 1; x <= 2 * i - 1; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }
        }
    }
}

