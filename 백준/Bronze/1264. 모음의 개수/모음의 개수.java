import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vowel = "aeoiuAEOIU";
        while (true) {
            int cnt = 0;
            String s = br.readLine();
            if (s.equals("#")) break;
            for (char ch : s.toCharArray()) {
                if (vowel.contains(String.valueOf(ch))) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}
