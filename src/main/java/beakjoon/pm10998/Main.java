package beakjoon.pm10998;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sarr = in.readLine().split(" ");
        out.write(String.valueOf(Integer.parseInt(sarr[0]) * Integer.parseInt(sarr[1])));
        out.flush();
    }

}
