import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;

        a = n / 300;
        n %= 300;
        b = n / 60;
        n %= 60;
        c = n / 10;
        n %= 10;
        if (n == 0) {
            System.out.println(a + " " + b + " " + c);
        }
        else System.out.println(-1);
    }

}