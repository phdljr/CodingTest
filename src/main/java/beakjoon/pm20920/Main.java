package beakjoon.pm20920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String result = map.entrySet().stream().filter(e -> e.getKey().length() >= m).sorted(
                Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                    .thenComparingInt(e -> -e.getKey().length())
                    .thenComparing(Entry::getKey))
            .map(Entry::getKey)
            .collect(Collectors.joining("\n"));

        bw.write(result.trim());
        bw.flush();
    }
}





