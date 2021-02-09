package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 색종이
public class Boj2563 {
	static class Paper {
		int x;
		int y;
		int d;

		public Paper() {
			super();
		}

		public Paper(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static int[][] map;
	static int dx[] = { 1, 0, 1 };
	static int dy[] = { 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		Queue<Paper> q = new LinkedList<Paper>();
		StringTokenizer st;
		int cnt = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			q.add(new Paper(X, Y, 1));
			map[X][Y] = 1;
			while (!q.isEmpty()) {
				Paper a = q.poll();

				int x = a.x;
				int y = a.y;
				int d = a.d;
				if (d == 10) {
					break;
				}

				for (int i = 0; i < 3; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					int md = d + 1;
					map[mx][my] = 1;
					q.add(new Paper(mx, my, md));

				}
			}
			q.removeAll(q);

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) cnt++; 
			}
		}
		bw.write(cnt + "");

		bw.close();
		br.close();
	}

}
