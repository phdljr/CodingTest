package beakjoon.pm10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int key = Integer.parseInt(str[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            int key = Integer.parseInt(str[i]);
            if(map.containsKey(key)){
                result.append(map.get(key));
            } else{
                result.append("0");
            }
            result.append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

}
