
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = Arrays.stream(arr).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for(int num: set){
            map.put(num, i);
            i++;
        }

        StringBuilder result = new StringBuilder();
        for(int a: arr){
            result.append(map.get(a)).append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
