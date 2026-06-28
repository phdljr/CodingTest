package beakjoon.pm1032;

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
        char[] charArrayFirst = br.readLine().toCharArray();
        int[] counts = new int[charArrayFirst.length];

        for(int i=1;i<n;i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0;j<charArray.length;j++){
                if(charArrayFirst[j] != charArray[j]){
                    counts[j]++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<charArrayFirst.length;i++){
            if(counts[i]==0){
                result.append(charArrayFirst[i]);
            } else{
                result.append("?");
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}

