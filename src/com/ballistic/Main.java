package com.ballistic;


import java.util.List;

/**
 * @author  Nabeel on 11/27/2017.
 */
public class Main {

    /*************************************************************************************
     *  mean method for start the process
     *  @variable readWriteFile is used to fetch the data from the file
     *  @methodCall openFile is used to open the File
     *  @variable fileInput is used to store the all data from the file
     *  @variable palindromeProcess is the class varaible that used as instance
     *
     **************************************************************************************/
    public static void main(String[] args) {
	// write your code here
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.openFile();
        List<String> fileInput = readWriteFile.readFile();
        PalindromeProcess palindromeProcess = new PalindromeProcess();

        fileInput.forEach(line -> System.out.println("Is line Palindrome or Not:- " +
                (palindromeProcess.isPalindrome(line) == true ? line + " -: are Palindrome." : line + " -: are not Palindrome.")));
        System.out.println("Total Number of line in File:- " + palindromeProcess.countLines(fileInput));
        System.out.println("Total Nuber of Word in line's of File:- " + palindromeProcess.getTotalWords(fileInput));
        fileInput.forEach(line -> System.out.println("Words Per line:- " + palindromeProcess.getWordsPerLine(line)));
        System.out.println("Total Number of Char in line's of File:- " + palindromeProcess.getTotalChar(fileInput));
        fileInput.forEach(line -> System.out.println("Char Per line:- " + palindromeProcess.getCharPerLine(line)));
        System.out.println("Total Number of Vowel in line's of File:- " + palindromeProcess.getTotalVowel(fileInput));
        fileInput.forEach(line -> System.out.println("Space per line:- " + palindromeProcess.getSpacePerLine(line)));
        System.out.println("Total Number of Space in line's of File:- " + palindromeProcess.getTotalSpace(fileInput));

    }

}
