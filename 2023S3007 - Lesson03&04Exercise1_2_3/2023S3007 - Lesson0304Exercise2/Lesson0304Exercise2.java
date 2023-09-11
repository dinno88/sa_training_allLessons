import java.util.Scanner;
public class Lesson0304Exercise2{
	public static void main(String[] args) {
		char[] ascii = { 0x221A, 0x00B2, 0x2502, 0x250C, 0x2500, 0x2510, 0x2518, 0x2514 };
		System.out.printf("%n             /%c%n",ascii[2]);
		System.out.printf("            / %c%n",ascii[2]);
		System.out.printf("           /  %c B %n",ascii[2]);
		System.out.printf("        C /   %c%n",ascii[2]);
		System.out.printf("         /    %c%n",ascii[2]);
		System.out.printf("        %c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[6]);
		System.out.printf("           A%n%n");
		System.out.printf("     %c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("C = %c a%c + b%c%n", ascii[0], ascii[1],ascii[1]);
		System.out.printf("a = Sisi datar%n");
		System.out.printf("b = Sisi tegak%n");
		System.out.printf("c = Sisi miring%n");

		Scanner scanner = new Scanner(System.in);
		int a, b;
		double dbC;
		String strA, strB;
		System.out.printf("%nSisi Datar (a):");
		strA = scanner.nextLine();
		System.out.printf("Sisi Tegak (b):");
		strB = scanner.nextLine();

		a = Integer.parseInt(strA);
		b = Integer.parseInt(strB);
		dbC = Math.sqrt(a * a + b * b);

		System.out.printf("%n Sisi Miring%n");
		System.out.printf("     %c%c%c%c%c%c%c%n",ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4],ascii[4]);
		System.out.printf("C = %c a%c +b%c%n", ascii[0], ascii[1],ascii[1]);
		System.out.printf("C = %d + %d%n", a, b);/*Di bagian ini jika ditambahkan %c dan kode ascii menjadi error,
		 tapi ketika %c dan kode ascii dihapus berjalan normal, saya belum menemukan solusinya.*/
		System.out.printf("C = %f%n", dbC);
	}
}