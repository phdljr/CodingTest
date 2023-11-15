package beakjoon.pm2525;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strArr = in.readLine().split(" ");

        String answer = "";
        int[] arr = new int[3];
        Map<Integer, Integer> map = new TreeMap<>();

        int i = 0;
        for (String str : strArr) {
            int n = Integer.parseInt(str);
            arr[i++] = Integer.parseInt(str);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        if (map.size() == 1) {
            answer = String.valueOf(arr[0] * 1000 + 10000);
        } else if (map.size() == 2) {
            for (Integer k : map.keySet()) {
                if (map.get(k) == 2) {
                    answer = String.valueOf(k * 100 + 1000);
                    break;
                }
            }
        } else {
            answer = String.valueOf(new ArrayList<>(map.keySet()).get(2) * 100);
        }

        out.write(answer);
        out.flush();
    }
}