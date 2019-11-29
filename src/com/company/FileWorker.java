package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorker {
    public static void write(String fileName, String text) {
        //define the file
        File file = new File(fileName);

        try {
            //checks is the file exists and creates it if not
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter provides the possibility to write in the file
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //writes text in the file
                out.print(text);
            } finally {
                //we need to close the file, bcause data will be not written
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void print(String pathToFile) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get(pathToFile))));
    }

}

