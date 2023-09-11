import java.util.Scanner;
public class Lesson0304Exercise1{
	public static void main(String[] args) {
		char[] ascii = { 0x221A, 0x00B2, 0x2502, 0x250C, 0x2500, 0x2510, 0x2518, 0x2514 };
		System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[3],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
			ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[5]);
		System.out.printf("%c                %c%n",ascii[2],ascii[2]);
		System.out.printf("%c                %c L %n",ascii[2],ascii[2]);
		System.out.printf("%c                %c%n",ascii[2],ascii[2]);
		System.out.printf("%c                %c%n",ascii[2],ascii[2]);
		System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%n",ascii[7],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],
			ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[6]);
		System.out.printf("         P%n");

		Scanner scanner = new Scanner(System.in);
		int r = 2, p,  l, intA, intB;
		String strP, strL;

		System.out.printf("Sisi panjang (p):");
		strP = scanner.nextLine();
		System.out.printf("Sisi lebar (l):");
		strL = scanner.nextLine();

		p = Integer.parseInt(strP);
		l = Integer.parseInt(strL);

		intA = r * (p + l);
		System.out.printf("%nKeliling Persegi Panjang:%n");
		System.out.printf("= 2 x (p + l)%n");
		System.out.printf("= %d x (%d + %d)%n", r, p, l);
		System.out.printf("= %d cm%n", intA);

		intB = p * l;
		System.out.printf("%nLuas Persegi Panjang%n");
		System.out.printf("= p x l%n");
		System.out.printf("= %d x %d%n", p, l);
		System.out.printf("= %d cm", intB);
	}
}