// 6087 레이저 통신
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6087 {
	static char board[][];
	static int H, W; // x축 y축
	static int boardChk[][];
	static int stx, sty, ex, ey; // stx, sty 시작점, ex, ey 종료점
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Move {
		int x; // x좌 표
		int y; // y좌표
		int dir;
		int m; // 거울 반사

		public Move() {
			super();
		}

		public Move(int x, int y, int dir, int m) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.m = m;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new char[H][W];
		boardChk = new int[H][W];
		
		int cnt = 0;
		int result = 987654321;
		
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'C') {
					if (cnt == 0) {
						stx = i;
						sty = j;
						cnt++;

					} else {
						ex = i;
						ey = j;
					}

				}

			}
			Arrays.fill(boardChk[i], -1);
		}

		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(stx, sty,-1, 0));
		boardChk[stx][sty] = 0;
		
		while (!q.isEmpty()) {
			
			Move top = q.poll();

			int x = top.x;
			int y = top.y;
			int dir = top.dir;
			int m = top.m;
			
			if (x == ex && y == ey) {
				result = Math.min(result, m);
			}
			
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int mm = m;
				if (dir > -1 && dir != i)
					mm++;

				if (mx < 0 || my < 0 || mx > H - 1 || my > W - 1)
					continue;
				if (board[mx][my] == '*')
					continue;
				if (boardChk[mx][my] > -1 && mm > boardChk[mx][my])
					continue;
				boardChk[mx][my] = mm;
				q.add(new Move(mx, my, i, mm));

			}

		}
		bw.write(result + "");

		bw.close();
		br.close();
	}

}