package edu.satraining.lesson10.utility;

public class Mathematic{
	public Mathematic(){
		
	}
	public float rectangularArea(int length, int width){
		System.out.printf("rectangularArea(int,int)%n");
		float luas = (float)length * (float)width;
		return luas;
	}
	
	public float rectangularArea(float length, int width){
		System.out.printf("rectangularArea(float,int)%n");
		float luas = length * (float)width;
		return luas;
	}

	public float rectangularArea(float length, float width){
		System.out.printf("rectangularArea(float,float)%n");
		float luas = length * width;
		return luas;
	}
	
	public float rectangularArea(int length, float width){
		System.out.printf("rectangularArea(int,float)%n");
		float luas = (float)length * width;
		return luas;
	}
	
}