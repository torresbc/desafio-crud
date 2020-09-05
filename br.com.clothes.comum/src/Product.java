import java.util.Date;

public class Product {
    protected int code;
    protected Date date = new Date();
    protected String local;
    protected String type;
    protected String brand;
    protected String description;
    protected Size size;
    protected Color color;
    protected float valueTag;
    protected float valuePaid;
    protected float valueBase;
    protected float price;

    public Product(int code, Date date, String local, String type, String brand, String description, Size size,
                   Color color, int valueTag, int valuePaid, int valueBases, int price) {
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
        this.valueBase = valueBases;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getValueTag() {
        return valueTag;
    }

    public void setValueTag(float valueTag) {
        this.valueTag = valueTag;
    }

    public int getValuePaid() {
        return valuePaid;
    }

    public void setValuePaid(float valuePaid) {
        this.valuePaid = valuePaid;
    }

    public int getValueBase() {
        return valueBase;
    }

    public void setValueBase(float valueBase) {
        this.valueBase = valueBase;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
