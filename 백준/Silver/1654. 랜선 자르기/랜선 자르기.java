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
		
		String[] str = br.readLine().split(" ");
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int[] arr = new int[k];
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long max = 0;
		for(int i=0;i<arr.length;i++) {
			if(max < arr[i])
				max = arr[i];
		}
		
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (min + max) / 2;
			
			int count = 0;
			for(int i=0;i<arr.length;i++) {
				count += arr[i] / mid;
			}
			
			if(count < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
				
		bw.write(min - 1 + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
