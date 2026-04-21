import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 입력 받기 2줄
        String s1 = br.readLine();
        String s2 = br.readLine();
        String v1 = "";
        String v2 = "";
        String vowel = "aeiouAEIOU";
        boolean FLAG1 = true;
        boolean FLAG2 = true;

        for (int i = 0; i < s1.length(); i++) {
            String ch = String.valueOf(s1.charAt(i));
            if (i == 0) {
                sb1.append(ch);
                continue;
            }

            if (!vowel.contains(ch)) {
                sb1.append(ch);
            } else {
                v1 = ch;
                FLAG1 = false;

                break;
            }
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(s2.charAt(i));
            if (i == s2.length() -1) {
                sb2.append(ch);
                continue;
            }
            if (!vowel.contains(ch)) {
                sb2.insert(0, ch);
            } else {
                v2 = ch;
                FLAG2 = false;

                break;
            }

        }

        if (!FLAG2) {
            bw.write(sb1 + v2 + sb2);
        } else if (!FLAG1 && FLAG2) {
            bw.write(sb1 + v1 + sb2);
        } else {
            bw.write(sb1 + "o" + sb2);
        }

        bw.flush();
    }
}