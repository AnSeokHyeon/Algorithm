package algo7;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int map[][];
	static boolean chk[][];
	static int N, M, K;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			chk = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			int result = 0;
			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (chk[i][j] || map[i][j] == 0)
						continue;
					result++;
					chk[i][j] = true;
					q.add(new Point(i, j));

					while (!q.isEmpty()) {

						Point top = q.poll();
						int x = top.x;
						int y = top.y;
						for (int k = 0; k < 4; k++) {
							int mx = x + dx[k];
							int my = y + dy[k];

							if (mx < 0 || my < 0 || mx > N - 1 || my > M - 1)
								continue;
							if (map[mx][my] == 0)
								continue;
							if (chk[mx][my])
								continue;

							chk[mx][my] = true;
							q.add(new Point(mx, my));
						}

					}
				}
			}
			bw.write(result+"\n");

		}

		br.close();
		bw.close();

	}
}
