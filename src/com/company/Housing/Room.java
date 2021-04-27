package com.company.Housing;

public class Room extends TypeOfHousing {
    public Room(String address, double paymentPerDay, boolean status) {
        super(address, paymentPerDay, status);

    }

    @Override
    public String toString() {
        String h = "";

        if (!this.status) {
            h = "свободно";
        } else {
            h = "занято";
        }
        String s = "Комната : адрес:" + this.address + ", оплата за день :" + this.paymentPerDay + ", статус :" + h;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Room a = (Room) o;
        if (this.status == a.status && this.address == a.address && a.paymentPerDay == this.paymentPerDay) {
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

            String[] array1 = array[0].trim().split(", оплата за день :");
            double payment = Double.parseDouble(array1[1].trim());
            String[] array2 = array1[0].trim().split(": адрес:");
            String address = array2[1].trim();

            return new Room(address, payment, status);

        }
        return null;
    }
}
