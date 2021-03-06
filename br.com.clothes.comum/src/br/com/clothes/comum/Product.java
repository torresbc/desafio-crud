package br.com.clothes.comum;

import java.util.Date;

public class Product {
    protected int code;
    protected Date date;
    protected String local;
    protected String type;
    protected String brand;
    protected String description;
    protected Size size;
    protected Color color;
    protected float valueTag;
    protected float valuePaid;
    protected float price;

    public Product(int code, Date date, String local, String type, String brand, String description, Size size,
                   Color color, float valueTag, float valuePaid, float price) {
        this.code = code;
        this.date = date;
        this.local = local;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.size = size;
        this.color = color;
        this.valueTag = valueTag;
        this.valuePaid = valuePaid;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getValueTag() {
        return valueTag;
    }

    public void setValueTag(float valueTag) {
        this.valueTag = valueTag;
    }

    public float getValuePaid() {
        return valuePaid;
    }

    public void setValuePaid(float valuePaid) {
        this.valuePaid = valuePaid;
    }

    public float getValueBase() {
        return valuePaid*2;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
