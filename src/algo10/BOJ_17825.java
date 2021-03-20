package algo10;

// 17825 주사위 윷놀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17825 {
	static int depth = 10;
	static int board[][] = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 0, 10, 13, 16, 19, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 20, 22, 24, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 30, 28, 27, 26, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 25, 30, 35, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	static int number[] = new int[depth];
	static int pick[] = new int[depth];
	static int result = 0;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int hx[] = {0,0,0,0};
		int hy[] = {0,0,0,0};

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < depth; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int map[][] = new int[6][21];
		start(0, map, 0, hx, hy);
		bw.write(result + "");
		br.close();
		bw.close();
	}

	private static void start(int idx, int[][] map, int sum, int[] hx, int[] hy) {

		int copy[][] = new int[6][21];
		int X[] = new int[4];
		int Y[] = new int[4];

		if (idx == depth) {
		result = Math.max(sum, result);
			return;
		}

		for (int i = 0; i < 4; i++) {

			for (int a = 0; a < 6; a++) {
				for (int b = 0; b < 21; b++) {
					copy[a][b] = map[a][b];
				}
			}

			for(int a = 0; a<4;a++) {
				X[a] = hx[a];
				Y[a] = hy[a];
			}

			int x = X[i];
			int y = Y[i];
			if(x == 4 && y == 20) continue;
			int mx = x;
			int my = y + number[idx];


			if (mx == 0) {
				if (my > 20) {
					mx = 4;
					my = 20;
				} else if (board[mx][my] % 10 == 0) {
					mx = board[mx][my] / 10;
					my = 1;
				}

			} else if (mx == 1 || mx == 3) {
				if (my > 4) {
					mx = 5;
					my = my - 4;
				}
			} else if (mx == 2) {
				if (my > 3) {
					mx = 5;
					my = my - 3;
				}
			}
			if (mx == 5) {
				if (my > 3) {
					mx = 4;
					my = my - 3;
				}

			}
			if (mx == 4 && my > 1) {
				mx = 4;
				my = 20;

				copy[mx][my] += i + 1;
				copy[x][y] = 0;
				X[i] = mx;
				Y[i] = my;
			}
			else {
				if (copy[mx][my] > 0)
					continue;
				else {
					copy[mx][my] = i + 1;
					copy[x][y] = 0;
					X[i] = mx;
					Y[i] = my;
					

				}
			}
			pick[idx] = i;
			start(idx + 1, copy, sum + board[mx][my], X, Y);

		}

	}

}