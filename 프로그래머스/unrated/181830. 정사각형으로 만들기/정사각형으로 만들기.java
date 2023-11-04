import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        if(row > col){
            for(int i=0;i<row;i++){
                arr[i] = Arrays.copyOf(arr[i], row);
            }
        } else if(row < col){
            int[][] temp = new int[col][col];
            for(int i=0;i<row;i++){
                temp[i] = Arrays.copyOf(arr[i], col);
            }
            for(int i=row;i<col;i++){
                temp[i] = new int[col];
            }
            arr = temp;
        }
        return arr;
    }
}