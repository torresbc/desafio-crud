package br.com.clothes.comum;

import java.util.Date;

class Clothe extends Product {

    public Clothe(int code, Date date, String local, String type, String brand, String description, Size size,
                   Color color, float valueTag, float valuePaid, float valueBases, float price) {
        super(code, date, local, type, brand, description, size, color, valueTag, valuePaid, valueBases, price);
    }
}