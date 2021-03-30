package algo12;

// 16991 외판원 순회 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16991 {
	static int N;
	static double board[][];
	static double dp[][];
	static int start = 0;
	static int x[], y[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		x = new int[N];
		y = new int[N];
		dp = new double[N][1 << N];
		board = new double[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {

			int x1 = x[i];
			int y1 = y[i];

			for (int j = 0; j < N; j++) {
				if (i == j) {
					board[i][j] = Integer.MAX_VALUE / 2;
					continue;
				}

				int x2 = x[j];
				int y2 = y[j];
				board[i][j] = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			}
		}

		bw.write(dfs(0, 1) + "");

		bw.close();
		br.close();

	}

	private static double dfs(int here, int flag) {
		// TODO Auto-generated method stub
		double result = 987654321;
		if(flag == (1<<N) -1) {
			return board[here][start];
		}
		
		if(dp[here][flag] != 0) {
			return dp[here][flag];
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) > 0)	continue;

			result = Math.min(result, board[here][i] + dfs(i, flag | 1 << i));
		}

		return dp[here][flag] = result;
	}
}