// 스타트와 링크
package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14889 {
	static int N, result;
	static int map[][];
	static boolean pick[];

	static void dfs(int n, int m) {
		if (n == (N / 2) + 1) {
			cal();
			return;
		}

		for (int i = m; i <= N; i++) {
			if (pick[i])
				continue;
			pick[i] = true;
			dfs(n + 1, i + 1);
			pick[i] = false;

		}

	}

	static void cal() {
		int teamTrue = 0;
		int teamFalse = 0;
		for (int i = 1; i < N; i++) {
			boolean teamChk = pick[i];

			for (int j = i + 1; j <= N; j++) {
				if (teamChk != pick[j])
					continue;

				if (teamChk) {
					teamTrue += map[i][j] + map[j][i];

				} else {
					teamFalse += map[i][j] + map[j][i];
				}

			}
		}

		int gap = Math.abs(teamFalse - teamTrue);

		if (result > gap)
			result = gap;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		pick = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= N; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		result = 987654321;
		for (int i = 1; i <= N / 2; i++) {
			pick[i] = true;
			dfs(2, i + 1);
			pick[i] = false;
		}
		bw.write(result + "");
		br.close();
		bw.close();

	}

}
