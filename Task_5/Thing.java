package Task_5;

public class Thing { // Класс вещи
    int size; // Размер
    int price; // Ценность
    String name; // Название
    Thing(int size,int price, String name){ // Конструктор
        this.size = size;
        this.price = price;
        this.name = name;
    }
    public int getPrice() { // Функция возврата цены
        return price;
    }
    public int getSize() {
        return size;
    } // Функция возврата размера
    @Override
    public String toString() { // Функция для вывода
        return  name +
                "(" + size +
                " litres) - " + price;
    }
}
