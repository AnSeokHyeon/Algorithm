package algo5;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj3190 {
	static int N, L, result;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Situation {
		int t;
		char c;

		public Situation() {
		}

		public Situation(int t, char c) {
			this.t = t;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;

		}

		ArrayList<Situation> turn = new ArrayList<>();
		ArrayList<Point> snake = new ArrayList<>();

		int L = Integer.parseInt(br.readLine());

		while (L-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);

			turn.add(new Situation(X, C));

		}
		snake.add(new Point(1, 1));
		int num = 0;
		int time = 0;
		int dir = 0;
		map[1][1] = 1;
		while (true) {

			time++;
			int size = snake.size();

			int x = snake.get(0).x;
			int y = snake.get(0).y;

			int mx = x + dx[dir];
			int my = y + dy[dir];

			if (mx < 1 || my < 1 || mx > N || my > N || map[mx][my] == 1) {

				break;
			}

			int tailx = snake.get(size - 1).x;
			int taily = snake.get(size - 1).y;

			for (int i = size - 1; i > 0; i--) {
				snake.get(i).x = snake.get(i - 1).x;
				snake.get(i).y = snake.get(i - 1).y;
			}

			if (map[mx][my] == 2) {
				snake.add(new Point(tailx, taily));

			} else {
				map[tailx][taily] = 0;
			}

			snake.get(0).x = mx;
			snake.get(0).y = my;
			map[mx][my] = 1;

			if (num < turn.size() && time == turn.get(num).t) {
				if (turn.get(num).c == 'D') {
					dir++;
				} else {
					dir--;
				}

				if (dir < 0)
					dir = dir + 4;
				if (dir > 3)
					dir = dir % 4;

				num++;

			}
		}

		bw.write(time + "");
		bw.close();
		br.close();
	}

}
