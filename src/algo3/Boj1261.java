// 알고스팟

package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1261 {
	static int M, N, result;
	static int[][] map;
	static int[][] rock;
	static boolean[][] chk;
	static int[] dx = { 1, 0 ,-1,0};
	static int[] dy = { 0, 1 ,0,-1};

	static class Location {
		
		int x;
		int y;
		int r;

		public Location() {
		}

		public Location(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}

	static void bfs() {
		PriorityQueue<Location> q = new PriorityQueue<>(new Comparator<Location>() {
			@Override
			public int compare(Location o1, Location o2) {
				// TODO Auto-generated method stub
				if(o1.r > o2.r) 
					return 1;
				else if (o1.r < o2.r) 
					return -1;
				else
					return 0;
			}
		});
		Location start = new Location(1, 1, 0);
		q.add(start);

		while (true) {
			int t = q.size();
			if (q.size() == 0)
				break;
			while (t-- > 0) {
				Location a = q.poll();

				int x = a.x;
				int y = a.y;
				int r = a.r;
				// System.out.println(x + " " + y + " / " + r);
				if (x == N && y == M) {
					if (result > r)
						result = r;

				}
				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					int mr = r;
					if (mx > N || my > M || mx < 1||my < 1)
						continue;
					if (chk[mx][my])
						continue;
					if (map[mx][my] == 1)
						mr++;
					chk[mx][my] = true;
					//rock[mx][my] = mr;
					Location next = new Location(mx, my, mr);
					q.add(next);

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		rock = new int[N + 1][M + 1];
		chk = new boolean[N + 1][M + 1];
		result = 123456;
		for (int i = 1; i <= N; i++) {

			String S = br.readLine();

			for (int j = 1; j <= M; j++) {

				map[i][j] = S.charAt(j - 1) - '0';

			}
		}

		bfs();
		System.out.println(result);
		br.close();
		bw.close();

	}

}
