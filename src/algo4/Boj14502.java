package algo4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
	static int map[][];
	static int N, M, result;
	static ArrayList<Point> virus;
	static ArrayList<Point> wall;
	static boolean[] chk;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static void dfs(int n, int m) {
		if (n == 3) {

			cal();
			return;
		}
		for (int i = m; i < wall.size(); i++) {
			if (chk[i])
				continue;
			chk[i] = true;
			dfs(n + 1, i + 1);
			chk[i] = false;

		}

	}

	static void cal() {
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < virus.size(); i++) {

			q.add(new Point(virus.get(i).x, virus.get(i).y));

		}

		int copy[][] = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
		}

		for (int i = 0; i < wall.size(); i++) {

			if (!chk[i])
				continue;
			copy[wall.get(i).x][wall.get(i).y] = 1;

		}
		while (!q.isEmpty()) {
			Point a = q.poll();
			int x = a.x;
			int y = a.y;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 1 || my < 1 || mx > N || my > M)
					continue;
				if (copy[mx][my] != 0)
					continue;

				copy[mx][my] = 2;
				q.add(new Point(mx, my));

			}

		}
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {

			for (int j = 1; j < M + 1; j++) {
				if (copy[i][j] == 0)
					cnt++;
			}

		}
		if (cnt > result)
			result = cnt;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		virus = new ArrayList<>();
		wall = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < M + 1; j++) {
				map[i][j] = st.nextToken().charAt(0) - '0';
				if (map[i][j] == 0) {
					wall.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new Point(i, j));

				}

			}

		}
		chk = new boolean[wall.size()];
		dfs(0, 0);

		bw.write(result + "");

		br.close();
		bw.close();

	}

}
