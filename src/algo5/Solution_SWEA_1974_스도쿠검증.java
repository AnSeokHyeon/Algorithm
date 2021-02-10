package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠검증 {
	static int[][] board;
	static boolean result;

	static void Line(int n) {
		boolean[] chkUD = new boolean[10];
		boolean[] chkLR = new boolean[10];
		chkUD[board[n][n]] = true;
		chkLR[board[n][n]] = true;
		for (int i = 0; i < 9; i++) {
			if (i == n)
				continue;
			if (chkLR[board[n][i]] || chkUD[board[i][n]]) {
				result = false;
				break;
			}
			chkUD[board[i][n]] = true;
			chkLR[board[n][i]] = true;

		}

	}

	static void Blk(int n, int m) {
		boolean[] chkBlk = new boolean[10];

		for (int i = n; i < n + 3; i++) {
			for (int j = m; j < m + 3; j++) {
				if (chkBlk[board[i][j]]) {
					result = false;
					break;
				}
				chkBlk[board[i][j]] = true;

			}
			if (!result)
				break;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		board = new int[9][9];
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {

					board[i][j] = Integer.parseInt(st.nextToken());

				}

			}
			result = true;
			for (int i = 0; i < 9; i++) {
				Line(i);
				if (!result)
					break;
			}
			if (result) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						Blk(i * 3, j * 3);
						if (!result)
							break;
					}
				}

			}
			sb.append("#" + (Tcnt++) + " " + (result ? 1 : 0) + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
