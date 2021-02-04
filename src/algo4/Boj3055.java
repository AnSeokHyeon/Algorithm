// 탈출 
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

public class Boj3055 {
	static char[][] map;
	static int[][] chk;
	static int X;
	static int Y;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		chk = new int[R + 1][C + 1];


		Queue<Point> r = new LinkedList<Point>();
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = s.charAt(j - 1);
				if (map[i][j] == '*') {
					r.add(new Point(i, j));
				}
				if (map[i][j] == 'S') {
					q.add(new Point(i, j));
				}

				if (map[i][j] == 'D') {
					X = i;
					Y = j;
				}
			}

		}
		int result = -1;
		while (true) {
			int rsize = r.size();
			int qsize = q.size();
			if (qsize == 0)
				break;
			while (rsize-- > 0) {

				Point a = r.poll();
				int x = a.x;
				int y = a.y;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];

					if (mx < 1 || my < 1 || mx > R || my > C)
						continue;
					if (map[mx][my] == 'D' || map[mx][my] == 'X' || map[mx][my] == '*')
						continue;
					map[mx][my] = '*';
					r.add(new Point(mx, my));

				}

			}
			while (qsize-- > 0) {

				Point a = q.poll();
				int x = a.x;
				int y = a.y;
				int n = chk[x][y];
				if (x == X && y == Y) {
					result = chk[x][y];
					break;
				}

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					int mn = n + 1;

					if (mx < 1 || my < 1 || mx > R || my > C)
						continue;
					if (map[mx][my] == 'X' || map[mx][my] == '*')
						continue;
					if (map[mx][my] == 'S' || chk[mx][my] > 0)
						continue;
					chk[mx][my] = mn;
					q.add(new Point(mx, my));

				}

			}

		}
		StringBuilder sb= new StringBuilder();
		
		if (result > 0) {
			sb.append(result);
		} else {
			sb.append("KAKTUS");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
