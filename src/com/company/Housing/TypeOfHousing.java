package com.company.Housing;

import java.io.Serializable;
import java.util.Objects;

public abstract class TypeOfHousing implements Serializable {
    String address;

    public String getAddress() {
        return this.address;
    }

    double paymentPerDay;

    public double getPaymentPerDay() {
        return this.paymentPerDay;
    }

    boolean status;

    public boolean getStatus() {
        return this.status;
    }

    public void placeAReservation() {
        this.status = true;
    }

    public void unplaceaReservation() {
        this.status = false;
    }

    public TypeOfHousing(String address, double paymentPerDay, boolean status) {

        this.address = address;
        this.paymentPerDay = paymentPerDay;
        this.status = status;

    }

    public static TypeOfHousing getTypeofHousing(String s) {
        String[] array = s.split(": адрес:");
        if (array[0].trim().equals("Комната")) {

            return Room.getTypeofHousing(s);
        }

        return Apartment.getTypeofHousing(s);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfHousing that = (TypeOfHousing) o;
        return Double.compare(that.paymentPerDay, paymentPerDay) == 0 &&
                status == that.status &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, paymentPerDay, status);
    }
}
