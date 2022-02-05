package Task_3;
import javax.sql.rowset.serial.SerialStruct;
import java.util.*;

public class Vowels {
    public static final char[] vowels = {'а','у','о','е','и','ю','э','ы','ё','я','a','e','i','o','u','y'};
    public static int comparing(String first, String second){
        int first_vowels = 0, second_vowels = 0;
        for(char symb : vowels){
            for(int i=0;i<first.length();i++){
                if(first.charAt(i) == symb){
                    first_vowels++;
                    break;
                }
            }
            for(int j=0;j<second.length();j++){
                if(second.charAt(j) == symb){
                    second_vowels++;
                    break;
                }
            }
        }
        return first_vowels-second_vowels;
    }
    public static void quickSort(String[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        String center = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (comparing(array[i],center) > 0) {
                i++;
            }
            while (comparing(array[j],center) < 0) {
                j--;
            }
            if (i <= j){
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
    public static void lettersToUpper(String[] words){
        for(int i=0;i<words.length;i++){
            StringBuilder buffer = new StringBuilder(words[i].length());
            boolean flag1 = false;
            for(int j=0;j<words[i].length();j++){
                boolean flag = false;
                if(!flag1) {
                    for (char symb : vowels) {
                        if (words[i].charAt(j) == symb) {
                            buffer.append(Character.toUpperCase(words[i].charAt(j)));
                            flag = true;
                            flag1 = true;
                            break;
                        }
                    }
                }
                if(!flag)
                    buffer.append(words[i].charAt(j));
            }
            words[i] = buffer.toString();
        }
    }
    public static ArrayList<String> sortedWords(String sentence){
        String[] words = sentence.split(" ");
        quickSort(words,0,words.length-1);
        lettersToUpper(words);
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(words));
        return result;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String sentence = input.nextLine();
        System.out.println(sortedWords(sentence));
    }
}
