package exceptions;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        String filePath = "/Users/rahulgrover/Scaler/LLD/IntJul24/oops/src/executors/Main"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }

}
