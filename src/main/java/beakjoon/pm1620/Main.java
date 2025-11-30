package beakjoon.pm1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i=0;i<n;i++){
            String name = br.readLine();
            map.put(name, i+1);
        }

        String[] arr = map.keySet().toArray(new String[0]);
        StringBuilder result = new StringBuilder();

        for(int i=0;i<m;i++){
            String key = br.readLine();

            if(map.containsKey(key)){
                result.append(map.get(key));
            } else{
                result.append(arr[Integer.parseInt(key) - 1]);
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
    }

}
