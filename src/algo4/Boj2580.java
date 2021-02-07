package algo4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2580 {
	static int board[][];
	static ArrayList<Point> empty;
	static int[] pick;
	static StringBuilder sb;
	static boolean result;

	static void dfs(int n) {
		if (n == empty.size()) {
			cal();

			return;
		}

		for (int i = 1; i < 10; i++) {
			// 가로 세로 체크
			boolean chk = true;
			int x = empty.get(n).x;
			int y = empty.get(n).y;
			for (int j = 0; j < 9; j++) {
				if (board[x][j] == i || board[j][y] == i) {
					chk = false;
				}
			}
			if (!chk)
				continue;
			// 구역 체크
			int bx = (x / 3) * 3;
			int by = (y / 3) * 3;
			for (int j = bx; j < bx + 3; j++) {
				for (int k = by; k < by + 3; k++) {
					if (board[j][k] == i) {
						chk = false;
					}

				}
			}
			if (!chk)
				continue;

			board[x][y] = i;
			dfs(n + 1);
			board[x][y] = 0;
			if(result) break;

		}

	}

	static void cal() {
		/*for (int i = 0; i < empty.size(); i++) {
			board[empty.get(i).x][empty.get(i).y] = pick[i];
		}
*/
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j] + " ");

			}
			
			sb.append("\n");

		}
		result = true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		board = new int[10][10];
		empty = new ArrayList<>();
		sb = new StringBuilder();
		result = false;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 9; j++) {
				board[i][j] = st.nextToken().charAt(0) - '0';
				if (board[i][j] == 0) {
					empty.add(new Point(i, j));
				}

			}

		}
		pick = new int[empty.size()];

		dfs(0);
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
