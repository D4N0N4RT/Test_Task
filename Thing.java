package Task_5;

public class Thing {
    int size;
    int price;
    String name;
    Thing(int size,int price, String name){
        this.size = size;
        this.price = price;
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public int getSize() {
        return size;
    }
    @Override
    public String toString() {
        return  name +
                "(" + size +
                " litres) - " + price;
    }
}
