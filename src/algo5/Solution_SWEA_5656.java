package algo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656 {
	static int[][] board;
	static boolean[] chkW;
	static int[] pick;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, W, H, result;

	static class Brick {
		int x;
		int y;
		int d;

		public Brick() {
			super();
		}

		public Brick(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			result = 987654321;
			board = new int[H + 1][W + 1];
			pick = new int[W + 1];

			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

				}

			}

			Pick(0);

			sb.append("#" + (Tcnt++) + " " + result + "\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

	static void Pick(int start) {
		if (start == N) {

			Shot();

			return;
		}

		for (int i = 1; i <= W; i++) {

			pick[start] = i;

			Pick(start + 1);
		}

	}

	static void Shot() {
		Queue<Brick> q = new LinkedList<Brick>();
		int copy[][] = new int[H + 1][W + 1];
		for (int i = 0; i < H + 1; i++) {
			System.arraycopy(board[i], 0, copy[i], 0, W + 1);
		}
		for (int Test = 0; Test < N; Test++) {
			int X = 1;
			int Y = pick[Test];
			while (true) {
				if (X > H)
					break;
				if (copy[X][Y] == 0) {
					X++;
				} else {
					q.add(new Brick(X, Y, copy[X][Y]));
					copy[X][Y] = 0;
					break;
				}
			}
			while (!q.isEmpty()) {
				Brick peek = q.poll();
				int x = peek.x;
				int y = peek.y;
				int d = peek.d;

				for (int i = 0; i < 4; i++) {
					int cnt = 0;
					while (cnt < d) {
						int mx = x + dx[i] * cnt;
						int my = y + dy[i] * cnt;

						cnt++;
						if (mx < 1 || my < 1 || mx > H || my > W)
							continue;
						if (copy[mx][my] == 0)
							continue;

						q.add(new Brick(mx, my, copy[mx][my]));

						copy[mx][my] = 0;

					}

				}

			}

			int cnt = 0;
			for (int i = H; i > 0; i--) {
				for (int j = 1; j <= W; j++) {
					if (copy[i][j] == 0)
						continue;
					cnt++;
					for (int k = H; k > i; k--) {
						if (copy[k][j] > 0)
							continue;
						copy[k][j] = copy[i][j];
						copy[i][j] = 0;
						break;
					}

				}

			}

			result = Math.min(result, cnt);

		}

	}

}
