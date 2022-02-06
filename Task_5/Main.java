package Task_5;

public class Main {
    public static void main(String args[]){ // Функция main
        Thing[] things = new Thing[5]; // Массив вещей
        Thing one = new Thing(4,600,"Souvenier");
        Thing two = new Thing(3,400,"Ruby");
        Thing three = new Thing(5,900,"Money");
        Thing four = new Thing(8,1000,"Gold");
        Thing five = new Thing(9,600,"Jewels");
        things[0] = one;
        things[1] = two;
        things[2] = three;
        things[3] = four;
        things[4] = five; // Заполняем масив
        Safe safe = new Safe(13); // Создаем сейф определенного объема
        safe.fill(things); // Заполняем сейф ценными вещами
        System.out.println(safe.getInside()); // Выводим массив вещей внутри сейфа
    }
}
