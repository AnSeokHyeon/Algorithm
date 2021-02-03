package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_2805_농작물수확하기 {
	static int N, result;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Location {
		int x;
		int y;
		int d;

		public Location() {
		}

		public Location(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static void bfs() {
		Queue<Location> q = new LinkedList<Location>();

		Location start = new Location();

		start.x = start.y = (N + 1) / 2;
		start.d = 0;
		q.add(start);
		chk[start.x][start.y] = true;
		while (!q.isEmpty()) {

			Location a = q.poll();
			int x = a.x;
			int y = a.y;
			int d = a.d;

			if (d > N / 2) {

				break;

			}
			result += map[x][y];

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;
				if (mx < 1 || my < 1 || mx > N || my > N)
					continue;
				if (chk[mx][my])
					continue;

				Location next = new Location(mx, my, md);

				chk[mx][my] = true;

				q.add(next);

			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		while (T-- > 0) {

			N = Integer.parseInt(br.readLine());
			result = 0;
			map = new int[N + 1][N + 1];
			chk = new boolean[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				String S = br.readLine();

				for (int j = 1; j < N + 1; j++) {

					map[i][j] = S.charAt(j - 1) - '0';
				}

			}
			bfs();

			StringBuilder sb = new StringBuilder();

			sb.append("#").append(Tcnt++).append(" ").append(result);
			bw.write(sb.toString());

		}

		bw.close();
		br.close();

	}

}
