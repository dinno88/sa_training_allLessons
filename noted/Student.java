package edu.satraining.lesson11.model;

import java.util.Date;

public class Student extends Person{
	private String nis;
	private String grade;
	public Student(){

	}
	public Student(String nis, String grade, String nama, String jenisKelamin, Date tanggalLahir, String tempatLahir){
		super(nama, jenisKelamin, tanggalLahir, tempatLahir);
		this.nis = nis;
		this.grade = grade;
	}
	public void setNis(String nis){
		this.nis = nis;
	}
	public String getNis(){
		return nis;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}
	public String getGrade(){
		return grade;
	}
}