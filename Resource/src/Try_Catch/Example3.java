package Try_Catch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example3 {
	public static void printFile(String ���ϸ�) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(���ϸ�))) {
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String ���ϸ� = "C:/text/text.txt";
		printFile(���ϸ�);
	}

}
