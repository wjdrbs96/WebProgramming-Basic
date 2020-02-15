package Try_Catch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example2 {
	public static void printFile(String ���ϸ�) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(���ϸ�));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} finally {
			if (reader != null) reader.close();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String ���ϸ� = "C:/text/text.txt";
		printFile(���ϸ�);
	}

}
