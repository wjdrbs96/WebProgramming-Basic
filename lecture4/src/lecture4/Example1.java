package lecture4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Example1 {

    static void printFile(String 파일명) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(파일명));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        String 파일명 = "C:/text/text.txt";
        printFile(파일명);
    }
}
