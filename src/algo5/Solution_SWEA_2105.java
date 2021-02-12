package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_2105 {
	static int[][] cafe;
	static boolean[][] cafeChk;
	static boolean[] cafeNumChk;
	static int N;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int stx, sty, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			cafeChk = new boolean[N][N];
			cafeNumChk = new boolean[101];
			result = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					stx = i;
					sty = j;
					CafeTour(stx, sty, 0, 0);

				}

			}
			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

	static void CafeTour(int x, int y, int cnt, int dir) {
		if (x == stx && y == sty && cnt > 3) {
			result = Math.max(result, cnt);

			return;
		}

		for (int i = dir; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
				continue;
			if (cafeNumChk[cafe[mx][my]] || cafeChk[mx][my])
				continue;
			if (i < 3 && mx == stx && my == sty)
				continue;

			cafeNumChk[cafe[mx][my]] = true;
			cafeChk[mx][my] = true;
			CafeTour(mx, my, cnt + 1, i);

			cafeNumChk[cafe[mx][my]] = false;
			cafeChk[mx][my] = false;

		}
	}

}
