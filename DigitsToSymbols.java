package Task_4;

import java.util.*;

public class DigitsToSymbols {
    public static final String[] zero = {"  ***  "," *   * ","*     *","*     *","*     *"," *   * ","  ***  "};
    public static final String[] one = {" * ","** "," * "," * "," * "," * ","***"};
    public static final String[] two = {" *** ","*   *","*  * ","  *  "," *   ","*    ","*****"};
    public static final String[] three = {"**** ","    *","   * ","  *  ","   * ","    *","**** "};
    public static final String[] four = {"    *  ","   **  ","  * *  "," *  *  ","*******","    *  ","    *  "};
    public static final String[] five = {"****","*   ","*   ","*** ","   *","   *","*** "};
    public static final String[] six = {" *** ","*    ","*    "," *** ","*   *","*   *"," *** "};
    public static final String[] seven = {"*****","    *","   * ","  *  "," *   ","*    ","*    "};
    public static final String[] eight = {" *** ","*   *","*   *"," *** ","*   *","*   *"," *** "};
    public static final String[] nine = {" *** ","*   *","*   *"," *** ","    *","    *"," *** "};

    public static void drawNumbers(int number){
        Stack<String[]> order = new Stack<>();
        while(number > 0){
            switch(number % 10){
                case 0:
                    order.push(zero);
                    break;
                case 1:
                    order.push(one);
                    break;
                case 2:
                    order.push(two);
                    break;
                case 3:
                    order.push(three);
                    break;
                case 4:
                    order.push(four);
                    break;
                case 5:
                    order.push(five);
                    break;
                case 6:
                    order.push(six);
                    break;
                case 7:
                    order.push(seven);
                    break;
                case 8:
                    order.push(eight);
                    break;
                case 9:
                    order.push(nine);
                    break;
            }
            number /= 10;
        }
        ArrayList<String[]> digits = new ArrayList<>(order);
        Collections.reverse(digits);
        for(int j=0;j<7;j++) {
            for (int i = 0; i < digits.size(); i++) {
                System.out.print(" " + digits.get(i)[j]);
            }
            System.out.print('\n');
        }
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = input.nextInt();
        drawNumbers(number);
    }
}
