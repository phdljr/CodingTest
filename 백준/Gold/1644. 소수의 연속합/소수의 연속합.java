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
		
		int LEN = 4000000;
		boolean[] isPrime = new boolean[LEN + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for(int i=2;i*i<=LEN;i++) {
			for(int j=i*i;j<=LEN;j+=i) {
				isPrime[j] = false;
			}
		}
		
		List<Integer> primeList = new ArrayList<>();
		for(int i=2;i<LEN+1;i++) {
			if(isPrime[i])
				primeList.add(i);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		while(true) {
			if(sum >= n) {
				if(sum == n)
					count++;
				sum -= primeList.get(left++);
			} else if(right == primeList.size())
				break;
			else {
				sum += primeList.get(right++);
			}
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
