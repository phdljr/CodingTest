package beakjoon.pm1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for(int i=0;i<t;i++){
            String[] temp = reader.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            int result = a;

            for(int j=2;j<=b;j++){
                result = (result * a)%10;
            }

            if(result == 0)
                result = 10;

            System.out.println(result);
        }
    }
}
