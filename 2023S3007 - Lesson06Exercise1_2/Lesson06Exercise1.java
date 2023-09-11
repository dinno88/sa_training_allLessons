import java.util.Scanner;

public class Lesson06Exercise1{
	public static void main(String args[]){
		/*Declaration and Initialization*/
		Scanner scanner = new Scanner(System.in);
		String[] nameOfStudents;
		String inputData;
		int numberOfStudent, count;
		
		/*Read data from keyboard*/
		System.out.printf("%nJumlah siswa:");
		inputData = scanner.nextLine();
		numberOfStudent = Integer.parseInt(inputData);
		
		/*Initialization*/
		nameOfStudents = new String[numberOfStudent];
		
		/*Accesing element, change element value*/
		for(count = 0; count < numberOfStudent; count++){
			System.out.printf("Nama Siswa ke-%d:", count+1);
			nameOfStudents[count] = scanner.nextLine();
		}
		 // Sorting the names in ascending order
        for (int i = 0; i < numberOfStudent - 1; i++) {
            for (int x = 0; x < numberOfStudent - i - 1; x++) {
                if (nameOfStudents[x].compareToIgnoreCase(nameOfStudents[x + 1]) > 0) {
                    String temp = nameOfStudents[x];
                    nameOfStudents[x] = nameOfStudents[x + 1];
                    nameOfStudents[x + 1] = temp;
                }
            }
        }
		
		System.out.printf("%nJumlah Siswa yang tercatat adalah: %d%n", numberOfStudent);
		System.out.printf("Nama Siswa yang diurutkan berdasarkan abjad adalah sebagai berikut:%n");
		for(count = 0; count < numberOfStudent; count++){
			if(count > 0){
				System.out.printf("%n");	
			}
			System.out.printf("%d. %s", count+1, nameOfStudents[count]);
		}
	}
}