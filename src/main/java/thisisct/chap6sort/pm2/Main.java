package thisisct.chap6sort.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(in.readLine())];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(in.readLine());
        }

        sort(arr);

        for (int n: arr){
            System.out.println(n);
        }
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int max = i;
            for(int j=arr.length - 1;j>=i;j--){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }
}
