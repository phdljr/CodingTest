package beakjoon.pm2485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int temp = arr[1] - arr[0];
        for(int i=1;i<n-1;i++){
            int gap = arr[i+1] - arr[i];
            temp = getGcd(temp, gap);
        }
        int gcd = temp;

        int start = arr[0];
        int i=0;
        while (start + i * gcd <= arr[n-1]){
            i++;
        }

        int result = i - arr.length;

        bw.write(result + "");
        bw.flush();
    }

    private static int getGcd(int a, int b){
        while(true){
            if(b == 0){
                return a;
            } else{
                int temp = a;
                a = b;
                b = temp % b;
            }
        }
    }
}
