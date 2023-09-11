import java.util.Scanner;

public class Lesson06Exercise2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] nameOfLesson, gradeOfLesson;
        String inputData, nameOfStudents;
        int numberOfLesson, count;

        System.out.printf("%nProgram Mengelola Nilai Siswa%n");
        /* Read data from keyboard */
        System.out.printf("Nama siswa:");
        nameOfStudents = scanner.nextLine();
        System.out.printf("Jumlah Pelajaran:");
        inputData = scanner.nextLine();
        numberOfLesson = Integer.parseInt(inputData);

        /* Initialization */
        nameOfLesson = new String[numberOfLesson];
        gradeOfLesson = new String[numberOfLesson];

        /* Accessing element, change element value */
        for (count = 0; count < numberOfLesson; count++) {
            System.out.printf("%nNama Pelajaran ke-%d:", count + 1);
            nameOfLesson[count] = scanner.nextLine();
            System.out.printf("Nilai:");
            gradeOfLesson[count] = scanner.nextLine();
        }

        System.out.printf("%nInformasi nilai Siswa%n");
        System.out.printf("Nama Siswa: %s%n", nameOfStudents);
        System.out.printf("%n%n");
        System.out.printf("Hasil Ujian Pelajaran Siswa Diurutkan berdasarkan nilai tertinggi:%n");
        System.out.printf("No.   Pelajaran      Nilai%n");
        System.out.printf("==========================%n");

        // Bubble sort grades in descending order and update corresponding lesson names
        for (int i = 0; i < numberOfLesson - 1; i++) {
            for (int x = 0; x < numberOfLesson - i - 1; x++) {
                if (Integer.parseInt(gradeOfLesson[x]) < Integer.parseInt(gradeOfLesson[x + 1])) {
                    // Swap grades
                    String tempGrade = gradeOfLesson[x];
                    gradeOfLesson[x] = gradeOfLesson[x + 1];
                    gradeOfLesson[x + 1] = tempGrade;

                    // Swap corresponding lesson names
                    String tempLesson = nameOfLesson[x];
                    nameOfLesson[x] = nameOfLesson[x + 1];
                    nameOfLesson[x + 1] = tempLesson;
                }
            }
        }

        for (count = 0; count < numberOfLesson; count++) {
            System.out.printf("%d.    %s             %s%n", count + 1, nameOfLesson[count], gradeOfLesson[count]);
        }
        System.out.printf("==========================");
    }
}
