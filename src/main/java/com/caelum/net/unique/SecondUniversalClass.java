package com.caelum.net.unique;

import java.io.IOException;

public class SecondUniversalClass {
    public int powTwoSum(int a, int b) throws IOException {
        if (a >= 1000000 || b >= 1000000) {
            System.out.println("Number is too much!");
        } else {
            System.out.println("Result is: " + Math.pow(a, b));
        }

        return a;
    }

    public int multipleTwoSum(int a, int b) {
        return a * b;
    }

    public int fizzBuzz(int begin, int end) {
        int number = 0;

        while (number < 9) {
            number++;
        }

        return number;
    }

    public static String getHiddenCard(String card, int cardLength) {
        if (card.length() > 16) {
            System.out.println("Card length is more than usual.");
        } else {
            if (cardLength >= 1) {
                String star = "*";
                System.out.println(star.repeat(cardLength) + card.substring(12));
            } else {
                System.out.println("NO!");
            }
        }

        return card;
    }

    public static String getHiddenCard(String card) {
        return getHiddenCard(card, 4);
    }

    public static double powTwoNumbers(double a, int b) {
        return Math.pow(a, b);
    }

    public static boolean isPalindrome(String word) {
        String lowerCase = word.toLowerCase();
        String words = new StringBuilder(word).reverse().toString();

        return lowerCase.equals(words);
    }

    public boolean isPalindromeSecond(String word) {
        String lowerCase = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String words = new StringBuilder(lowerCase).reverse().toString();

        return lowerCase.equals(words);
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0) && (year != 100);
    }

    public static String convertString(String word) {
        if (word.isEmpty()) {
            return "";
        } else if (Character.isUpperCase(word.charAt(0))) {
            return word;
        } else {
            return new StringBuilder(word).reverse().toString();
        }
    }

    public static String printNumbers(int firstNumber) {
        int i = firstNumber;

        String message = "finished";

        while (i >= 1) {
            System.out.println(i);
            i--;
        }

        return message;
    }

    public static int sumNumbersFromRange(int start, int finish) {
        int i = start;
        int sum = 0;

        while (start <= finish) {
            sum = sum + i;
            i = i + 1;
        }

        return sum;
    }

    public static void printWordBySymbol(String word) {
        int i = 0;

        while (i < word.length()) {
            System.out.println(word.charAt(i));
            i += 1;
        }
    }

    public static String reverseStrings(String str) {
        int i = 0;

        String result = "";

        while (i < str.length()) {
            result = str.charAt(i) + result;
            i += 1;
        }

        return result;
    }

    public static String joinNumbersFromRange(int start, int finish) {
        StringBuilder result = new StringBuilder();
        int sum = start;

        while (sum <= finish) {
            result.append(sum);

            if (sum < finish) {
                result.append("");
            }
            sum++;
        }

        return result.toString();
    }

    public static void printWord(String word) {
        System.out.println("Your word: " + word);
    }

    public static int countChars(String str, char ch) {
        int i = 0;
        int count = 0;
        char result = Character.toLowerCase(ch);

        while (i < str.length()) {
            char charA = Character.toLowerCase(str.charAt(i));
            if (charA == result) {
                count++;
            }

            i++;
        }

        return count;
    }

    public static String encrypt(String strEnc) {
        StringBuilder encMessage = new StringBuilder();

        for (int i = 0; i < strEnc.length() - 1; i += 2) {
            char first = strEnc.charAt(i);
            char second = strEnc.charAt(i + 1);

            encMessage.append(second).append(first);
        }

        if (strEnc.length() % 2 != 0) {
            encMessage.append(strEnc.charAt(strEnc.length() -1));
        }

        return encMessage.toString();
    }

    public static void CalculatorOnJava (int a, String operator, int b) {
        switch (operator) {
            case "*" -> System.out.println(a * b);
            case "/" -> System.out.println(a / b);
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            case "**" -> System.out.println(Math.pow(a, b));
            case "^" -> System.out.println("this function coming soon...");

            case ">" -> {
                if (a > b) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            case ">=" -> {
                if (a >= b) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            case "<" -> {
                if (a < b) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            case "<=" -> {
                if (a <= b) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            case "=", "==" -> {
                if (a == b) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            default -> System.out.println("undefined operator!");
        }
    }
}
