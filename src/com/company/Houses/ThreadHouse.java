package com.company.Houses;

import com.company.Housing.TypeOfHousing;
import com.company.userConnection.Console;

import java.util.ArrayList;

public class ThreadHouse implements Runnable {
    private ArrayList<TypeOfHousing> house;
    public ThreadHouse(ArrayList<TypeOfHousing> house){
        this.house=house;
    }
   public void  run(){

       for(int i=0;i<house.size();i++){

           Console.WriteOnTheScreen(house.toString());
       }

   };
}
