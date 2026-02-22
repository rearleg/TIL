import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int max = Math.max(b-a, c-b);
            int ans = max-1;
            System.out.println(ans);
        }

    }

}