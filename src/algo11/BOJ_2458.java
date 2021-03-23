package algo11;
// 2458 키순서
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int board[][] = new int[N + 1][N + 1];
		int rank[] = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE/2);
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
		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < N + 1; j++) {
				if(board[i][j] == Integer.MAX_VALUE/2 && board[j][i] == Integer.MAX_VALUE/2) continue;
				cnt++;
			}
			rank[cnt]++;
		}
		int result = rank[N];

		bw.write(result+ "");
		br.close();
		bw.close();
	}

}