package com.company.userConnection;

import java.util.Scanner;

public class Console {
    public static void WriteOnTheScreen(String s){
        System.out.println(s);
    }
    public static String GetOnTheScreen(){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            return input.trim();
    }
}
