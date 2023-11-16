import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int bytes = Integer.parseInt(in.readLine());
        String answer = "";
        
        for(int i=0;i<bytes / 4;i++){
            answer += "long ";
        }
        answer += "int";
        
        out.write(answer);
        out.close();
    }
}