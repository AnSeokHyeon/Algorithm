// 벽 부수고 이동하기

package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206 {

	static int M, N, result;
	static int[][] map;
	static boolean[][][] chk;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Location {

		int x;
		int y;
		int r;
		int d;

		public Location() {
		}

		public Location(int x, int y, int r, int d) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.d = d;
		}

	}

	static void bfs() {
		Queue<Location> q = new LinkedList<Location>();
		chk[1][1][0] = true;
		Location start = new Location(1, 1, 0, 1);
		q.add(start);

		while (!q.isEmpty()) {
			Location a = q.poll();

			int x = a.x;
			int y = a.y;
			int r = a.r;
			int d = a.d;

			// System.out.println(x + " " + y + " / " + r + " , " + d);
			if (x == N && y == M) {
				if (result > d)
					result = d;

			}
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int mr = r;
				int md = d + 1;
				if (mx > N || my > M || mx < 1 || my < 1)
					continue;
				if (chk[mx][my][mr])
					continue;
				if (map[mx][my] == 1 && mr != 0)
					continue;
				if (map[mx][my] == 1) {
					mr++;
				}
				chk[mx][my][mr] = true;
				Location next = new Location(mx, my, mr, md);
				q.add(next);

			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		chk = new boolean[N + 1][M + 1][2];
		result = 9999999;
		for (int i = 1; i <= N; i++) {

			String S = br.readLine();

			for (int j = 1; j <= M; j++) {

				map[i][j] = S.charAt(j - 1) - '0';

			}
		}
		bfs();
		StringBuilder sb = new StringBuilder();
		if (result == 9999999) {
			sb.append(-1);
		} else {
			sb.append(result);
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
