package Try_Catch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example3 {
	public static void printFile(String 파일명) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(파일명))) {
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String 파일명 = "C:/text/text.txt";
		printFile(파일명);
	}

}
