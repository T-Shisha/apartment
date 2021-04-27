package com.company.userMenu;

import com.company.users.Admin;
import com.company.users.Person;

public class AdminMenu extends PersonMenu {

    public static final String QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW = "ВЫ хотите : 1. Удалить ; 2.Добавить; 3.Просмотр бронированных комнат/квартир ; 4. Выйти";

    public void Control() {

        Person admin = new Admin();
        ChooseItem(admin, QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW);

    }


}
