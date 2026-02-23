import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        char[][] chess = new char[8][8];
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if((i+j) % 2 == 0 && s.charAt(j) == 'F') cnt++;
            }
        }
        System.out.println(cnt);
    }

}