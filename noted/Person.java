package edu.satraining.lesson11.model;

import java.util.Date;

public class Person {
	private String nama;
	private String jenisKelamin;
	private Date tanggalLahir;
	private String tempatLahir;

	public Person(){
		super();
	}
	public Person(String nama, String jenisKelamin, Date tanggalLahir, String tempatLahir){
		super();
		this.nama = nama;
		this.jenisKelamin = jenisKelamin;
		this.tanggalLahir = tanggalLahir;
		this.tempatLahir = tempatLahir;
	}
	public void setNama(String nama){
		this.nama = nama;
	}
	public String getNama(){
		return nama;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}
	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setTanggalLahir(Date tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}
	public Date getTanggalLahir(){
		return tanggalLahir;
	}
	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}
	public String getTempatLahir(){
		return tempatLahir;
	}
}