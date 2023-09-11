import java.util.Scanner;

public class Lesson05Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String panjang, sisi;
        int p;

        System.out.printf("Program Membuat Segitiga Siku-siku%n");
        do{
            System.out.printf("Sisi Tegak rata [L]Kiri, [R]Kanan: ");
            sisi = scanner.nextLine();
        }while(!sisi.equalsIgnoreCase("L") && !sisi.equalsIgnoreCase("l") && !sisi.equalsIgnoreCase("R") && !sisi.equalsIgnoreCase("r"));
        do{
            System.out.printf("Masukkan panjang segitiga (3-15): ");
            panjang = scanner.nextLine();
            try{
            p = Integer.parseInt(panjang);
            } catch (NumberFormatException e){
                p = -1;
            }  
        }while(p < 3 || p > 15);
        if(sisi.equals("R") || sisi.equals("r")){
            for(int i = 1; i <= p; i++){
                for(int x = 1; x <= p - i; x++){
                    System.out.printf(" ");
                }
                for(int x = 1; x <= i; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }
        }else if(sisi.equals("L") || sisi.equals("l")){
            for(int i = 1; i <= p; i++){
                for(int x = 1; x <= i; x++){
                    System.out.printf("*");
                }
                System.out.printf("%n");
            }
        }
    }
}

