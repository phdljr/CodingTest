
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int m = Integer.parseInt(str[1]);
        long[] sumArr = new long[arr.length];
        sumArr[0] = arr[0] % m;
        for(int i=1;i<arr.length;i++){
            sumArr[i] = sumArr[i-1] + arr[i];
            sumArr[i] %= m;
        }

        long result = 0;
        for(int i=0;i<arr.length;i++){
            if(sumArr[i] == 0){
                result++;
            }
        }

        Map<Long, Long> map = Arrays.stream(sumArr)
            .boxed()
            .collect(Collectors.groupingBy(
                v -> v,            // key: 값 자체
                Collectors.counting() // value: 등장 횟수
            ));
        for(Entry<Long, Long> entry: map.entrySet()){
            long value = entry.getValue();
            result += value * (value - 1) / 2;
        }

        bw.write(result + "");
        bw.flush();
    }
}
