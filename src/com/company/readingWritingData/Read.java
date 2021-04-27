package com.company.readingWritingData;

import com.company.Housing.TypeOfHousing;


import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

import com.company.users.Client;

public class Read {

    public static ArrayList<TypeOfHousing> DeserializeTypeOfHousing(String path) {
        ArrayList<TypeOfHousing> house = new ArrayList<TypeOfHousing>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            house = ((ArrayList<TypeOfHousing>) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return house;
    }

    public static HashMap<TypeOfHousing, Client> DeserializeReservation(String path) {
        HashMap<TypeOfHousing, Client> reservation = new HashMap<TypeOfHousing, Client>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            reservation = ((HashMap<TypeOfHousing, Client>) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return reservation;
    }
}
