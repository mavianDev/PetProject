package com.caelum.net.unique;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecondUniversalClass implements Runnable {
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

    @Override
    public void run() {
       for (int i = 0; i < 10; i++) {
           System.out.println(i);
       }
    }

    public void feed (Boolean status, String... product) {
        System.out.printf("Статус: %s, Покушали %s"
                + status, Arrays.toString(product));
    }

    public static String whoLikesIt(String ...names) {
        if(names.length == 0) {
            return "no one likes this";
        }

        else if(names.length == 1) {
            return names[0] + " likes this";
        }

        else if(names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
        }

        else if(names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        }

        else if (names.length > 3) {
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        }
        return "";
    }

    public static int findIt (int[] a) {
        int xor = 0;

        for (int i : a) {
            xor = xor ^ i;
        }

        return xor;
    }

//    public Exception CheckSite (Boolean SSLConnection) throws IOException {
//
//    }
}
