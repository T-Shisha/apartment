package com.company.userMenu;

import com.company.users.Person;
import com.company.userConnection.Console;
import com.company.api.PersonMenuBehavior;

public abstract class PersonMenu implements PersonMenuBehavior {
    static final String DELETE = "1";
    static final String ADD = "2";
    static final String EXIT = "4";
    static final String VIEW = "3";
    private Person person;
    static final String SucessOperation="Выполнено успешно";
    /*public   ArrayList<TypeOfHousing> AddOrDelete(Person person, ArrayList<TypeOfHousing> typeOfHousings, String QUESTION_ABOUT_DELETE_OR_ADD) {

        ArrayList<TypeOfHousing> typeOfHousings1=new ArrayList<TypeOfHousing>();

        boolean exit=false;
        do {
            Console.WriteOnTheScreen(QUESTION_ABOUT_DELETE_OR_ADD);
            String answer = Console.GetOnTheScreen();
            switch (answer) {
                case DELETE:
                    typeOfHousings1 = person.Delete(typeOfHousings);
                    Console.WriteOnTheScreen(SucessOperation);
                    break;
                case ADD:
                    typeOfHousings1 = person.Add(typeOfHousings);
                    Console.WriteOnTheScreen(SucessOperation);
                    break;
                case EXIT: exit=true;
                default:
                    break;


            }
        }while(!exit);
        return typeOfHousings1;
    }*/
   public  void ChooseItem(Person person, String QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW ) {

       boolean exit=false;
       do {
           Console.WriteOnTheScreen(QUESTION_ABOUT_DELETE_OR_ADD_OR_VIEW);
           String answer = Console.GetOnTheScreen();
           switch (answer) {
               case DELETE:


                   person.Delete();
                   Console.WriteOnTheScreen(SucessOperation);
                   break;
               case ADD:
                    person.Add();
                   Console.WriteOnTheScreen(SucessOperation);
                   break;
               case VIEW:
                    person.View();
                   Console.WriteOnTheScreen(SucessOperation);
                   break;
               case EXIT: exit=true;
               default:
                   break;


           }
       }while(!exit);



   }
}
