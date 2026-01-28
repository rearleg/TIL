import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();


        String[] parts = expr.split("-");

        int result = sumPart(parts[0]);

        for (int i = 1; i < parts.length; i++) {
            result -= sumPart(parts[i]);
        }

        System.out.println(result);
    }

    private static int sumPart(String s) {
        String[] nums = s.split("\\+");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}