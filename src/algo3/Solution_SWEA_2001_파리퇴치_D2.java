package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2 {
	static int[][] map;
	static boolean[][] chk;
	static int N, M, result;
	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };

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

	static void bfs(int a, int b) {

		Queue<Location> q = new LinkedList<Location>();
		Location start = new Location(a, b, 1);
		q.add(start);
		chk[a][b] = true;
		int sum = 0;

		while (!q.isEmpty()) {

			Location f = q.poll();

			int x = f.x;
			int y = f.y;
			int d = f.d;

			if (d > M) {
				if (sum > result)
					result = sum;
				break;
			}

			sum += map[x][y];

			for (int i = 0; i < 3; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;
				if (mx < 1 || my < 1 || mx > N || my > N)
					continue;
				if (chk[mx][my])
					continue;

				chk[mx][my] = true;
				Location next = new Location(mx, my, md);
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
			StringTokenizer input = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(input.nextToken());
			M = Integer.parseInt(input.nextToken());
			map = new int[N + 1][N + 1];
			result = 0;
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");

				for (int j = 1; j < N + 1; j++) {

					map[i][j] = Integer.parseInt(s.nextToken());
				}

			}
			for (int i = 1; i <= N + 1 - M; i++) {

				for (int j = 1; j <= N + 1 - M; j++) {
					chk = new boolean[N + 1][N + 1];
					bfs(i, j);
				}

			}

			StringBuilder sb = new StringBuilder();

			sb.append("#").append(Tcnt++).append(" ").append(result).append("\n");
			bw.write(sb.toString());

		}

		bw.close();
		br.close();

	}

}
