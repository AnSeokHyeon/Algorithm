// 미로 탐색
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2178 {
	static int N, M;
	static int map[][];
	static boolean chk[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Location {
		int x;
		int y;
		int mv = 1;

		public Location() {
		}

		public Location(int x, int y, int mv) {
			this.x = x;
			this.y = y;
			this.mv = mv;
		}
	}

	static void bfs(Location l) {
		Queue<Location> q = new LinkedList<Location>();

		chk[l.x][l.y] = true;
		q.add(l);

		while (!q.isEmpty()) {
			Location a = q.poll();

			int x = a.x;
			int y = a.y;
			int mv = a.mv;
			if (x == N && y == M) {
				System.out.println(mv);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];

				int my = y + dy[i];
				int n = mv + 1;

				if (mx < 1 || my < 1)
					continue;
				if (mx > N || my > M)
					continue;
				if (map[mx][my] == 0)
					continue;
				if (chk[mx][my])
					continue;

				chk[mx][my] = true;
				Location next = new Location(mx, my, n);
				q.add(next);

			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][M + 1];
		chk = new boolean[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			String S = br.readLine();

			for (int j = 1; j < M + 1; j++) {
				map[i][j] = S.charAt(j - 1) - '0';

			}
		}

		Location start = new Location(1, 1, 1);

		bfs(start);

		br.close();
		bw.close();

	}

}
