import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int left = 0;
		int right = 0;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		while (true) {
            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
                if(left < right)
                	sum -= arr[left++];
                else
                	break;
            } else if (right == n) {
                break;
            } else {
            	sum += arr[right++];
            }
        }
		
		if (minLen == Integer.MAX_VALUE) {
		    minLen = 0;
		}

		bw.write(minLen + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
