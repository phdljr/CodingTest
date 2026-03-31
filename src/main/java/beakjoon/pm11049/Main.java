package beakjoon.pm11049;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Matrix{
    int r;
    int c;

    Matrix(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        Matrix[] m = new Matrix[n];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            m[i] = new Matrix(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }

        int[] d = new int[n+1];
        d[1] = m[0].r * m[0].c;
        d[2] = m[0].r * m[0].c * m[1].c;

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


