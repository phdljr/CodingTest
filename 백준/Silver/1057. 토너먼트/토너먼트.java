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
		int n = Integer.parseInt(str[0]);
		int a = Integer.parseInt(str[1]);
		int b = Integer.parseInt(str[2]);
		if(a > b) { // a가 무조건 작게 설정
			int t = b;
			b = a;
			a = t;
		}
		
		int round = 1;
		while(n >= 1) {
			if(a%2 == 1 && a+1 == b) {
				break;
			}
			
			if(a % 2 == 1) {
				a++;
			}
			a /= 2;
			
			if(b % 2 == 1) {
				b++;
			}
			b /= 2;
			
			if(n%2 == 1) {
				n++;
			}
			n /= 2;
			round++;
		}
		
		bw.write(round + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
