package com.example.admin.daily_2.JavaFun;

public class MultiplicationTableEpicClass {
    public static void PrintTable10x10(){
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                if((x*y)<10){
                    System.out.print(" " + x*y + " ");
                }else{
                    System.out.print(x*y + " ");
                }

            }
            System.out.println("");
        }
    }
}
