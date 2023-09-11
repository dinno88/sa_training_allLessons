import java.util.Scanner;

public class StudentRegistration {
    /* fields */
    Student[] students;
    Classroom classroom = new Classroom();
    School school = new School();

    /* Constructor */
    public StudentRegistration() {
        System.out.printf("Student Registration Constructor invoke... %n");
    }

    /* Method */
    public void readData() {

        Scanner scanner = new Scanner(System.in);
        String inputData;
        int countStudent, count;

        /* read school info */
        System.out.printf("%nProgram Pengelola data Pelajar%n");
        System.out.printf("Informasi Sekolah:%n");
        System.out.printf("Nama Sekolah:");
        inputData = scanner.nextLine();
        school.setName(inputData);
        System.out.printf("Alamat Sekolah:");
        inputData = scanner.nextLine();
        school.setAddress(inputData);

        System.out.printf("%nInformasi Kelas:");
        System.out.printf("Tingkat (SD / SMP / SMA):");
        inputData = scanner.nextLine();
        while (!inputData.equalsIgnoreCase("SD") && !inputData.equalsIgnoreCase("SMP") && !inputData.equalsIgnoreCase("SMA") && !inputData.equalsIgnoreCase("sd") && !inputData.equalsIgnoreCase("smp") && !inputData.equalsIgnoreCase("sma")) {
                System.out.println("Tingkat sekolah hanya boleh 'SD/sd', 'SMP/smp' dan 'SMA/sma'. Silakan coba lagi.");
                System.out.printf("Tingkat (SD / SMP / SMA):");
                inputData = scanner.nextLine();
            }
        classroom.setLevel(inputData);

        System.out.printf("Nama Kelas:");
        inputData = scanner.nextLine();
        classroom.setName(inputData);

        System.out.printf("Jumlah Pelajar:");
        inputData = scanner.nextLine();
        countStudent = Integer.parseInt(inputData);
        students = new Student[countStudent];

        for (count = 0; count < countStudent; count++) {
            Student student = new Student();
            System.out.printf("%nPelajar ke-%d%n", count + 1);
            System.out.printf("NISN:");
            inputData = scanner.nextLine();
            while (!inputData.matches("\\d+")) {
                System.out.println("NISN hanya boleh diisi dengan angka. Silakan coba lagi.");
                System.out.printf("NISN (angka):");
                inputData = scanner.nextLine();
            }
            student.setNisn(inputData);

			System.out.printf("Nama:");
            inputData = scanner.nextLine();
            while (!inputData.matches("[a-zA-Z ]{4,}")) {
                System.out.println("Nama hanya boleh diisi dengan huruf dan minimal 4 karakter. Silakan coba lagi.");
                System.out.printf("Nama (huruf, minimal 4 karakter):");
                inputData = scanner.nextLine();
            }
            student.setName(inputData);

            System.out.printf("Jenis Kelamin(Laki - Laki / Perempuan):");
            inputData = scanner.nextLine();
            while (!inputData.equalsIgnoreCase("Laki - Laki") && !inputData.equalsIgnoreCase("laki - laki") && !inputData.equalsIgnoreCase("Laki - laki") && !inputData.equalsIgnoreCase("LAKI - LAKI") && !inputData.equalsIgnoreCase("Laki-Laki")
            	&& !inputData.equalsIgnoreCase("laki-laki") && !inputData.equalsIgnoreCase("LAKI-LAKI") && !inputData.equalsIgnoreCase("Laki-laki") && !inputData.equalsIgnoreCase("Laki") && !inputData.equalsIgnoreCase("laki") && !inputData.equalsIgnoreCase("LAKI")
            	&& !inputData.equalsIgnoreCase("Perempuan") && !inputData.equalsIgnoreCase("PEREMPUAN") && !inputData.equalsIgnoreCase("perempuan") && !inputData.equalsIgnoreCase("L") && !inputData.equalsIgnoreCase("P")) {
                System.out.println("Jenis kelamin hanya boleh 'Laki - Laki' atau 'Perempuan'. Silakan coba lagi.");
                System.out.printf("Jenis Kelamin(Laki - Laki / Perempuan):");
                inputData = scanner.nextLine();
            }
            student.setGender(inputData);

            System.out.printf("Alamat:");
            inputData = scanner.nextLine();
            student.setAddress(inputData);
            students[count] = student;
        }
    }

	public void sortingData() {
	    Student studentTemp;
	    int countStudent = students.length;
	    for (int i = 0; i < countStudent - 1; i++) {
	        for (int x = 0; x < countStudent - i - 1; x++) {
	            if (students[x].getName().compareToIgnoreCase(students[x + 1].getName()) > 0) {
	                studentTemp = students[x];
	                students[x] = students[x + 1];
	                students[x + 1] = studentTemp;
	            }
	        }
	    }
	}


    public void showData() {
        int countStudent = students.length;
        System.out.printf("%nInformasi Sekolah:%n");
        System.out.printf("Nama Sekolah: %s%n", school.getName());
        System.out.printf("Alamat: %s%n", school.getAddress());
        System.out.printf("%nInformasi Kelas:%n");
        System.out.printf("Tingkat: %s%n", classroom.getLevel());
        System.out.printf("Nama Kelas: %s%n", classroom.getName());
        System.out.printf("%n%-3s %-5s %15s %22s %s%n", "No", "NISN", "NAMA", "JENIS-KELAMIN", "ALAMAT");
        System.out.printf("======================================================%n");
        for (int count = 0; count < countStudent; count++) {
            Student student = students[count];
            System.out.printf("%3d %-15s %-15s %10s %-10s%n", count+1, student.getNisn(), student.getName(), student.getGender(), student.getAddress());
        }
        System.out.printf("======================================================%n");
    }
}
