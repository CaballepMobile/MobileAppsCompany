package com.example.admin.daily_2.JavaFun;

import java.util.Arrays;

public class AnagramMaster {
    public static void PrintAnagramStatus(String word1, String word2){

        if(word1.length() == word2.length()){
            char word1Array[] = word1.toCharArray();
            char word2Array[] = word2.toCharArray();

            Arrays.sort(word1Array);
            Arrays.sort(word2Array);

            if(Arrays.equals(word1Array, word2Array)){
                System.out.println("An anagram");
            }else{
                System.out.println("Not an anagram");
            }

        }else{
            System.out.println("Not an anagram");
        }
    }
}