import java.util.Locale;

public class Lesson02Exercise{
	public static void main(String args[]){
		String name = "Christopher Michael Pratt";
		String gender = "Laki - Laki";
		int age = 44;
		double height = 1.85;

		System.out.printf("Info Aktor Favorite%n");
		System.out.printf("Nama: %s%n", name);
		System.out.printf("Jenis Kelamin: %s%n", gender);
		System.out.printf("Umur: %d%n", age);
		System.out.printf("Tinggi Badan: %f m%n", height);
	
		System.out.printf("%nNama: %s, Jenis Kelamin: %s, Umur: %d Tahun, Tinggi Badan: %f m%n", name, gender, age, height);

		System.out.printf("%nInfo Aktor Favorite%n");
		System.out.printf("Nama         : %s%n", name);
		System.out.printf("Jenis Kelamin: %s%n", gender);
		System.out.printf("Umur         : %d Tahun%n", age);
		System.out.printf(new Locale("in", "ID"),"Tinggi Badan : %.2f m%n", height);
	}
}