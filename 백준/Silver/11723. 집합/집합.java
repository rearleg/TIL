import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int S = 0;

        for (int tc = 0 ; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                S |= (1<<x);
            }
            else if (s.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                S &= ~(1<<x);
            }
            else if ( s.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf((S & (1 << x)) != 0 ? 1 : 0));
                bw.write("\n");
            }
            else if (s.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                S ^= (1 << x);
            }
            else if (s.equals("all")) {
                S = (1 << 21) - 2;
            }
            else {
                S = 0;
            }
        }
        bw.flush();
    }
}
