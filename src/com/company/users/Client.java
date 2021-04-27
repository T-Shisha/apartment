package com.company.users;

import com.company.Houses.AllHouses;
import com.company.userConnection.Console;
import com.company.Housing.TypeOfHousing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.company.reservations.Reservation;

public class Client extends Person implements Serializable {
    private String Name;

    public Client(String Name) {
        this.Name = Name;

    }

    @Override
    public String toString() {

        return Name;
    }

    public void Add() {
        int index = DefineHouse();
        Reservation reservation = new Reservation();


        reservation.AddReservation(index, this);
    }

    public void Delete() {
        AllHouses house = new AllHouses();
        ArrayList<TypeOfHousing> typeOfHousings1 = house.findNecessaryHouses(true);
        if (typeOfHousings1.size() != 0) {
            int index = ChooseNecessaryHouse(typeOfHousings1);
            TypeOfHousing h = typeOfHousings1.get(index);
            Reservation reservation = new Reservation();
            reservation.RemoveReservation(h, this);
            ;
        } else Console.WriteOnTheScreen("Бронированное жилье отсуствует");

    }

    public void View() {
        Reservation reservation = new Reservation();
        HashMap<TypeOfHousing, Client> hashMap = reservation.getReservation(this);
        for (Map.Entry<TypeOfHousing, Client> hash : hashMap.entrySet()) {

            Console.WriteOnTheScreen(hash.getKey().toString());


        }

    }

    public static Client getClient(String s) {

        return new Client(s.trim());
    }

    public int DefineHouse() {
        AllHouses house1 = new AllHouses();
        ArrayList<TypeOfHousing> typeOfHousings1 = house1.findNecessaryHouses(false);
        int index = ChooseNecessaryHouse(typeOfHousings1);
        TypeOfHousing house = typeOfHousings1.get(index);
        ArrayList<TypeOfHousing> houses = house1.get();
        int index1 = houses.indexOf(house);

        return house1.get().indexOf(houses.get(index1));
    }

}
