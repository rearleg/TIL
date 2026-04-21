import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i + j == 10) cnt++;
            }
        }
        String way;
        String is;
        if (cnt == 1) {
            way = " way ";
            is = " is ";
        } else {
            way = " ways ";
            is = " are ";
        }
        System.out.println("There" + is + cnt + way + "to get the sum 10.");
    }
}