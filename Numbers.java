package Task_1;
import java.util.*;

public class Numbers {
    public static int Sum(String str){
        //StringBuilder count = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = input.nextLine();
        int summa = Sum(string);
        System.out.println("Сумма цифр в введенной вами строке равна " + summa);
    }
}
