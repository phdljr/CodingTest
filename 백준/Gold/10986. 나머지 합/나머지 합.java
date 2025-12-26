
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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

        for(int i=0; i<m; i++){
            long modCount = 0;
            for(int j=0;j<sumArr.length;j++){
                if(sumArr[j] == i)
                    modCount++;
            }

            result += modCount * (modCount - 1) / 2;
        }

        bw.write(result + "");
        bw.flush();
    }
}
