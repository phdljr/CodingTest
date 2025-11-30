package beakjoon.pm14425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] s1 = new String[n];
        for(int i=0;i<n;i++){
            s1[i] = br.readLine();
        }

        String[] s2 = new String[m];
        for(int i=0;i<m;i++){
            s2[i] = br.readLine();
        }

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(s1[i].equals(s2[j]))
                    result++;
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}
