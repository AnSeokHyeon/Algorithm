// 섬의 개수
package algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj4963 {
	static int[][] map;
	static boolean[][] chk;
	static int w, h;

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

	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	static void BFS(Location l) {
		Queue<Location> q = new LinkedList<Location>();
		q.add(l);
		chk[l.x][l.y] = true;

		while (!q.isEmpty()) {

			Location a = q.poll();
			int x = a.x;
			int y = a.y;
			for (int i = 0; i < 8; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 0 || my < 0 || mx > h - 1 || my > w - 1)
					continue;
				if (chk[mx][my])
					continue;
				if (map[mx][my] == 0)
					continue;
				Location next = new Location(mx, my);

				chk[mx][my] = true;
				q.add(next);

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (true) {

			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			chk = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0)
						continue;
					if (chk[i][j])
						continue;
					Location go = new Location(i, j);
					BFS(go);
					result++;
				}
			}
			System.out.println(result);
		}

		sc.close();

	}

}
