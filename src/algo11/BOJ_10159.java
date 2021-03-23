package algo11;

// 10159 저울
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int board[][] = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE / 2);
			board[i][i] = 0;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = 1;

		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < N + 1; j++) {
				if (board[i][j] == Integer.MAX_VALUE / 2 && board[j][i] == Integer.MAX_VALUE / 2)
					cnt++;
			}
			sb.append(cnt + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}