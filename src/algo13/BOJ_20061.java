package algo13;

// 20061 모노미노도미노 2 성공분류

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20061 {
	static int blueBoard[][] = new int[11][4];
	static int redBoard[][] = new int[11][4];
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		for (int i = 0; i < 4; i++) {
			blueBoard[10][i] = 9;
			redBoard[10][i] = 9;
		}

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			blue(t, x, y, idx);
			red(t, x, y, idx);

			bomb();
			green();
		/*	System.out.println();
			System.out.println("결과@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("redBoard");
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(redBoard[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println();

			System.out.println("blueBoard");
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(blueBoard[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
*/
			idx++;

		}
	
		bw.write(result + "\n" + total());
		br.close();
		bw.close();
	}

	private static int total() {
		int cnt = 0;
		
		for(int i = 9; i > 5; i--) {
			for(int j = 0; j<4; j++) {
				if(redBoard[i][j] == 0) continue;
				cnt++;
				
			}
			
			for(int j = 0; j<4; j++) {
				if(blueBoard[i][j] == 0) continue;
				cnt++;
				
			}
		}
		
		
		
		return cnt;
	}

	private static void green() {
		int rcnt = 0;
		int bcnt = 0;

		for (int i = 4; i < 6; i++) {

			for (int j = 0; j < 4; j++) {
				if(redBoard[i][j] == 0) continue;
				rcnt++;
				break;
			}

			for (int j = 0; j < 4; j++) {
				if(blueBoard[i][j] == 0) continue;
				bcnt++;
				break;
			}
		}
		for (int i = 9; i > 3; i--) {

			for (int j = 0; j < 4; j++) {
				redBoard[i][j] = redBoard[i - rcnt][j];
				blueBoard[i][j] = blueBoard[i - bcnt][j];
			}

		}

	}

	private static void bomb() {

		for (int i = 9; i > 3; i--) {

			boolean redChk = true;
			for (int j = 0; j < 4; j++) {
				if (redBoard[i][j] > 0)
					continue;
				redChk = false;
			}

			if (redChk) {
				for (int k = i; k > 3; k--) {
					for (int j = 0; j < 4; j++) {
						redBoard[k][j] = redBoard[k - 1][j];
					}
				}
				result++;
				i++;
			}
		}

		for (int i = 9; i > 3; i--) {

			boolean blueChk = true;
			for (int j = 0; j < 4; j++) {
				if (blueBoard[i][j] > 0)
					continue;
				blueChk = false;
			}

			if (blueChk) {
				for (int k = i; k > 4; k--) {
					for (int j = 0; j < 4; j++) {
						blueBoard[k][j] = blueBoard[k - 1][j];
					}
				}
				for (int j = 0; j < 4; j++) {
					blueBoard[4][j] = 0;
				}
				result++;

				i++;
			}
		}
	}

	private static void red(int t, int x, int y, int index) {

		if (t == 1) {

			for (int i = 4; i < 11; i++) {
				if (redBoard[i][y] == 0)
					continue;
				redBoard[i - 1][y] = index;
				break;
			}
		}

		if (t == 2) {
			for (int i = 4; i < 11; i++) {
				if (redBoard[i][y] == 0 && redBoard[i][y + 1] == 0)
					continue;
				redBoard[i - 1][y] = index;
				redBoard[i - 1][y + 1] = index;
				break;
			}
		}

		if (t == 3) {
			for (int i = 5; i < 11; i++) {
				if (redBoard[i][y] == 0 && redBoard[i - 1][y] == 0)
					continue;
				redBoard[i - 1][y] = index;
				redBoard[i - 2][y] = index;
				break;
			}
		}

	}

	private static void blue(int t, int x, int y, int index) {

		if (t == 1) {
			for (int i = 4; i < 11; i++) {
				if (blueBoard[i][3 - x] == 0)
					continue;
				blueBoard[i - 1][3 - x] = index;
				break;
			}
		}

		if (t == 2) {
			for (int i = 5; i < 11; i++) {
				if (blueBoard[i][3 - x] == 0 && blueBoard[i - 1][3 - x] == 0)
					continue;
				blueBoard[i - 1][3 - x] = index;
				blueBoard[i - 2][3 - x] = index;
				break;
			}
		}

		if (t == 3) {
			for (int i = 4; i < 11; i++) {
				if (blueBoard[i][3 - x] == 0 && blueBoard[i][3 - x - 1] == 0)
					continue;
				blueBoard[i - 1][3 - x] = index;
				blueBoard[i - 1][3 - x - 1] = index;
				break;
			}

		}

	}

}