package com.company.readingWritingData;

import com.company.Housing.TypeOfHousing;
import com.company.users.Client;

import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;

public class Write {


    public static void SerializeTypeOfHousing(String path, ArrayList<TypeOfHousing> house) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(house);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static void SerializeReservation(String path, HashMap<TypeOfHousing, Client> map) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(map);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }
}
