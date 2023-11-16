import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int money = Integer.parseInt(in.readLine());
        int count = Integer.parseInt(in.readLine());
        int expectMoney = 0;
        for(int i=0;i<count;i++){
            String[] arr = in.readLine().split(" ");
            int m = Integer.parseInt(arr[0]);
            int c = Integer.parseInt(arr[1]);
            expectMoney += m * c;
        }
        
        if(money == expectMoney){
            out.write("Yes");
        } else{
            out.write("No");
        }
        out.close();
    }
}