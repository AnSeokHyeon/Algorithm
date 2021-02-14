// 배열돌리기 3
package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16935 {
	static int N, M;
	static int gap;
	static int[][] board;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = Math.max(N, M);
		gap = Math.abs(N - M);
		board = new int[max][max];
		int R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		st = new StringTokenizer(br.readLine(), " ");
		while (R-- > 0) {

			int num = Integer.parseInt(st.nextToken());
			Rotate(num);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

	static void Rotate(int n) {
		switch (n) {
		case 1:
			int[] arr = new int[M];
			for (int i = 0; i < N / 2; i++) {
				System.arraycopy(board[N - 1 - i], 0, arr, 0, M);
				System.arraycopy(board[i], 0, board[N - 1 - i], 0, M);
				System.arraycopy(arr, 0, board[i], 0, M);
			}
			break;
		case 2:
			for (int j = 0; j < M / 2; j++) {
				for (int i = 0; i < N; i++) {
					int temp = board[i][M - 1 - j];
					board[i][M - 1 - j] = board[i][j];
					board[i][j] = temp;
				}
			}

			break;
		case 3:
			int copy[][] = new int[max][max];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					copy[j][N - 1 - i] = board[i][j];
					board[i][j] = 0;

				}
			}

			int temp = N;
			N = M;
			M = temp;
			for (int i = 0; i < N; i++) {
				System.arraycopy(copy[i], 0, board[i], 0, M);
			}
			break;
		case 4:

			copy = new int[max][max];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					copy[M - 1 - j][i] = board[i][j];
					board[i][j] = 0;

				}
			}

			temp = N;
			N = M;
			M = temp;
			for (int i = 0; i < N; i++) {
				System.arraycopy(copy[i], 0, board[i], 0, M);
			}
			break;
		case 5:
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp = board[i][j];
					board[i][j] = board[i + N / 2][j];
					board[i + N / 2][j] = board[i + N / 2][j + M / 2];
					board[i + N / 2][j + M / 2] = board[i][j + M / 2];
					board[i][j + M / 2] = temp;

				}
			}

			break;
		case 6:
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp = board[i][j];
					board[i][j] = board[i][j + M / 2];
					board[i][j + M / 2] = board[i + N / 2][j + M / 2];
					board[i + N / 2][j + M / 2] = board[i + N / 2][j];
					board[i + N / 2][j] = temp;

				}
			}
			break;

		}

	}

}
