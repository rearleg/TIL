import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int F = Integer.parseInt(br.readLine().trim());

        int base = (N / 100) * 100;
        int mod = base % F;
        int add = (F - mod) % F;

        System.out.printf("%02d%n", add);
    }
}