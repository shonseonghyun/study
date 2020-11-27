package com.example.spring1;

import java.io.File;

public class a {

	public static void main(String[] args) {

		File file= new File("C:\\Users\\comon\\Desktop\\upload");
		if(file.exists()) {
		
			System.out.println("존재");
		}
		else {
			file.mkdir();
			System.out.println("존재 x");
		}
	}

}
