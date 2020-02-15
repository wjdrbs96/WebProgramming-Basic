package Try_Catch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example2 {
	public static void printFile(String 파일명) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(파일명));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} finally {
			if (reader != null) reader.close();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String 파일명 = "C:/text/text.txt";
		printFile(파일명);
	}

}
