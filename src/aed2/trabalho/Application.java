package aed2.trabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		List<String> test = new ArrayList<String>(){{
			add("a");
			add("b");
		}};
		System.out.println(test.toString().substring(1, test.size()*3-1));
		System.exit(0);
		System.out.println("Enter with the file path: ");
		Scanner scan = new Scanner(System.in);
		String filePath = scan.nextLine();
		try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
			String line = file.readLine();
			while(line != null) 
			file.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
