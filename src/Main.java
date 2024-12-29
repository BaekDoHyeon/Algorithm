import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N, M, cnt = 0;
    static int[] arr, pm, ch;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        ch = new int[N];
        pm = new int[M];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        DFS(0);
        System.out.println(cnt);
    }

    static void DFS(int L) {
        if (L == M) cnt++;
        else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
}