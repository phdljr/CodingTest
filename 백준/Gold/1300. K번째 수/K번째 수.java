import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {	
	public static void main(String[] args) throws URISyntaxException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = k;  // k번째 수는 최대 k를 넘지 않음
		long answer = 0;

		while (left <= right) {
		    long mid = (left + right) / 2;

		    long count = 0;
		    for (int i = 1; i <= n; i++) {
		        count += Math.min(n, mid / i);
		    }

		    if (count >= k) {
		        answer = mid;
		        right = mid - 1;  // 더 작은 값 탐색
		    } else {
		        left = mid + 1;
		    }
		}
				
		bw.write(answer + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
