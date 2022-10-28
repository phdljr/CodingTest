package beakjoon.pm2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(sum - (arr[i] + arr[j]) == 100){
                    print(arr, i, j);
                    return;
                }
            }
        }
    }

    private static void print(int[] arr, int i, int j) {
        int[] newArr = new int[7];
        int count = 0;
        for(int n=0;n<arr.length;n++){
            if(n == i || n == j) continue;
            newArr[count++] = arr[n];
        }
        Arrays.sort(newArr);

        for(int n=0;n< newArr.length;n++){
            System.out.println(newArr[n]);
        }
    }
}
