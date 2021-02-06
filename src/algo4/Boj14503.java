//로봇청소기

package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14503 {
	static int map[][];
	static int N, M, result;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static class Robot {
		int x;
		int y;
		int d;

		public Robot() {
			super();
		}

		public Robot(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static void bfs(int n, int m, int l) {
		Robot robot = new Robot(n, m, l);
		Queue<Robot> q = new LinkedList<Robot>();
		q.add(robot);
		map[n][m] = result + 1;
		while (!q.isEmpty()) {
			Robot a = q.poll();

			int x = a.x;
			int y = a.y;
			int d = a.d;

			for (int i = d - 1; i > d - 5; i--) {
				int md;
				if (i < 0)
					md = i + 4;
				else
					md = i;
				int mx = x + dx[md];
				int my = y + dy[md];

				if (map[mx][my] > 0)
					continue;
				map[mx][my] = (++result) + 1;
				q.add(new Robot(mx, my, md));
				break;

			}
			if (q.isEmpty()) {
				int mx = x - dx[d];
				int my = y - dy[d];

				if (map[mx][my] == 1) {
					break;
				} else {
					q.add(new Robot(mx, my, d));
				}
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
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 1;
		bfs(x, y, d);

		bw.write(result + "");
		bw.close();
		br.close();
	}

}
