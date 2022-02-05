package Task_3;
import javax.sql.rowset.serial.SerialStruct;
import java.util.*;

public class Vowels {
    public static final char[] vowels = {'а','у','о','е','и','ю','э','ы','ё','я','a','e','i','o','u','y'}; // Массив гласных
    public static int comparing(String first, String second){ // Функция сравнения слов по кол-ву гласных
        int first_vowels = 0, second_vowels = 0;
        for(char symb : vowels){ // Проходим по массиву гласных
            for(int i=0;i<first.length();i++){ // Посимвольно считываем первое слово
                if(first.charAt(i) == symb){ // Если встретилась гласная
                    first_vowels++;
                    break;
                }
            }
            for(int j=0;j<second.length();j++){ // Посимвольно считываем второе слово
                if(second.charAt(j) == symb){ // Если встретилась гласная
                    second_vowels++;
                    break;
                }
            }
        }
        return first_vowels-second_vowels; // Возвращаем разность
    }
    public static void quickSort(String[] array, int low, int high) { // Функция быстрой сортировки
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
    public static void lettersToUpper(String[] words){ // Функция перевода первой гласной в каждом слове в верхний регистр
        for(int i=0;i<words.length;i++){ // Проходим по массиву слов
            StringBuilder buffer = new StringBuilder(words[i].length()); // Создаем буфер для копирования очередного слова
            boolean flag1 = false; // Флаг для отметки первой гласной
            for(int j=0;j<words[i].length();j++){ // Посимвольно считываем каждое слово
                boolean flag = false; // Флаг для отметки отсутствия гласной
                if(!flag1) { // Если до этого не встретилось ни одной гласной
                    for (char symb : vowels) { // Проверяем массив гласных
                        if (words[i].charAt(j) == symb) { // Если это гласная
                            buffer.append(Character.toUpperCase(words[i].charAt(j))); // Переводим еее в верхний регистр
                            flag = true; // Устанавливаем флаги
                            flag1 = true;
                            break;
                        }
                    }
                }
                if(!flag) // Если это не первая глаяная
                    buffer.append(words[i].charAt(j)); // Переписываем символ в том же регистре
            }
            words[i] = buffer.toString(); // Переводим буфер обратно в строку
        }
    }
    public static void main(String args[]){ // Функция main
        Scanner input = new Scanner(System.in);
        System.out.print("Введите предложение: "); // Просим ввести предложение
        String sentence = input.nextLine(); // Считывеам строку
        String[] words = sentence.split(" "); // Делим предложение на слова
        quickSort(words,0,words.length-1); // Сортируем слова по кол-ву гласных
        lettersToUpper(words); // Переводим все первые гласные слов в верхний регистр
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(words));
        System.out.println(result); // Выводим результирующий список
    }
}
