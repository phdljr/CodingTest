package beakjoon.pm1037;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for(int i=0;i<count;i++){
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println(min * max);
    }
}
