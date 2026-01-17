
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int[] aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
            .toArray(Integer[]::new);
        Arrays.sort(aArr);
        Arrays.sort(bArr, Comparator.reverseOrder());

        int sum = 0;
        for(int i=0;i<aArr.length;i++){
            sum += aArr[i] * bArr[i];
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
