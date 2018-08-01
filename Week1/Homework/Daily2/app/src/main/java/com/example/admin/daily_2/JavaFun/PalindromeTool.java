package com.example.admin.daily_2.JavaFun;

public class PalindromeTool {
    public static void PrintPalindromeWordStatus(String word){
        int right = word.length()-1;
        boolean isPalindrome = true;
        for(int left = 0; left <= right; left++){
            if(word.charAt(left) != word.charAt(right)){
                isPalindrome = false;
                System.out.println("Not a palindrome");
                break;
            }
            right--;
        }
        if(isPalindrome)
        System.out.println("Is a palindrome");
    }
}