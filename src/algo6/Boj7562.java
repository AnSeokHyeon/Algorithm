// 나이트의 이동
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {
	static int dx[] = { 1, -1, 2, -2, 2, -2, -1, 1 };
	static int dy[] = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static boolean board[][];
	static int N;
	static int stx, sty;
	static int result;
	static int ex, ey;

	static class Knight {
		int x;
		int y;
		int d;

		public Knight() {
			super();
		}

		public Knight(int x, int y, int d) {
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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			board = new boolean[N][N];

			st = new StringTokenizer(br.readLine(), " ");
			stx = Integer.parseInt(st.nextToken());
			sty = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			result = 0;
			bfs(stx, sty);

			sb.append(result + "\n");
		}
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	static void bfs(int n, int m) {
		board[n][m] = true;
		Queue<Knight> q = new LinkedList<Knight>();
		q.add(new Knight(n, m, 0));

		while (!q.isEmpty()) {
			Knight top = q.poll();
			int x = top.x;
			int y = top.y;
			int d = top.d;
			if (x == ex && y == ey) {
				result = d;
				break;
			}

			for (int i = 0; i < 8; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;

				if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
					continue;
				if (board[mx][my])
					continue;
				board[mx][my] = true;
				q.add(new Knight(mx, my, md));
			}

		}

	}

}