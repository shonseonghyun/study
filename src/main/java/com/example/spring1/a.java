package com.example.spring1;

import java.io.File;

public class a {

	public static void main(String[] args) {

		File file= new File("C:\\Users\\comon\\Desktop\\upload");
		if(file.exists()) {
		
			System.out.println("����");
		}
		else {
			file.mkdir();
			System.out.println("���� x");
		}
	}

}
