package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder {
	static int[][] map;
	static boolean[][] chk;
	static final int size = 101;
	static boolean result;
	static int[] dx = { 0, 0, 1 };
	static int[] dy = { 1, -1, 0 };

	static void dfs(int x, int y) {
		if (x == 100) {
			/*
			 * for (int i = 1; i < size; i++) {
			 * 
			 * for (int j = 1; j < size; j++) { if (chk[i][j]) System.out.print("* "); else
			 * if (map[i][j] == 1) { System.out.print("1 "); } else {
			 * System.out.print("  "); } } System.out.println(); }
			 */
			if (map[x][y] == 2)
				result = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx < 1 || my < 1 || mx > size - 1 || my > size - 1)
				continue;
			if (map[mx][my] == 0 || chk[mx][my])
				continue;

			chk[mx][my] = true;
			dfs(mx, my);
			break;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 1;
		while (T < 11) {
			int Tcnt = Integer.parseInt(br.readLine());
			map = new int[size][size];
			result = false;

			for (int i = 1; i < size; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");

				for (int j = 1; j < size; j++) {
					map[i][j] = Integer.parseInt(s.nextToken());

				}

			}
			int ans = 0;

			for (int i = 1; i < size; i++) {
				if (map[1][i] == 0)
					continue;

				chk = new boolean[size][size];

				dfs(1, i);

				if (result) {
					ans = i;
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(T++).append(" ").append(ans - 1).append("\n");
			bw.write(sb.toString());
			bw.flush();
		}

		bw.close();
		br.close();

	}

}
