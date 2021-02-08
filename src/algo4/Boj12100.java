package algo4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj12100 {
	static int N, result;
	static int board[][];

	static int pick[] = new int[5];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static void dfs(int n) {
		if (n == 5) {
			cal();
			return;
		}
		for (int i = 0; i < 4; i++) {
			// if(n == 0 && i != 1) continue;
			pick[n] = i;
			dfs(n + 1);

		}

	}

	static void cal() {
		int map[][] = new int[N][N];
		boolean chk[][];
		int max = 0;
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, map[i], 0, N);
		}
		for (int i = 0; i < 5; i++) {
			chk = new boolean[N][N];
			if (pick[i] == 0) {
				for (int j = 1; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (map[j][k] == 0)
							continue;
						int x = j;
						int y = k;
						while (true) {
							int mx = x + dx[pick[i]];
							int my = y + dy[pick[i]];
							if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1
									|| (map[mx][my] != 0 && (map[mx][my] != map[j][k])) || chk[mx][my]) {
								map[x][y] = map[j][k];
								if (x != j || y != k)
									map[j][k] = 0;
								break;
							} else if (map[mx][my] != 0 && (map[mx][my] == map[j][k])) {
								map[mx][my] = map[mx][my] + map[j][k];
								map[j][k] = 0;
								chk[mx][my] = true;
								break;
							} else {
								x = mx;
								y = my;
							}
						}

					}
				}

			} else if (pick[i] == 1) {
				for (int j = N - 2; j > -1; j--) {
					for (int k = 0; k < N; k++) {
						if (map[k][j] == 0)
							continue;
						int x = k;
						int y = j;
						while (true) {
							int mx = x + dx[pick[i]];
							int my = y + dy[pick[i]];
							if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1
									|| (map[mx][my] != 0 && (map[mx][my] != map[k][j])) || chk[mx][my]) {
								map[x][y] = map[k][j];
								if (x != k || y != j)
									map[k][j] = 0;

								break;
							} else if (map[mx][my] != 0 && (map[mx][my] == map[k][j])) {
								map[mx][my] = map[mx][my] + map[k][j];
								map[k][j] = 0;
								chk[mx][my] = true;
								break;
							} else {
								x = mx;
								y = my;
							}
						}

					}
				}

			} else if (pick[i] == 2) {
				for (int j = N - 2; j > -1; j--) {
					for (int k = 0; k < N; k++) {
						if (map[j][k] == 0)
							continue;
						int x = j;
						int y = k;
						while (true) {
							int mx = x + dx[pick[i]];
							int my = y + dy[pick[i]];
							if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1
									|| (map[mx][my] != 0 && (map[mx][my] != map[j][k])) || chk[mx][my]) {
								map[x][y] = map[j][k];
								if (x != j || y != k)
									map[j][k] = 0;

								break;
							} else if (map[mx][my] != 0 && (map[mx][my] == map[j][k])) {
								map[mx][my] = map[mx][my] + map[j][k];
								map[j][k] = 0;
								chk[mx][my] = true;
								break;
							} else {
								x = mx;
								y = my;
							}
						}

					}
				}

			} else if (pick[i] == 3) {
				for (int j = 1; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (map[k][j] == 0)
							continue;
						int x = k;
						int y = j;
						while (true) {
							int mx = x + dx[pick[i]];
							int my = y + dy[pick[i]];
							if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1
									|| (map[mx][my] != 0 && (map[mx][my] != map[k][j])) || chk[mx][my]) {
								map[x][y] = map[k][j];
								if (x != k || y != j)
									map[k][j] = 0;
								break;
							} else if (map[mx][my] != 0 && (map[mx][my] == map[k][j])) {
								map[mx][my] = map[mx][my] + map[k][j];
								map[k][j] = 0;
								chk[mx][my] = true;
								break;
							} else {
								x = mx;
								y = my;
							}
						}
					}
				}

			}
		}
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				max = Math.max(map[i][j], max);

			}

		}
		result = Math.max(result, max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		result = 0;
		dfs(0);
		bw.write(result + "");
		bw.close();
		br.close();
	}

}
