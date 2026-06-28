import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = in.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int[][] answer = new int[n][m];
        for(int i=0;i<2;i++){
             for(int j=0;j<n;j++){
                 temp = in.readLine().split(" ");
                 for(int k=0;k<m;k++){
                     answer[j][k] += Integer.parseInt(temp[k]);
                 }
             }   
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                out.write(""+answer[i][j]+" ");
            }
            out.newLine();
        }
        out.flush();
    }
}