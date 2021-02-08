package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14890 {
	static int N, L, result;
	static int[][] map;

	static void road(int x, int y, int n) {
		boolean check = true;

		int[] copy = new int[N + 1];
		boolean[] chk = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			if (n == 0) {
				copy[i] = map[x][i];
			} else {
				copy[i] = map[i][y];

			}

		}

		for (int i = 1; i < N + 1; i++) {
			if (chk[i])
				continue;

			if (i > 1 && copy[i - 1] != copy[i]) {
				if (copy[i - 1] > copy[i]) {
					int num = 0;
					while (num < L) {
						if (i + num > N || chk[i + num] || copy[i - 1] != copy[i + num] + 1) {
							check = false;
							break;
						}
						chk[i + num] = true;
						num++;
					}
				} else {
					int num = 0;
					while (num < L) {
						if (i - 1 - num < 1 || chk[i - 1 - num] || copy[i] != copy[i - 1 - num] + 1) {
							check = false;
							break;
						}
						chk[i - 1 - num] = true;
						num++;
					}

				}
			} else if (i < N && chk[i + 1] != chk[i]) {
				if (copy[i + 1] > copy[i]) {
					int num = 0;
					while (num < L) {
						if (i - num < 1 || chk[i - num] || copy[i + 1] != copy[i - num] + 1) {
							check = false;
							break;
						}
						chk[i - num] = true;
						num++;
					}

				} else {
					int num = 0;
					while (num < L) {
						if (i + 1 + num > N || chk[i + 1 + num] || copy[i] != copy[i + 1 + num] + 1) {
							check = false;
							break;
						}
						chk[i + 1 + num] = true;
						num++;
					}

				}

			} else
				continue;

			if (!check)
				break;
		}

		if (check)
			result++;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		result = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i > 1 && j > 1)
					continue;
				if (i > j) {
					road(i, j, 0);
				} else if (i == j) {
					road(i, j, 0);
					road(i, j, 1);

				} else {
					road(i, j, 1);

				}
			}
		}
		bw.write(result + "");
		br.close();
		bw.close();

	}

}
