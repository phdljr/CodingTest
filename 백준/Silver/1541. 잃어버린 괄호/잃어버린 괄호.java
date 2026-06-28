
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

        String str = br.readLine();
        int[] nums = Arrays.stream(str.split("[+-]")).mapToInt(Integer::parseInt).toArray();
        String[] opers = str.replaceAll("\\d+", "").split("");

        int sum = nums[0];
        if(nums.length != 1){
            boolean isMinus = false;
            for (int i = 0; i < opers.length; i++) {
                if (opers[i].equals("-")) {
                    isMinus = true;
                    sum -= nums[i + 1];
                } else {
                    if (isMinus) {
                        sum -= nums[i + 1];
                    } else {
                        sum += nums[i + 1];
                    }
                }
            }
        }

        bw.write(sum + "");
        bw.flush();
    }
}
