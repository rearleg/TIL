import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        String ans = br.readLine();
        for (int i = 1; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String a = br.readLine();
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) == a.charAt(j)) {
                    sb.append(ans.charAt(j));
                } else {
                    sb.append('?');
                }
            }
            ans = sb.toString();
        }
        bw.write(ans);
        bw.flush();
    }
}