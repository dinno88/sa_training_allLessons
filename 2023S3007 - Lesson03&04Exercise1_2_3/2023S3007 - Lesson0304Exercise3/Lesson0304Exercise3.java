import java.util.Scanner;
public class Lesson0304Exercise3{
	public static void main(String[] args) {
		char[] ascii = { 0x221A, 0x00B2, 0x2502, 0x250C, 0x2500, 0x2510, 0x2518, 0x2514 };
		System.out.printf("%nProgram persamaan kuadrat%n");
		System.out.printf("%nax%c + bx + c = 0%n", ascii[1]);
		System.out.printf("          %c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("    -b + %c b%c - 4ac%n",ascii[0],ascii[1]);
		System.out.printf("x1 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("            2a%n");
		System.out.printf("          %c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("    -b - %c b%c - 4ac%n",ascii[0],ascii[1]);
		System.out.printf("x2 = %c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("            2a%n");
		System.out.printf("Isi Nilai a, b, dan c%n");

		Scanner scanner = new Scanner(System.in);
		double a, b, c, x1, x2;
		String strA, strB, strC;
		System.out.printf("%n a:");
		strA = scanner.nextLine();
		System.out.printf(" b:");
		strB = scanner.nextLine();
		System.out.printf(" c:");
		strC = scanner.nextLine();

		a = Double.parseDouble(strA);
		b = Double.parseDouble(strB);
		c = Double.parseDouble(strC);
		x1 = ((-b) + Math.sqrt(b*b - 4*a*c))/(2*a);
		x2 = ((-b) - Math.sqrt(b*b - 4*a*c))/(2*a);

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
	}
}