package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17406 {
	static int N, M, K, result;
	static int[][] board;
	static int[] pick;
	static boolean chk[];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static ArrayList<Turn> arr;

	static class Turn {
		int x;
		int y;
		int d;

		public Turn() {
			super();
		}

		public Turn(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tp = 0;
		while (tp++ < K) {
			st = new StringTokenizer(br.readLine(), " ");
			arr.add(new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		pick = new int[arr.size()];
		chk = new boolean[arr.size() + 1];

		result = 987654321;
		Pick(0);
		bw.write(result + "");
		bw.close();
		br.close();
	}

	static void Pick(int n) {
		if (n == K) {
			Rotate();
			return;
		}

		for (int i = 0, len = arr.size(); i < len; i++) {
			if (chk[i])
				continue;
			pick[n] = i;
			chk[i] = true;
			Pick(n + 1);
			chk[i] = false;

		}

	}

	static void Rotate() {

		int copy[][] = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			System.arraycopy(board[i], 1, copy[i], 1, M);
		}
		for (int T = 0; T < K; T++) {
			int X = arr.get(pick[T]).x;
			int Y = arr.get(pick[T]).y;
			int D = arr.get(pick[T]).d;
			for (int dis = 0; dis < D; dis++) {
				int x = X - dis - 1;
				int y = Y - dis - 1;

				int temp = copy[x][y];
				int temp2 = copy[x][y];
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < (dis + 1) * 2; j++) {
						int mx = x + dx[i];
						int my = y + dy[i];

						temp = copy[mx][my];
						copy[mx][my] = temp2;
						temp2 = temp;
						x = mx;
						y = my;

					}

				}
			}

		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += copy[i][j];
			}
			result = Math.min(result, sum);
		}

	}

}
