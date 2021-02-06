// 보물섬

package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2589 {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] chk;
	static int result;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Location {
		int x;
		int y;
		int d;

		public Location() {
			super();
		}

		public Location(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	
	static void bfs(int n, int m) {
		Queue<Location> q = new LinkedList<Location>();

		q.add(new Location(n, m, 0));
		chk[n][m] = true;
		int max = 0;

		while (!q.isEmpty()) {
			Location a = q.poll();
			int x = a.x;
			int y = a.y;
			int t = a.d;
			if (t > max)
				max = t;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int mt = t + 1;

				if (mx < 1 || my < 1 || mx > N || my > M)
					continue;
				if (map[mx][my] == 'W')
					continue;
				if (chk[mx][my])
					continue;
				chk[mx][my] = true;
				q.add(new Location(mx, my, mt));

			}

		}
		if (max > result)
			result = max;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N + 1][M + 1];
		result = 0;
		for (int i = 1; i < N + 1; i++) {

			String S = br.readLine();

			for (int j = 1; j < M+1; j++) {
				map[i][j] = S.charAt(j - 1);

			}
		}
		for (int i = 1; i < N + 1; i++) {

			for (int j = 1; j < M; j++) {
				if (map[i][j] == 'W')
					continue;
				chk = new boolean[N + 1][M + 1];

				bfs(i, j);

			}
		}
		StringBuilder sb=  new StringBuilder();
		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}
