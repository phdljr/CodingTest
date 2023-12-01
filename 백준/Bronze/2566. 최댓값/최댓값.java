import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        int max = 0;
        int r=0, c=0;
        for(int i=0;i<9;i++){
            String[] temp = in.readLine().split(" ");
             for(int j=0;j<9;j++){
                 arr[i][j] = Integer.parseInt(temp[j]);
                 if(max <= arr[i][j]){
                     max = arr[i][j];
                     r = i+1;
                     c = j+1;
                 }
             }   
        }
        
        out.write(""+max);
        out.newLine();
        out.write(""+r+" "+c);
        out.flush();
    }
}