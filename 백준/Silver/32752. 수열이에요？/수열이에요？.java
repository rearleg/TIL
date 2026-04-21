import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] tg = new int[R - L + 1];
        boolean yes = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 타겟 배열 만들기
        for (int i = 0; i <= R - L; i++) {
            tg[i] = arr[i+L-1];
        }
        Arrays.sort(tg);

        // 타겟 앞 배열 확인
        int temp = -1;
        for (int i = 0 ; i < L; i++) {
            if (temp <= i) {
                temp = i;
            } else {
                yes = false;
                break;
            }
        }

        if (yes) {
            for (int i = 0; i < tg.length; i++) {
                if (tg[i] >= temp) {
                    temp = tg[i];
                } else {
                    yes = false;
                    break;
                }
            }
            if (yes) {
                for (int i= R; i < N; i++) {
                    if (arr[i] >= temp) {
                        temp = arr[i];
                    } else {
                        yes = false;
                        break;
                    }
                }
            }
        }
        if (yes) System.out.println(1);
        else System.out.println(0);
    }
}