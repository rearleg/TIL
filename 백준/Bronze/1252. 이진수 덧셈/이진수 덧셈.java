import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger x = new BigInteger(st.nextToken(), 2);
        BigInteger y = new BigInteger(st.nextToken(), 2);

        System.out.println(x.add(y).toString(2));
    }
}