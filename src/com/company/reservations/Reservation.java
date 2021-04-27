package com.company.reservations;

import com.company.readingWritingData.Read;
import com.company.Houses.AllHouses;
import com.company.users.Client;
import com.company.Housing.TypeOfHousing;
import com.company.readingWritingData.Write;

import java.util.HashMap;
import java.util.Map;

public class Reservation {
    public static final String Path = "D:\\уник\\5 сем\\разработки технологий\\book\\text2.txt";
    private HashMap<TypeOfHousing, Client> reservation;

    public Reservation() {
        this.reservation = getAllReservation();

    }

    public HashMap<TypeOfHousing, Client> get() {

        return reservation;
    }

    private HashMap<TypeOfHousing, Client> getAllReservation() {
        HashMap<TypeOfHousing, Client> hash = Read.DeserializeReservation(Path);
        return hash;
    }

    public HashMap<TypeOfHousing, Client> getReservation(Client client) {

        HashMap<TypeOfHousing, Client> hashMap = getAllReservation();
        HashMap<TypeOfHousing, Client> hash = new HashMap<TypeOfHousing, Client>();
        for (Map.Entry<TypeOfHousing, Client> h : hashMap.entrySet()) {
            if (h.getValue().equals(client)) {
                hash.put(h.getKey(), h.getValue());
            }

        }
        return hash;
    }

    public void AddReservation(int index, Client client) {
        AllHouses houses = new AllHouses();
        TypeOfHousing h = houses.get().get(index);
        this.reservation.put(h, client);


        houses.Reserve(h);
        change();
    }

    /*public ArrayList<String> getArray(){
           ArrayList<String> list=new ArrayList<String>();
        for (Map.Entry<TypeOfHousing, Client> h :  this.reservation.entrySet()) {
             String s=h.getKey().toString()+"клиент :" +h.getValue().toString();
   list.add(s);
        }
   return list;
    }*/
    public void change() {
        Write.SerializeReservation(Path, this.reservation);
    }

    public void RemoveReservation(TypeOfHousing house, Client client) {

        this.reservation.remove(house, client);
        AllHouses houses = new AllHouses();
        houses.UnReserve(house);
        change();
    }

}
