package com.andi;

import java.io.*;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {


        // read from file (bytes) -
        File file = new File("src/test.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            System.out.println("Total size to read in bytes is: " + fileInputStream.available());

            int content;
            while ( (content = fileInputStream.read()) !=-1) {
                //convert to char and display
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // write to file
        // create a new file
        File writeFile  = new File("src/MyFile.txt");

        try(FileWriter fileWriter = new FileWriter(writeFile)){
            fileWriter.write("this is amazing");
            fileWriter.close();

            // read it back with buffered reader instead of reading bytes
            // buffered reader - allows to read each line -> String
            FileReader fileReader = new FileReader(writeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
