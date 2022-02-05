package Task_5;

import java.util.ArrayList;

public class Safe {
    int total_size;
    int total_price;
    ArrayList<Thing> inside;
    static int[][] matrix;
    Safe(int total_size){
        this.total_size = total_size;
        total_price = 0;
        inside = new ArrayList<>();
    }

    public void finalThings(Thing[] things,int i,int j){
        if (matrix[i][j] == 0)
            return;
        if(i>0) {
            if (matrix[i - 1][j] == matrix[i][j])
                finalThings(things, i - 1, j);
            else {
                finalThings(things, i - 1, j - things[i].getSize());
                inside.add(things[i]);
            }
        }
        else{
            inside.add(things[i]);
        }
    }

    public void fill(Thing[] things){
        matrix = new int[things.length][total_size];
        for(int i=0;i<things.length;i++){
            for(int j=0;j<total_size;j++){
                if(things[i].getSize() <= j+1){
                    if(i>0)
                        matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - things[i].getSize()+1]  + things[i].getPrice());
                    else
                        matrix[i][j] = things[i].getPrice();
                }
                else if(i>0){
                    matrix[i][j] = matrix[i-1][j];
                }
                else{
                    matrix[i][j] = 0;
                }
            }
        }
        this.finalThings(things,things.length-1,total_size-1);
    }

    public ArrayList<Thing> getInside() {
        return inside;
    }
}
