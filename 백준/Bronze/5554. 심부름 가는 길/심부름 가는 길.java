import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int min = 0;
        int sec = 0;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        min = sum / 60;
        sec = sum % 60;
        System.out.println(min);
        System.out.println(sec);
    }

}