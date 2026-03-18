import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String[] str = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int r1 = Integer.parseInt(str[2]);
			int x2 = Integer.parseInt(str[3]);
			int y2 = Integer.parseInt(str[4]);
			int r2 = Integer.parseInt(str[5]);
			
			int dx = x1 - x2;
			int dy = y1 - y2;
			
			int dist2 = dx*dx + dy*dy;
			
			int sum = (r1 + r2) * (r1 + r2);
			int diff = (r1 - r2) * (r1 - r2);
			
			if(dist2 == 0 && r1 == r2) {
				bw.write("-1\n");
			}
			else if(dist2 == sum || dist2 == diff) {
				bw.write("1\n");
			}
			else if(diff < dist2 && dist2 < sum) {
				bw.write("2\n");
			}
			else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
	}
}