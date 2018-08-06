package com.jda.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
	
	public String getInputStringline() throws IOException {
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader reader=new BufferedReader(input);
		String name = reader.readLine();
		return name;
	}
}
