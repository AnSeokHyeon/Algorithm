package algo6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_안석현 {
	static int N, result;
	static int board[][];
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
		int pickTrue = 0;
		int pickFalse = 0;
		for (int i = 1; i < N; i++) {
			boolean pickChk = pick[i];

			for (int j = i + 1; j <= N; j++) {
				if (pickChk != pick[j])
					continue;

				if (pickChk) {
					pickTrue += board[i][j] + board[j][i];

				} else {
					pickFalse += board[i][j] + board[j][i];
				}

			}
		}

		int gap = Math.abs(pickFalse - pickTrue);

		if (result > gap)
			result = gap;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			N = Integer.parseInt(br.readLine());
			board = new int[N + 1][N + 1];
			pick = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 1; j <= N; j++) {

					board[i][j] = Integer.parseInt(st.nextToken());

				}

			}
			result = 987654321;
			for (int i = 1; i <= N / 2; i++) {
				pick[i] = true;
				dfs(2, i + 1);
				pick[i] = false;
			}
			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
