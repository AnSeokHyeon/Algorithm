// 단지 번호 붙이기
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2667 {

	static int[][] map;
	static boolean[][] chk;
	static int N;
	static ArrayList<Integer> result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Location {
		int x;
		int y;

		public Location() {
		}

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(Location l) {

		int cnt = 0;

		Queue<Location> q = new LinkedList<Location>();

		q.add(l);

		chk[l.x][l.y] = true;

		while (!q.isEmpty()) {

			Location a = q.poll();
			cnt++;
			int x = a.x;
			int y = a.y;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 1 || my < 1 || mx > N || my > N)
					continue;
				if (map[mx][my] == 0)
					continue;
				if (chk[mx][my])
					continue;

				chk[mx][my] = true;
				Location next = new Location(mx, my);
				q.add(next);

			}

		}

		result.add(cnt);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		chk = new boolean[N + 1][N + 1];
		result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {

			String S = br.readLine();

			for (int j = 1; j <= N; j++) {
				map[i][j] = S.charAt(j - 1) - '0';
			}

		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {

				if (map[i][j] == 0)
					continue;
				if (chk[i][j])
					continue;
				Location go = new Location(i, j);

				bfs(go);

			}

		}
		StringBuilder sb = new StringBuilder();
		sb.append(result.size() + "\n");

		Collections.sort(result);
		for (int n : result) {
			sb.append(n + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
