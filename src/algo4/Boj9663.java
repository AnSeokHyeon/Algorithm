// N - QUEEN
package algo4;

import java.util.Scanner;

public class Boj9663 {
	static int N;
	static int map[][];
	static int result = 0;
	static boolean chk[];
	static int dx[] = { 1, -1, 1, -1 };
	static int dy[] = { 1, 1, -1, -1 };

	static void dfs(int n) {
		if (n == N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (chk[i])
				continue;
			boolean crush = true;
			for (int j = 0; j < 4; j++) {
				int cnt = 1;
				while (true) {
					int mx = n + dx[j] * cnt;
					int my = i + dy[j] * cnt++;

					if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
						break;
					if (map[mx][my] != 0) {

						crush = false;
						break;
					}

				}
				if (!crush)
					break;

			}

			if (!crush)
				continue;

			map[n][i] = n + 1;
			chk[i] = true;
			dfs(n + 1);
			map[n][i] = 0;
			chk[i] = false;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		chk = new boolean[N];
		dfs(0);
		System.out.println(result);
		sc.close();

	}

}
