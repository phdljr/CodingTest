package programmers.level2.pm68936check;

public class Solution {

    static int one = 0;
    static int zero = 0;

    public int[] solution(int[][] arr) {
        go(0,0,arr.length,arr);
        return new int[]{zero, one};
    }

    public void go(int x, int y, int size, int[][] arr){
        if(check(x, y, size, arr)){
            if(arr[x][y] == 1){
                one++;
            } else{
                zero++;
            }
            return;
        }

        size /= 2;

        go(x, y, size, arr);
        go(x, y + size, size, arr);
        go(x + size, y, size, arr);
        go(x + size, y + size, size, arr);
    }

    public boolean check(int x, int y, int size, int[][] arr){
        int val = arr[x][y];

        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j] != val){
                    return false;
                }
            }
        }

        return true;
    }
}