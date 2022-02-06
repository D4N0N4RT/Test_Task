package Task_1;
import java.util.*;

public class Numbers {
    public static int Sum(String str){ // Функция вычисления суммы цифр в строке
        int sum = 0;
        for (int i = 0; i < str.length(); i++) { // Посимвольно считываем строку
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }
    public static void main(String args[]){ // Функция main
        Scanner input = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = input.nextLine(); // Считываем введенную строку
        int summa = Sum(string); // Вызываем функцию
        System.out.println("Сумма цифр в введенной вами строке равна " + summa); // Выводим ответ
    }
}
