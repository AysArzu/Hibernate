package com.hb02.embeddable;

import javax.persistence.Embeddable;

/*
 * Adress icin ayri bir tablo olusmasin, Ama Adress sinifindaki degiskenler ,
 * Student tablosunda kolon olarak eklenmesini sagliyor
 */
@Embeddable
public class Address {
    private  String street;
    private  String city;
    private  String country;
    private  String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
