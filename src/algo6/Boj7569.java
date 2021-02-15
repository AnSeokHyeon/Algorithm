
// 토마토
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
	static int dz[] = { 1, -1, 0, 0, 0, 0 };
	static int dx[] = { 0, 0, 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 0, 0, 1, -1 };
	static int board[][][];
	static boolean boardChk[][][];
	static int M, N, H, size, result;

	static class Tomato {
		int x;
		int y;
		int z;
		int d;

		public Tomato() {
			super();
		}

		public Tomato(int x, int y, int z, int d) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		size = M * N * H;
		board = new int[H][N][M];
		boardChk = new boolean[H][N][M];
		Queue<Tomato> q = new LinkedList<Tomato>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == -1) {
						boardChk[i][j][k] = true;
						size--;
					}
					if (board[i][j][k] == 1) {
						boardChk[i][j][k] = true;
						q.add(new Tomato(j, k, i, 0));
						size--;
					}
				}
			}

		}
		/*
		 * for (int i = 0; i < H; i++) { for (int j = 0; j < N; j++) { for (int k = 0; k
		 * < M; k++) { System.out.print(board[i][j][k] + " ");
		 * 
		 * } System.out.println(); }
		 * 
		 * System.out.println(); }
		 */

		while (!q.isEmpty()) {
			Tomato tomato = q.poll();
			int x = tomato.x;
			int y = tomato.y;
			int z = tomato.z;
			int d = tomato.d;
			result = Math.max(result, d);

			for (int i = 0; i < 6; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int mz = z + dz[i];
				int md = d + 1;
				if (mx < 0 || my < 0 || mz < 0 || mx > N - 1 || my > M - 1 || mz > H - 1)
					continue;
				if (boardChk[mz][mx][my])
					continue;
				boardChk[mz][mx][my] = true;
				size--;
				q.add(new Tomato(mx, my, mz, md));
			}

		}
		if (size > 0)
			result = -1;
		bw.write(result + "");
		br.close();
		bw.close();
	}

}