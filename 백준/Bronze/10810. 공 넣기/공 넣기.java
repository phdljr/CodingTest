import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        
        for(int i=0;i<m;i++){
            str = in.readLine().split(" ");
            int start = Integer.parseInt(str[0]) - 1;
            int end = Integer.parseInt(str[1]);
            int num = Integer.parseInt(str[2]);
            for(int j=start;j<end;j++){
                arr[j] = num;
            }
        }
        
        for(int i=0;i<n;i++){
            out.write(""+arr[i]+" ");
        }
        out.flush();
    }
}