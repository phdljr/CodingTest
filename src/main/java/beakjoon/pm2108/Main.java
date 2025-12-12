package beakjoon.pm2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        String result = "";

        result += Math.round((float)Arrays.stream(arr).sum() / arr.length) + "\n";
        result += arr[arr.length / 2] + "\n";
        List<Entry<Integer, Long>> list = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().sorted(
            Map.Entry.<Integer,Long>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey())
        ).collect(Collectors.toList());

        if(list.size() >= 2 && list.get(0).getValue() == list.get(1).getValue())
            result += list.get(1).getKey() + "\n";
        else
            result += list.get(0).getKey() + "\n";

        result += Arrays.stream(arr).summaryStatistics().getMax() - Arrays.stream(arr).summaryStatistics().getMin() + "\n";

        bw.write(result.trim());
        bw.flush();
    }
}




