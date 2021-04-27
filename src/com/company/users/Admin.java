package com.company.users;

import com.company.Houses.AllHouses;
import com.company.Housing.Apartment;
import com.company.reservations.Reservation;
import com.company.userConnection.Console;
import com.company.Housing.Room;
import com.company.Housing.TypeOfHousing;
import java.util.HashMap;
import java.util.Map;

public  class Admin extends Person {

    static final String CHOOSE_Type="Введите тип жилья (квартира или комната)";
    static final String ENTER_KOL_ROOM="Введите количество комнат";
    static final String ENTER_PAYMENT="Введите оплату за сутки";
    static final String ENTER_ADDRESS="Введите адрес";

    public void Add()  {

TypeOfHousing h=CreateNewHouse();
        AllHouses house=new AllHouses();


        house.AddHouse(h);
    }
    public void  Delete( ) {
         AllHouses house=new AllHouses();
       if(house.get().size()!=0){

        int index=ChooseNecessaryHouse(house.get());
        TypeOfHousing h= house.get().get(index);

      house.RemoveHouse(h);

      }
   else Console.WriteOnTheScreen("Жилье отсуствует");

    }
    public TypeOfHousing CreateNewHouse(){
        Console.WriteOnTheScreen(CHOOSE_Type);
        String type=Console.GetOnTheScreen();
        try{
            if(!type.equals("квартира") && !type.equals("комната")) throw new RuntimeException("Некорректный ввод. Переменная примет значение по умолчанию");


        }
        catch(RuntimeException  ex){

            System.out.println(ex.getMessage());
            type="комната";
        }
        TypeOfHousing house;
        Console.WriteOnTheScreen(ENTER_ADDRESS);
        String address=Console.GetOnTheScreen();
        Console.WriteOnTheScreen(ENTER_PAYMENT);
        String payment=Console.GetOnTheScreen();
        if(type.trim().toLowerCase().equals("квартира")){
            Console.WriteOnTheScreen(ENTER_KOL_ROOM);
            String amountRooms=Console.GetOnTheScreen();
              house=new Apartment(address,Double.parseDouble(payment), false, Integer.parseInt(amountRooms));

        }
       else {
              house = new Room(address, Double.parseDouble(payment), false);

        }
        return house;
    }
    public void View() {
         Reservation reservation = new Reservation();
        HashMap<TypeOfHousing, Client> hashMap=reservation.get();
        for (Map.Entry<TypeOfHousing, Client> hash :  hashMap.entrySet()) {
String s=hash.getKey().toString()+hash.getValue().toString();
            Console.WriteOnTheScreen(s);


        }
    }
}
