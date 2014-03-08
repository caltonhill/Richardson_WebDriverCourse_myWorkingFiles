package com.seleniumtraining;

import java.util.Scanner;

/**
 * Created by Macdonald on 05/03/14.
 */
public class WillDelete {
    public static void main (String args[]){

        Scanner testScanner = new Scanner(System.in);

        System.out.print("Enter string to be tested: ");

        String testString = testScanner.next();
        System.out.println("testString is: " + testString);
        String reversed = "";
        int length = testString.length();

        for ( int i = length - 1 ; i >= 0 ; i-- )
            reversed = reversed + testString.charAt(i);
        System.out.println("reversed is: " + reversed);

        if (testString.equals(reversed)){
            System.out.println("That is a palindrome");

        }
            else {
                System.out.println("That is not a palindrome");
        }

    }

}
