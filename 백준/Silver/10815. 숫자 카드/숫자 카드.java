
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

        int n = Integer.parseInt(br.readLine());
        int[] myArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] targetArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int num: targetArr){
            map.put(num, 0);
        }

        for(int num: myArr){
            if(map.containsKey(num)){
                map.replace(num, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int num: map.values()){
            result.append(num).append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}

