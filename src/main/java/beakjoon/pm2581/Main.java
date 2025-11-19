package beakjoon.pm2581;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[0] = -1;
        arr[1] = -1;
        for(int i=2;i<arr.length;i++){
            if(arr[i] == -1)
                continue;

            arr[i] = i;
            for(int j=2;j<i;j++){
                if(i % j == 0){
                    arr[j] = -1;
                    break;
                }
            }

            for(int k=i+i; k < arr.length; k += i){
                arr[k] = -1;
            }
        }

        int min = 0;
        int sum = 0;
        for(int i=m; i<=n; i++){
            if(arr[i] == -1){
                continue;
            }

            if(min == 0)
                min = arr[i];

            sum += arr[i];
        }

        if(min == 0){
            bw.write("-1");
        } else{
            result.append(sum);
            result.append("\n");
            result.append(min);
        }
        bw.write(result.toString().trim());
        bw.flush();
    }
}
