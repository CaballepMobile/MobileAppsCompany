package com.example.admin.fridaytestweek3;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        //FIRST PROBLEM
        System.out.println("First Problem:");
        SortingClass.FirstProblem(new int[]{2, 8, 9, 3, 4, 3, 2, 6, 6, 2, 4, 9, 8});

        System.out.println("\n");
        //SECOND PROBLEM
        System.out.println("Second Problem:");
        SkipperChars.SecondProblem("ABCDEF");

    }

    private static class SortingClass{
        public static void FirstProblem(int[] intArray){

            int n = intArray.length;
            int temp = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {

                    if (intArray[j - 1] > intArray[j]) {
                        temp = intArray[j - 1];
                        intArray[j - 1] = intArray[j];
                        intArray[j] = temp;
                    }

                }
            }

            for (int val : intArray){
                System.out.println(val);
            }
        }
    }

    private static class SkipperChars{

        private static List<String> getSubstrings(String text){  //Min Size should be 3

            List<String> substrings = new ArrayList<>();

            int textLength = text.length();

                String str="",substr = "";
                for (int i = 0; i < text.length(); i++) {
                    for (int j = 0; i+j <= text.length(); j++) { //added i+j and equal to comparison
                        substr = text.substring(j, i + j); //changed word.substring(i, i + j) to word.substring(j, i + j)
                        if("".equals(substr))continue; //removing empty substrings
                        if(substr.length() > 2)
                        substrings.add(substr);
                    }
                }

                substrings.add(text);
                return substrings;
        }

        private static List<String> getSingleSkippedSubstrings(String text){

            List<String> skippedSubstrings = new ArrayList<>();
            int textLength = text.length();
            int innerSkipValue = 1;
            int innerSkipPos = 1;
            String newSkippedSubstring = "";

            while(true){

                newSkippedSubstring = text;
                newSkippedSubstring = newSkippedSubstring.replace(text.substring(innerSkipPos, innerSkipPos+innerSkipValue), "");
                innerSkipPos++;

                System.out.println(newSkippedSubstring);

                if(innerSkipPos + innerSkipValue == textLength){ //Means there is no way to find more substrings between first and last character
                    break;
                }

                if(innerSkipPos + innerSkipValue == textLength){
                    skippedSubstrings.add(new String(newSkippedSubstring));
                    innerSkipPos = 1; //Resets the start skip position in the word
                    innerSkipValue++; //Increases the space skipping
                }


            }

            return skippedSubstrings;
        }

        public static void SecondProblem(String text){
            for(String baseSubstring : SkipperChars.getSubstrings(text)){

                System.out.println("Working on Base Substring: " + baseSubstring);
                for(String skippedSubtring : SkipperChars.getSingleSkippedSubstrings(baseSubstring)){
                }

                System.out.println("");
            }
        }

    }
}


