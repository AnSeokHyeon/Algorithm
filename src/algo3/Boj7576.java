// 토마토
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7576 {
	static Queue<Location> q = new LinkedList<Location>();
	static boolean[][] chk;
	static int[][] map;
	static int N, M;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int result = 0;

	static class Location {
		int x;
		int y;
		int day;

		public Location() {
		}

		public Location(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

	static void bfs() {
		while (!q.isEmpty()) {
			Location a = q.poll();

			int x = a.x;
			int y = a.y;
			int day = a.day;
			if (day > result)
				result = day;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];

				int my = y + dy[i];
				int nextday = day + 1;

				if (mx < 1 || my < 1)
					continue;
				if (mx > N || my > M)
					continue;
				if (map[mx][my] == -1)
					continue;
				if (chk[mx][my])
					continue;

				chk[mx][my] = true;
				map[mx][my] = nextday;

				Location next = new Location(mx, my, nextday);
				q.add(next);

			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		map = new int[N + 1][M + 1];
		chk = new boolean[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			String[] S = br.readLine().split(" ");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(S[j - 1]);
				if (map[i][j] == 1) {
					Location go = new Location(i, j, 0);
					q.add(go);
					chk[i][j] = true;
				}

			}

		}
		bfs();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] == 0)
					result = -1;
			}

		}

		System.out.println(result);
		br.close();
		bw.close();

	}

}
