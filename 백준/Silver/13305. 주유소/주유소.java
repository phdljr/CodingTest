
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

        br.readLine();
        int[] distance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int prevIndex = cost.length - 1;
        int lastIndex = cost.length - 1;
        long result = 0;
        int temp = 0;
        while(lastIndex > 0){
            int minCost = Integer.MAX_VALUE;
            for(int i=0; i < lastIndex; i++){
                if(minCost > cost[i]){
                    minCost = cost[i];
                    temp = i;
                }
            }

            lastIndex = temp;

            long sumOfdistance = 0;
            for(int i=lastIndex; i<prevIndex; i++){
                sumOfdistance += distance[i];
            }

            result += sumOfdistance * cost[lastIndex];
            prevIndex = lastIndex;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
