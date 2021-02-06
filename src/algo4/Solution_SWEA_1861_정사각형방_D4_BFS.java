package algo4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_BFS {
	static int N;
	static int[][] map;
	static boolean[][] chk;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int max = 0, result = 0;

	static void bfs(int n, int m) {

		int cnt = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(n, m));
		chk[n][m] = true;
		while (!q.isEmpty()) {

			Point a = q.poll();
			cnt++;

			int x = a.x;
			int y = a.y;
			int no = map[x][y];
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx < 1 || my < 1 || mx > N || my > N)
					continue;

				int mno = map[mx][my];
				if(chk[mx][my]) continue;
				if (mno - no == 1 || mno - no == -1) {
					chk[mx][my] = true;
					q.add(new Point(mx, my));
					
				} 
			}

		}
		if (cnt > max) {
			result = map[n][m];
			max = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Test = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();

		while (Test-- > 0) {
			N = Integer.parseInt(br.readLine());

			map = new int[N + 1][N + 1];
			chk = new boolean[N + 1][N + 1];
			max = 0;
			result = 0;
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			/*
			 * // 초안 int max = 0; int result = 0; for (int i = 0; i < arr.size() - 1; i++) {
			 * 
			 * int cnt = 1; int x = arr.get(i).x; int y = arr.get(i).y; int idx =
			 * arr.get(i).idx; for (int j = i + 1; j < arr.size(); j++) { int mx =
			 * arr.get(j).x; int my = arr.get(j).y;
			 * 
			 * if ((Math.abs(mx - x) + Math.abs(my - y)) != 1) { if (max < cnt) { max = cnt;
			 * result = idx; }
			 * 
			 * break; } cnt++; x = mx; y = my; i = j;
			 * 
			 * } if (cnt == arr.size()) { max = cnt; result = idx; }
			 * 
			 * }
			 */
			// 두번째안
			for (int i = 1; i < N + 1; i++) {

				for (int j = 1; j < N + 1; j++) {
					if(chk[i][j]) continue;
					bfs(i, j);
				}

			}
			sb.append("#").append(Tcnt++).append(" ").append(result).append(" ").append(max).append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
