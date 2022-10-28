import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {0,0,0},
                {0,0,0},
        };
        print(arr);
        System.out.println("============");
        rotate(arr);
        print(arr);
        System.out.println("============");
        mirror(arr);
        print(arr);
        System.out.println("============");
    }

    private static void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void mirror(int[][] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr.length/2;j++){
                swap(arr, i, j, i, arr.length - j - 1);
            }
        }
    }

    private static void rotate(int[][] arr){
        int[][] temp = new int[arr.length][arr.length];
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr.length;j++){
                temp[i][j] = arr[i][j];
            }
        }
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[j][arr.length-i-1] = temp[i][j];
            }
        }
    }
}
