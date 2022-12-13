package ITEMS;

public class Item {
    private String Name;
    private int price;

    //Constructor
    public Item(String name, int price){
        this.Name = name;
        this.price = price;
    }

    //Getter's
    public String getName() {
        return Name;
    }

    public int getPrice() {
        return price;
    }

    //Setter's
    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
