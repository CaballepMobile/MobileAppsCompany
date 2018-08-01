package com.example.admin.daily_2.JavaFun;

public class FizzBuzzTool {
    public static void FizzBuzzChecker(int number){

        if(number % 3 == 0 && number % 5 == 0){
            System.out.println("Fizz");
        }else if(number % 5 ==0){
            System.out.println("Buzz");
        }else if(number % 3 == 0){
            System.out.println("Fizz");
        }else{
            System.out.println(number);
        }
    }
}