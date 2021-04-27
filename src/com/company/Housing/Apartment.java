package com.company.Housing;

public class Apartment extends TypeOfHousing {

    int numberOfBerths;

    public int getNumberOfBerths() {
        return this.numberOfBerths;
    }

    public Apartment(String address, double paymentPerDay, boolean status, int numberOfBerths) {
        super(address, paymentPerDay, status);
        this.numberOfBerths = numberOfBerths;

    }

    @Override
    public String toString() {
        String h = "";
        if (!this.status) {
            h = "свободно";
        } else {
            h = "занято";
        }

        String s = "Квартира : адрес:" + this.address + ", оплата за день : " + this.paymentPerDay + ", количество комнат :" + this.numberOfBerths + ", статус : " + h;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Apartment a = (Apartment) o;
        if (this.numberOfBerths == a.numberOfBerths && this.status == a.status && this.address == a.address && a.paymentPerDay == this.paymentPerDay) {
            return true;
        }
        return false;
    }

    public static TypeOfHousing getTypeofHousing(String s) {
        if (s.trim() != "") {
            String[] array = s.trim().split(", статус :");

            String st = array[1].trim();

            boolean status = true;
            if (st.equals("свободно")) {
                status = false;
            }
            String[] array1 = array[0].trim().split(", количество комнат :");

            int rooms = Integer.parseInt(array1[1].trim());
            String[] array2 = array1[0].trim().split(", оплата за день :");
            double payment = Double.parseDouble(array1[1].trim());
            String[] array3 = array2[0].trim().split(": адрес:");

            String address = array3[1].trim();

            return new Apartment(address, payment, status, rooms);

        }
        return null;
    }
}