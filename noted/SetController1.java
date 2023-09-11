package edu.satraining.lesson11.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class SetController1 {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public void showResult(){
		// Declaration
		Set<Student> students;
		Student christian = null, moses = null, rafael = null, sigit = null;
		Student otherSigit = null;
			try{
				christian = new Student("001", "8", "Christian", "Laki-Laki", sdf.parse("01-01-2008"), "Bandung");
				moses = new Student("002", "8", "Moses", "Laki-Laki", sdf.parse("02-02-2008"), "Bandung");
				rafael = new Student("003", "8", "Rafael", "Laki-Laki", sdf.parse("03-03-2008"), "Bandung");
				sigit = new Student("004", "8", "Sigit", "Laki-Laki", sdf.parse("04-04-2008"), "Bandung");
				otherSigit = new Student("005", "8", "Sigit", "Laki-Laki", sdf.parse("04-04-2008"), "Bandung");
			}catch(ParseException e){
				e.printStackTrace();
			}
			// Initialization
			students = new HashSet<Student>();
			System.out.printf("After initialization, Set Size: %d%n", students.size());
			// add element to set
			students.add(christian);
			students.add(moses);
			students.add(sigit);
			System.out.printf("Add second Christian%n");
			students.add(christian);

			System.out.printf("Element Set after add....%n");
			showSetContent(students);

			//menghapus elemen christian
			students.remove(christian);
			System.out.printf("%nAfter remove element 'christian', set size:%d%n", students.size());

			System.out.printf("%n Element Set after remove using index.... %n");
			showSetContent(students);

			//menambah elemen Rafael
			students.add(rafael);
			System.out.printf("%nElement Set after add....%n");
			showSetContent(students);

			//memeriksa apakah element sigit ada di dalam set

			System.out.printf("%nnis element 'Sigit' exist in set: %b%n", students.contains(sigit));

			public void showSetContent(Set<Student> students){
				int i = 0;
				System.out.printf("%3s %-8s %-6s %-20s %-16s %-16s%n", "No", "Nis", "Grade", "Nama", "Jenis Kelamin", "Tanggal-Lahir", "Tempat-Lahir");
				System.out.printf("====================================================================================%n");
				for (Student students : students){
					System.out.printf("%3s %-8s %-6s %-20s %-16s %-16s %-16s%n",
						++i,
						students.getNis(),
						students.getGrade(),
						students.getNama(),
						students.getJenisKelamin(),
						sdf.format(student.getTanggalLahir()),
						students.getTempatLahir());
				}
				System.out.printf("====================================================================================%n");
			}

	}
}