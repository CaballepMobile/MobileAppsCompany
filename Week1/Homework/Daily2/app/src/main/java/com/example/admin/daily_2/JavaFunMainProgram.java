package com.example.admin.daily_2;

import com.example.admin.daily_2.JavaFun.AnagramMaster;
import com.example.admin.daily_2.JavaFun.DuplicateFinder;
import com.example.admin.daily_2.JavaFun.FizzBuzzTool;
import com.example.admin.daily_2.JavaFun.MultiplicationTableEpicClass;
import com.example.admin.daily_2.JavaFun.PalindromeTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaFunMainProgram {
    public static void main (String args[]){

        //Problem 1
        System.out.println("------[PROBLEM 1]------ \n");
        String[] stringArray = new String[]{"A", "B", "C", "B", "D", "A"};
        List<String> stringArrayList = new ArrayList<>(Arrays.asList(stringArray));
        DuplicateFinder.PrintDuplicates(stringArrayList);

        //Problem 2
        System.out.println("\n------[PROBLEM 2]------ \n");
        String word1 = "not a palindrome";
        String word2 = "hannah"; //Perfect palindrome
        String word3 = "palindromemordnilap"; //Palindrome

        PalindromeTool.PrintPalindromeWordStatus(word1);
        PalindromeTool.PrintPalindromeWordStatus(word2);
        PalindromeTool.PrintPalindromeWordStatus(word3);

        //Problem 3
        System.out.println("\n------[PROBLEM 3]------ \n");
        for (int i = 1; i <= 20; i++){
            FizzBuzzTool.FizzBuzzChecker(i);
        }

        //Problem 4
        System.out.println("\n------[PROBLEM 4]------ \n");
        String COAT = "COAT", TACO = "TACO"; //Anagram
        String ABDC = "ABDC", ACWR = "ACWR"; //Not an anagram
        String ABC = "ABC", ABCD = "ABCD"; //Not an anagram

        AnagramMaster.PrintAnagramStatus(COAT, TACO);
        AnagramMaster.PrintAnagramStatus(ABDC, ACWR);
        AnagramMaster.PrintAnagramStatus(ABC, ABCD);

        //Problem 5
        System.out.println("\n------[PROBLEM 5]------ \n");
        MultiplicationTableEpicClass.PrintTable10x10();
    }
}