import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = new int[2002];

        int now = 1001;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String order = st.nextToken();

            if (order.equals("R")) {
                for (int j = 0; j < x; j++) {
                    map[now + j]++;
                }
                now += x;
            }else {
                for (int j = 0; j < x; j++) {
                    map[now - j]++;
                }
                now -= x;
            }
        }

        int result = 0;
        int continuous = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] < 2) {
                result += continuous >= 2 ? continuous : 0;
                continuous = 0;
            }else {
                continuous++;
            }
        }
        System.out.println(result);
    }
}