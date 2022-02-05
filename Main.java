package Task_5;

public class Main {
    public static void main(String args[]){
        Thing[] things = new Thing[5];
        Thing one = new Thing(4,600,"Souvenier");
        Thing two = new Thing(3,100,"Ruby");
        Thing three = new Thing(5,900,"Money");
        Thing four = new Thing(8,700,"Gold");
        Thing five = new Thing(9,600,"Jewels");
        things[0] = one;
        things[1] = two;
        things[2] = three;
        things[3] = four;
        things[4] = five;
        Safe safe = new Safe(7);
        safe.fill(things);
        System.out.println(safe.getInside());
    }
}
