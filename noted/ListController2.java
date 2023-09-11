package edu.satraining.lesson11.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.satraining.lesson11.model.Student;

public class ListController2 
{
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public void showResult()
	{
		/* declaration */
		List<Student> students;
		Student christian = null,
				moses = null,
				rafael = null,
				sigit = null;
		Student otherSigit = null;	
		
		try
		{
			christian = new Student("001", "8", "Christian", "Laki-laki", sdf.parse("01-01-2008"), "Bandung");
			moses = new Student("002", "8", "Moses", "Laki-laki", sdf.parse("02-02-2008"), "Bandung");
			rafael = new Student("003", "8", "Rafael", "Laki-laki", sdf.parse("03-03-2008"), "Bandung");
			sigit = new Student("004", "8", "Sigit", "Laki-laki", sdf.parse("04-04-2008"), "Bandung");
			otherSigit = new Student("004", "8", "Sigit", "Laki-laki", sdf.parse("04-04-2008"), "Bandung");
		}
		
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		/* initialization */
		students = new ArrayList<Student>();
		System.out.printf("After initialization, List size: %d%n", students.size());
		
		/* add element to List */
		students.add(christian); /* menambah elemen ke-1 */
		students.add(moses); /* menambah elemen ke-2 */
		students.add(sigit); /* menambah elemen ke-3 */
		
		System.out.printf("%nElement List after add..%n");
		showListContent(students);
		
		/* Menghapus elemen ke-1 */
		students.remove(0);
		System.out.printf("%nAfter remove element with index 0, List size: %d%n", students.size());
		
		System.out.printf("%nElement List after remove using index...%n");
		showListContent(students);
		
		/* menambah elemen dan disisipkan di posisi ke-2 */
		students.add(1, rafael);
		System.out.printf("%nElement List after add with index...%n");
		showListContent(students);
		
		/* menghapus elemen 'Rafael' (tanpa kita tahu 'Rafael' ada di index berapa) */
		students.remove(rafael);
		System.out.printf("%nElement List after remove using element...%n");
		showListContent(students);
		
		/* mendapatkan posisi element dalam List */
		System.out.printf("%nPosition of element 'moses' : %d%n", students.indexOf(moses)+1);
		
		/* memeriksa apakah element 'Sigit' ada dalam List */
		System.out.printf("%nis element 'Sigit' exist in List : %b%n", students.contains(sigit));
		
		/* memeriksa apakah element 'Other Sigit' ada dalam List */
		System.out.printf("%nis element 'Sigit' exist in List : %b%n", students.contains(otherSigit));
	}	
		
		
	public void showListContent(List<Student> students)
	{
		int i = 0;
		System.out.printf("%3s %-8s %-6s %-20s %-16s %-16s %-16s%n", "No", "NIS", "Grade", "Nama", "Jenis Kelamin", "Tanggal Lahir", "Tempat Lahir");
		System.out.printf("==========================================================================================%n");
		
		for (Student student : students)
		{
				System.out.printf("%3s %-8s %-6s %-20s %-16s %-16s %-16s%n",
						++i,
						student.getNis(),
						student.getGrade(),
						student.getNama(),
						student.getJenisKelamin(),
						sdf.format(student.getTanggalLahir()),
						student.getTempatLahir());
				
		}
	
		System.out.printf("==========================================================================================%n");
				
	}
	
		
	
}
