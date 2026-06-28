package beakjoon.pm12015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxLength = 0;
        int max = arr.length;
        int min = 0;
        while(min <= max){
            int mid = (min + max)/2;

            int length = 1;
            int prev = arr[mid];
            for(int i=mid+1; i<n; i++){
                if(arr[i] > prev){
                    length++;
                    prev = arr[i];
                }
            }

            if(length > maxLength ){
                maxLength = length;
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }

        bw.write(maxLength + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
