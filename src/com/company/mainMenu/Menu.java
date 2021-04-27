package com.company.mainMenu;

import com.company.userConnection.Console;
import com.company.userMenu.AdminMenu;
import com.company.userMenu.ClientMenu;

public class Menu {
    static final String CLIENT_CHOICE = "1";
    static final String ADMIN_CHOICE = "2";
    static final String EXIT_CHOICE = "3";
    static final String QUESTION_ABOUT_THE_ROLE = "Вход как :1. Клиент; 2. Администратор ; 3. Выйти";


    public static void Start() {
        DefineRole();
    }

    public static void DefineRole() {
        boolean exit = false;

        do {
            Console.WriteOnTheScreen(QUESTION_ABOUT_THE_ROLE);
            String choice = Console.GetOnTheScreen();
            switch (choice) {
                case CLIENT_CHOICE:
                    ClientMenu clientMenu = new ClientMenu();
                    clientMenu.Control();
                    break;
                case ADMIN_CHOICE:
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.Control();
                    break;

                case EXIT_CHOICE:
                    exit = true;
                    break;

                default:
                    break;
            }

        } while (!exit);

    }
}


