package algo5;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15684 {
	static int board[][];
	static boolean boardchk[][];
	static int N, M, H;
	static ArrayList<Point> arr;
	static int[] dx = { 0, 0, 1 };
	static int[] dy = { 1, -1, 0 };
	static int result = -1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N + 2][H + 1];
		boardchk = new boolean[N + 2][H + 1];
		int tp = 0;
		while (tp++ < M) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = tp;
			board[x][y + 1] = tp;
		}

		arr = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < H; j++) {
				if (board[i][j] == 1)
					continue;
				arr.add(new Point(i, j));
			}
		}

		for (int i = 0; i < 4; i++) {
			Ladder(0, 0, i);
			if(result > -1) break;
		}
		bw.write(result + "");
		bw.close();
		br.close();

	}

	static void Ladder(int start, int now, int end) {
		if (start == end) {
			Down(end);

			return;
		}

		for (int i = now, len = arr.size(); i < len; i++) {
			if (board[arr.get(i).x][arr.get(i).y] > 0 || board[arr.get(i).x][arr.get(i).y + 1] > 0)
				continue;

			board[arr.get(i).x][arr.get(i).y] = M + 1 + start;
			board[arr.get(i).x][arr.get(i).y + 1] = M + 1 + start;

			Ladder(start + 1, i + 1, end);

			board[arr.get(i).x][arr.get(i).y] = 0;
			board[arr.get(i).x][arr.get(i).y + 1] = 0;

		}

	}

	static void Down(int n) {
		/*
		 * System.out.println("*******"); for (int i = 1; i <= N; i++) { for (int j = 1;
		 * j <= H; j++) { System.out.print(board[i][j] + " "); } System.out.println(); }
		 */
		boolean chk = true;
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(boardchk[i], false);

		}
		for (int i = 1; i <= H; i++) {
			int x = 0;
			int y = i;
			for (int j = 0; j < N + 2;j++) {
				Arrays.fill(boardchk[j], false);

			}

			while (true) {
				for (int j = 0; j < 3; j++) {
					int mx = x + dx[j];
					int my = y + dy[j];
					if (mx > N+2 || my < 1 || my >H) continue;
					

					if( j < 2 && board[x][y] != board[mx][my]) continue;
					if( j < 2 && board[mx][my] == 0) continue;

					if (boardchk[mx][my])
						continue;
					boardchk[mx][my] = true;
					x = mx;
					y = my;
					break;
				}
				
				if(x > N) break;
				
			}
			if(y != i) {
				chk = false;
				break;
			}
		}
		if(chk ) result = n;
		
	}

}
