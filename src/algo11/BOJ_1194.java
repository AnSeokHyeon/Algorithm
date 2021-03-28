package algo11;

// 1194 달이 차오른다 가자

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Position {
		int x;
		int y;
		int d;
		int flag;

		public Position(int x, int y, int d, int flag) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char board[][] = new char[N + 1][M + 1];
		boolean chk[][][] = new boolean[N + 1][M + 1][64];

		int stx = 0;
		int sty = 0;
		int flag = 0;
		int result = -1;

		for (int i = 1; i < N + 1; i++) {
			String S = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				char c = S.charAt(j - 1);
				if (c == '0') {
					stx = i;
					sty = j;
					board[i][j] = '.';
				} else {
					board[i][j] = c;
				}
			}
		}

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(stx, sty, 0, flag));
		chk[stx][sty][flag] = true;

		while (!q.isEmpty()) {
			Position p = q.poll();

			int x = p.x;
			int y = p.y;
			int d = p.d;
			int f = p.flag;

			if (board[x][y] == '1') {

				result = d;
				break;
			}

			for (int i = 0; i < 4; i++) {

				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;
				int mf = f;
				if (mx < 1 || my < 1 || mx > N || my > M) continue; // 경계먄
				if (board[mx][my] == '#') continue; // 벽
				if (chk[mx][my][mf]) continue; // 같은 상태로 방문 거부

				if (board[mx][my] >= 'A' && board[mx][my] <= 'F') {
					int key = board[mx][my] - 'A';
					if ((mf & 1 << key) == 0) continue;
				} // 문일때

				chk[mx][my][mf] = true;
				if (board[mx][my] >= 'a' && board[mx][my] <= 'f') {
					int key = board[mx][my] - 'a';
					mf = mf | 1 << key;
				}
				q.add(new Position(mx, my, md, mf));
			}
		}
		bw.write(result + "");
		bw.close();
		br.close();
	}

}