package algo6;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11559 {
	static char board[][];
	static boolean chk[][];
	static final int N = 13;
	static final int M = 7;
	static int result;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		board = new char[N][M];
		chk = new boolean[N][M];

		for (int i = 1; i < N; i++) {
			String s = br.readLine();
			for (int j = 1; j < M; j++) {
				board[i][j] = s.charAt(j - 1);
			}
		}

		ArrayList<Point> arr = new ArrayList<>();
		Queue<Point> q = new LinkedList<Point>();
		while (true) {

			boolean bomb = false;

			for (int i = 0; i < N; i++) {
				Arrays.fill(chk[i], false);
			}

			for (int i = N - 1; i > 0; i--) {
				for (int j = 1; j < M; j++) {
					if (board[i][j] == '.' || chk[i][j])
						continue;
					arr.clear();
					q.add(new Point(i, j));
					arr.add(new Point(i, j));

					chk[i][j] = true;

					while (!q.isEmpty()) {
						Point top = q.poll();
						int x = top.x;
						int y = top.y;
						int c = board[x][y];

						for (int k = 0; k < 4; k++) {
							int mx = x + dx[k];
							int my = y + dy[k];

							if (mx < 1 || my < 1 || mx > N - 1 || my > M - 1)
								continue;
							int mc = board[mx][my];
							if (board[mx][my] == '.')
								continue;
							if (chk[mx][my])
								continue;
							if (c != mc)
								continue;

							q.add(new Point(mx, my));
							arr.add(new Point(mx, my));
							chk[mx][my] = true;

						}

					}
					int len = arr.size();
					if (len > 3) {
						for (int k = 0; k < len; k++) {
							int x = arr.get(k).x;
							int y = arr.get(k).y;
							board[x][y] = '.';
						}
						bomb = true;
					}
				}
			}
			for (int j = 1; j < M; j++) {
				for (int i = N - 1; i > 0; i--) {
					if (board[i][j] == '.')
						continue;
					for (int k = N - 1; k > i; k--) {
						if (board[k][j] != '.')
							continue;
						board[k][j] = board[i][j];
						board[i][j] = '.';
						break;
					}

				}
			}
			if (!bomb)
				break;

			result++;
		}
		bw.write(result + "");

		bw.close();
		br.close();
	}

}