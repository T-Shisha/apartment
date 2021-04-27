package com.company.users;

import com.company.Houses.AllHouses;
import com.company.userConnection.Console;
import com.company.Housing.TypeOfHousing;
import com.company.api.PersonBehavior;

import java.util.ArrayList;

public abstract class Person implements PersonBehavior {
    public static final String CHOICE = "Выберите необходимое жилье";

    public int ChooseNecessaryHouse(ArrayList<TypeOfHousing> typeOfHousings) {
        Console.WriteOnTheScreen(CHOICE);

      // EnterHouses(typeOfHousings);
        AllHouses.input(typeOfHousings);
        int number = Integer.parseInt(Console.GetOnTheScreen());
        try {
            if (number < 1 || number > typeOfHousings.size())
                throw new RuntimeException("Некорректный ввод. Переменная примет значение по умолчанию");


        } catch (RuntimeException ex) {

            System.out.println(ex.getMessage());
            number = typeOfHousings.size();
        }

        return number - 1;
    }

    public void EnterHouses(ArrayList<TypeOfHousing> list) {
        for (int i = 0; i < list.size(); i++) {

            String s = String.valueOf(i + 1) + "." + list.get(i).toString();
            Console.WriteOnTheScreen(s);

        }

    }


}


