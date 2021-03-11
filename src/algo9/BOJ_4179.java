package algo9;

// 4179 불
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
	static int R, C;
	static char board[][];
	static boolean chk[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Move {
		int x;
		int y;
		int d;

		public Move(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int stx, sty;

		board = new char[R + 1][C + 1];
		chk = new boolean[R + 1][C + 1];

		Queue<Move> q = new LinkedList<>();
		Queue<Point> fire = new LinkedList<>();
		for (int i = 1; i < R + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < C + 1; j++) {
				char c = s.charAt(j - 1);
				board[i][j] = c;
				if (c == 'J') {
					stx = i;
					sty = j;
					board[i][j] = '.';

					q.add(new Move(stx, sty, 0));
					chk[stx][sty] = true;
				}
				if (c == 'F') {
					fire.add(new Point(i, j));
				}
			}
		}
		int result = 0;
		boolean resultChk = false;
		while (true) {

			int fireSize = fire.size();
			while (fireSize-- > 0) {
				Point point = fire.poll();

				int x = point.x;
				int y = point.y;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];

					if (mx < 1 || my < 1 || mx > R || my > C)
						continue;
					if (board[mx][my] != '.')
						continue;

					board[mx][my] = 'F';
					fire.add(new Point(mx, my));
				}
			}

			int size = q.size();
			while (size-- > 0) {
				Move mv = q.poll();

				int x = mv.x;
				int y = mv.y;
				int d = mv.d;

				for (int i = 0; i < 4; i++) {

					int mx = x + dx[i];
					int my = y + dy[i];
					int md = d + 1;
					if (mx < 1 || my < 1 || mx > R || my > C) {
						result = md;
						resultChk = true;
						continue;
					}
					if (board[mx][my] != '.')
						continue;
					if (chk[mx][my])
						continue;
					chk[mx][my] = true;
					q.add(new Move(mx, my, md));
				}

			}
			if (q.size() == 0)
				break;
			if (resultChk)
				break;
		}
		if (resultChk) {
			bw.write(result + "\n");
		} else {
			bw.write("IMPOSSIBLE\n");
		}

		br.close();
		bw.close();
	}

}