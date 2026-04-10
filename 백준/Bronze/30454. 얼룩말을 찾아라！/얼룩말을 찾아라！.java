import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int temp = 0;
            boolean check = false;
            for (int j = 0; j < M; j++) {
                int x = line.charAt(j) - '0';
                if(!check && x == 1) {
                    temp++;
                    check = true;
                }
                if(x == 0) check = false;
            }

            if (temp > max) {
                max = temp;
                cnt = 1;
            }
            else if (temp == max) cnt++;
        }

        System.out.println(max + " " + cnt);
    }
}


/*
5 9
110010101
101010100
000011111
011011010
100100101
*/
