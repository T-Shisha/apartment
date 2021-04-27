package com.company.userMenu;

import com.company.userConnection.Console;
import com.company.users.Client;
import com.company.users.Person;

public class ClientMenu extends PersonMenu {
    public static final String QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW = "ВЫ хотите : 1. Отменить бронь ; 2.Забронировать;3. Просмотреть свои брони; 4.Выйти";
    public static final String DATA_REQUEST = "Введите фамилию и имя";


    public void Control() {
        String name = RequestData();
        Person client = new Client(name);
        ChooseItem(client, QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW);


    }

    public String RequestData() {

        Console.WriteOnTheScreen(DATA_REQUEST);
        String name = Console.GetOnTheScreen();
        return name;
    }

}
