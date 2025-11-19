package IO;

import java.io.*;

public class BufferedReader01 {
    public static void main(String[] args) throws IOException {
        FileReader flr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(flr);
        String linha;
        while((linha = br.readLine())!= null){
            System.out.println(linha);
        }
    }
}