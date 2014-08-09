package com.io.base;
import java.io.File;
import java.io.IOException;

public class Keybord {

	public static void main(String[] args) throws IOException {
		int i = 0;
		
		while((i = System.in.read()) != -1){
			System.out.write(i);
		}
	}
}
