package algo6;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1949_등산로조성 {
	static int N;
	static int K, result;
	static Queue<Inf> q;

	static int board[][];
	static boolean boardChk[][];
	static ArrayList<Point> arr;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Inf {
		int x;
		int y;
		int d;

		public Inf() {
			super();
		}

		public Inf(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		arr = new ArrayList<>();
		q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			arr.clear();
			int max = 0;
			result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());

			K = Integer.parseInt(st.nextToken());

			board = new int[N + 1][N + 1];
			boardChk = new boolean[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < N + 1; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > max)
						max = board[i][j];
				}
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {

					if (board[i][j] == max) {

						arr.add(new Point(i, j));
					}

				}
			}

			for (int k = 0; k <= K; k++) {
				for (int i = 1; i < N + 1; i++) {
					for (int j = 1; j < N + 1; j++) {
						board[i][j] -= k;

						bfs();

						board[i][j] += k;

					}
				}
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void bfs() {
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			int x = arr.get(i).x;
			int y = arr.get(i).y;

			q.add(new Inf(x, y, 1));

		}
		while (!q.isEmpty()) {
			Inf first = q.poll();

			int X = first.x;
			int Y = first.y;
			int D = first.d;

			result = Math.max(result, D);
			for (int m = 0; m < 4; m++) {
				int mx = X + dx[m];
				int my = Y + dy[m];
				int md = D + 1;

				if (mx > N || my > N || mx < 1 || my < 1)
					continue;
				if (board[mx][my] >= board[X][Y])
					continue;

				q.add(new Inf(mx, my, md));

			}
		}
	}
}