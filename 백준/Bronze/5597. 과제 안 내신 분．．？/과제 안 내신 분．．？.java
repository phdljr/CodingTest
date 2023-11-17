import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[30];

        for(int i=0;i<28;i++){
            int index = Integer.parseInt(in.readLine()) - 1;
            arr[index] = 1;
        }

        for(int i=0;i<30;i++){
            if(arr[i] == 0){
                out.write((i+1)+"\n");
            }
        }
        out.flush();
    }
}