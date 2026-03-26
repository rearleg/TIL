
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int white = 0;
        int black = 0;
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                char x = line.charAt(j);
                if (x == 'P') white += 1;
                else if (x == 'p') black += 1;
                else if (x == 'N') white += 3;
                else if (x == 'n') black += 3;
                else if (x == 'B') white += 3;
                else if (x == 'b') black += 3;
                else if (x == 'R') white += 5;
                else if (x == 'r') black += 5;
                else if (x == 'Q') white += 9;
                else if (x == 'q') black += 9;
            }
        }

        System.out.println(white - black);

    }
}
