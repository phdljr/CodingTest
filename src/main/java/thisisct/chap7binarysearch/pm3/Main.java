package thisisct.chap7binarysearch.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        s = in.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr[n-1];
        while(start <= end){
            int mid = (int)Math.round((double)(start + end)/2.0);
            int cs = cutsum(arr, mid);
            if(cs < m){
                end = mid - 1;
            } else{
                answer = mid;
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static int cutsum(int[] arr, int m){
        int sum = 0;
        for(int a: arr){
            sum += a - m < 0 ? 0 : a - m;
        }
        return sum;
    }
}
