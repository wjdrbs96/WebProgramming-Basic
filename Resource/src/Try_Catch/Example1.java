package Try_Catch;

import java.io.BufferedReader;
import java.io.FileReader;

public class Example1 {
	
	public static void printFile(String ���ϸ�) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(���ϸ�));
		String s;
		
		while((s = reader.readLine()) != null) {
			System.out.println(s);
		}
		reader.close();
	}
	
	public static void main(String[] args) throws Exception {
		String ���ϸ� = "C:/text/text.txt";
		printFile(���ϸ�);
		
	}
	
	

}
