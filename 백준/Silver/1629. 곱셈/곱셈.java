import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;

public class Main {	
	public static void main(String[] args) throws URISyntaxException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);		
		int c = Integer.parseInt(str[2]);
		
		long result = pow(a, b, c);
		
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}

	private static long pow(int a, int b, int c) {
		
		if(b == 1)
			return a % c;
		
		long temp = pow(a, b/2, c);
		
		if(b % 2 == 0)
			return (temp * temp) % c;
		
		return (temp * temp % c) * a % c;
	}
}
