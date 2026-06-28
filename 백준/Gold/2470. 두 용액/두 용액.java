
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

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int pl = 0, pr = 0;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                pl = left;
                pr = right;
            }

            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }


        bw.write(arr[pl] + " " + arr[pr]);
        bw.flush();
    }
}

