package com.caelum.net.unique;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

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
        System.out.printf("Статус: %s, Покушали %s", status, Arrays.toString(product));
    }

    public static String whoLikesIt(String ...names) {
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + " like this";
            case 2 -> names[0] + " and " + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + "like this";
            case 4 -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
            default -> "";
        };

    }

    public static int findIt (int[] a) {
        int xor = 0;

        for (int i : a) {
            xor = xor ^ i;
        }

        return xor;
    }

    public static double upgradedPow (double a, double b) throws IllegalArgumentException {
        if (a >= 1000000) {
            try {
                System.out.println("A can't be >= 1000000");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
            }
        } else if (a <= -1) {
            try {
                System.out.println("A can't be <= 1");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                double result = Math.pow(a, b);
                return result;
            }

            i = i + i;
        }

        return Double.parseDouble(Double.toString(Math.pow(a, b)));
    }

    public int newMethod (Integer test, String username, int amount) {
        test = amount;

        if (username.isEmpty()) {
            System.out.println("Nah-nah-nah, username cannot be an empty!");
        } else if (test == 0) {
            System.out.println("Unacceptable test :D");
        } else {
            System.out.printf("Username is: %s, his amount: %d",
                    username, amount);
        }

        for (int i = 0; i < amount; i++) {
            i = i + i;
            System.out.println(i);
        }

        Collection<Integer> user = new Collection<Integer>() {
            @Override
            public int size() {
                System.out.println(username);
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        return 0;
    }

    public static int[] sortArray(int[] array) {
        int begin = 0;
        int finish = 0;

        for (int i = 0; i < array.length; i++) {
            i = array[begin] + array[finish];
        }

        return array;
    }

    public static String fizzBuzz (int number) {
        if (number % 3 == 0 || number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
