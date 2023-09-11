import java.util.Scanner;

public class Lesson05Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] ascii = { 0x221A, 0x00B2, 0x2502, 0x250C, 0x2500, 0x2510, 0x2518, 0x2514 };

        System.out.printf("%nProgram persamaan kuadrat%n");
        System.out.printf("%nax%c + bx + c = 0%n", ascii[1]);
        System.out.printf("          %c%c%c%c%c%c%c%c%c%n", ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4]);
        System.out.printf("    -b + %c b%c - 4ac%n", ascii[0], ascii[1]);
        System.out.printf("x1 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%n", ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4]);
        System.out.printf("            2a%n");
        System.out.printf("          %c%c%c%c%c%c%c%c%c%n", ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4]);
        System.out.printf("    -b - %c b%c - 4ac%n", ascii[0], ascii[1]);
        System.out.printf("x2 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%n", ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4], ascii[4]);
        System.out.printf("            2a%n");
        System.out.printf("Isi Nilai a, b, dan c%n");

        double a, b, c, x1, x2;
        String strA, strB, strC;

        while (true) {
            System.out.printf("%na:");
            strA = scanner.nextLine();
            try {
                a = Double.parseDouble(strA);
                if (a != 0) {
                    break;
                } else {
                    System.out.printf("a tidak boleh = 0");
                }
            } catch (NumberFormatException e) {
                System.out.printf("Input harus berupa angka!");
            }
        }

        while (true) {
            System.out.print("b:");
            strB = scanner.nextLine();
            try {
                b = Double.parseDouble(strB);
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Input harus berupa angka!");
            }
        }

        while (true) {
            System.out.print("c:");
            strC = scanner.nextLine();
            try {
                c = Double.parseDouble(strC);
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Input harus berupa angka!");
            }
        }

        double diskriminan = b * b - 4 * a * c;
        if (diskriminan >= 0) {
            x1 = ((-b) + Math.sqrt(diskriminan)) / (2 * a);
            x2 = ((-b) - Math.sqrt(diskriminan)) / (2 * a);

        System.out.printf("          %c%c%c%c%c%c%c%c%c          %c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("    -b + %c b%c - 4ac    -%.0f + %c %.0f%c - 4 x %.0f x %.0f%n",ascii[0],ascii[1], b, ascii[0], b, ascii[1], a, c);
		System.out.printf("x1 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4], ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("            2a                2 x %.0f%n",a);
		System.out.printf("x1 = %.2f%n", x1);

		System.out.printf("          %c%c%c%c%c%c%c%c%c          %c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("    -b - %c b%c - 4ac    -%.0f - %c %.0f%c - 4 x %.0f x %.0f%n",ascii[0],ascii[1], b, ascii[0], b, ascii[1], a, c);
		System.out.printf("x2 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4], ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
		ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("            2a                2 x %.0f%n",a);
		System.out.printf("x2 = %.2f%n", x2);
        } else {
            System.out.printf("Persamaan tidak memiliki hasil karena b%c - 4ac < 0.", ascii[1]);
        }

        // Jangan lupa tutup scanner setelah selesai
        scanner.close();
    }
}
