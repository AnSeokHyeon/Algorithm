package algo3;

import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_D2 {
	static int N; 
	static int x;  
	static int y;
	static int d;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void dfs(int n) {

		int nx = x;
		int ny = y;

		map[x][y] = n;

		for (int i = 0; i < 4; i++) {
			int mx = x + dx[(d + i) % 4];
			int my = y + dy[(d + i) % 4];

			if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1 || map[mx][my] > 0)
				continue;
			x = mx;
			y = my;
			d = d + i;
			break;

		}
		if (nx == x && ny == y)
			return;
		else
			dfs(n + 1);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int Tcnt = 1;
		while (T-- > 0) {

			N = sc.nextInt();

			map = new int[N][N];

			x = y = d = 0;

			dfs(1);

			System.out.println("#" + Tcnt++);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();

			}
		}
		sc.close();

	}

}
