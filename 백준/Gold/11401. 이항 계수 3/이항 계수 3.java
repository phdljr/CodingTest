import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) throws URISyntaxException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int mod = 1_000_000_007;
		
		long result = 1;
		
		long top = factorial(n, mod);
		long bottom = factorial(k, mod) * factorial(n-k, mod) % mod;
		
		result = top * pow(bottom, mod-2, mod) % mod;
		
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long pow(long a, int b, int mod) {
		if(b == 1) {
			return a % mod;
		}
		
		long temp = pow(a, b/2, mod);
		
		if(b%2 == 0)
			return temp * temp % mod;
		return (temp * temp % mod) * a % mod;
	}
	
	public static long factorial(int n, int mod) {
		long result = 1;
		for(int i=0;i<n;i++) {
			result *= (i+1);
			result %= mod;
		}
		
		return result;
	}
}
