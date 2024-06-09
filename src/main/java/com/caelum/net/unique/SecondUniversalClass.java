package com.caelum.net.unique;

import java.io.*;

public class SecondUniversalClass {
    public static void FileExample () {
        BufferedReader bufferedReader = null;

        try {
            File file = new File("created.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("Hello, World!");

            for (int i = 0; i < 10; i++) {
                printWriter.println("\n" + i);
            }

            printWriter.close();

            bufferedReader = new BufferedReader(new FileReader("created.txt"));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("error 404" + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("error 404" + e);
            }
        }
    }
}
