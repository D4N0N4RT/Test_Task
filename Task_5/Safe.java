package Task_5;

import java.util.ArrayList;

public class Safe {
    private int total_size; // Вместимость сейфа
    private ArrayList<Thing> inside; // Массив вещей внутри
    static int[][] matrix; // Матрица решения задачи
    Safe(int total_size){ // Конструктор
        this.total_size = total_size;
        inside = new ArrayList<>();
    }

    public void finalThings(Thing[] things,int i,int j){ // Определение самого ценного набора вещей
        if (j<0 || matrix[i][j] == 0) // Если мы полностью разобрали самый ценный набор вещей
            return;
        if(i>0) { // Если это не первая вещь массива вещей
            if (matrix[i - 1][j] == matrix[i][j]) // Если вещь не входит в самый ценный набор
                finalThings(things, i - 1, j); // Рекурсивно вызываем функцию
            else { // Иначе
                finalThings(things, i - 1, j - things[i].getSize()); // Вызываем функцию
                inside.add(things[i]); // Добавляем вещь внутрь сейфа
            }
        }
        else{ // Иначе
            inside.add(things[i]); // Добавляем вещь внутрь сейфа
        }
    }

    public void fill(Thing[] things){ // Функция разбора возможных наборов вещей
        matrix = new int[things.length][total_size]; // Создаем матрицу
        for(int i=0;i<things.length;i++){ // Проходим по массиву вещей
            for(int j=0;j<total_size;j++){ // Проходим по всем возможным вместимостям сейфа от 1 до максимальной
                if(things[i].getSize() <= j+1){ // Если вещь входит в сейф данной вместимости
                    if(i>0) // Если это не первый элемент массива
                        // Определяем, увеличит ли эта вещь ценность набора
                        matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - things[i].getSize()+1]  + things[i].getPrice());
                    else // Иначе
                        matrix[i][j] = things[i].getPrice(); // Добавляем эту вещь в набор
                }
                else if(i>0){ // Иначе если вещь не входит в сейф и это не первый элемент
                    matrix[i][j] = matrix[i-1][j]; // Берем цееность набора с предыдущими вещами
                }
                else{ // Иначе
                    matrix[i][j] = 0; // Устанавливаем ценность в 0
                }
            }
        }
        this.finalThings(things,things.length-1,total_size-1);
    }

    public ArrayList<Thing> getInside() { // Функция возврата массива внутренних вещей
        return inside;
    }
}
