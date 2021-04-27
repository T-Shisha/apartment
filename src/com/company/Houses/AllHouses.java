package com.company.Houses;

import com.company.readingWritingData.Read;
import com.company.readingWritingData.Write;
import com.company.Housing.TypeOfHousing;

import java.util.ArrayList;

public class AllHouses {
    public static final String Path = "D:\\уник\\5 сем\\разработки технологий\\book\\text1.txt";
    private ArrayList<TypeOfHousing> house;

    public ArrayList<TypeOfHousing> get() {

        return this.house;

    }

    public AllHouses() {
        this.house = getAllHouses();
    }

    private ArrayList<TypeOfHousing> getAllHouses() {

        ArrayList<TypeOfHousing> list1 = Read.DeserializeTypeOfHousing(Path);
        return list1;
    }

    public void change() {


        Write.SerializeTypeOfHousing(Path, this.house);
    }

    public void RemoveHouse(TypeOfHousing h) {


        this.house.remove(h);

        change();
    }

    public void AddHouse(TypeOfHousing h) {

        this.house.add(h);


        change();
    }

    public void Reserve(TypeOfHousing h) {

        int index = this.house.indexOf(h);

        this.house.get(index).placeAReservation();

        change();

    }

    public void UnReserve(TypeOfHousing h) {
        int index = this.house.indexOf(h);
        this.house.get(index).unplaceaReservation();
        change();
    }
    public ArrayList<TypeOfHousing> findNecessaryHouses(boolean value) {
        ArrayList<TypeOfHousing> typeOfHousings1 = new ArrayList<TypeOfHousing>();
        ArrayList<TypeOfHousing> typeOfHousings = this.house;
        for (TypeOfHousing house : typeOfHousings) {

            if (house.getStatus() == value) {
                typeOfHousings1.add(house);
            }
        }
        return typeOfHousings1;
    }

    public static ArrayList<TypeOfHousing> defineArray(ArrayList<TypeOfHousing> houses, int index, int lastIndex) {
        ArrayList<TypeOfHousing> h = new ArrayList<TypeOfHousing>();

        for (int i = index; i <lastIndex;i++) {


            h.add(houses.get(i));
        }
        return h;
    }
    public static  void input( ArrayList<TypeOfHousing> house) {
        new Thread(new ThreadHouse(defineArray( house, 0,  house.size() / 2))).start();
        new Thread(new ThreadHouse(defineArray( house, ( house.size() / 2) , house.size()))).start();
    }

}
