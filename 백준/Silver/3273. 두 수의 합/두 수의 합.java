
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
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int result = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] == x){
                result++;
                left++;
                right--;
            }
            else if(arr[left] + arr[right] < x){
                left++;
            } else{
                right--;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


