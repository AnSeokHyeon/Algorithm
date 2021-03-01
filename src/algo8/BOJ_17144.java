// 17144 미세먼지 안녕!

package algo8;

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int R, C, T;
	static int board[][];
	static int airX, airY;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R + 1][C + 1];

		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < C + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1 && airX == 0 && airY == 0) {
					airX = i;
					airY = j;
				}
			}
		}
		int num = 0;
		while (num < T) {

			spread();
			on();
			num++;
		}
		int result = 0;
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (board[i][j] < 1)
					continue;
				result += board[i][j];
			}
		}
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void spread() {

		int copy[][] = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (board[i][j] == 0)
					continue;
				int volume = board[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int mx = i + dx[k];
					int my = j + dy[k];

					if (mx < 1 || my < 1 || mx > R || my > C)
						continue;
					if ((mx == airX || mx == airX + 1) && my == airY)
						continue;
					board[i][j] -= volume;
					copy[mx][my] += volume;
				}

				copy[i][j] += board[i][j];
			}
		}

		for (int i = 1; i < R + 1; i++) {
			System.arraycopy(copy[i], 1, board[i], 1, C);
		}
	}

	static void on() {

		for (int i = airX - 1; i > 1; i--) {
			board[i][airY] = board[i - 1][airY];
		}
		for (int i = airX + 2; i < R; i++) {
			board[i][airY] = board[i + 1][airY];
		}

		for (int j = 1; j < C; j++) {
			board[1][j] = board[1][j + 1];
			board[R][j] = board[R][j + 1];
		}

		for (int i = 1; i < airX; i++) {
			board[i][C] = board[i + 1][C];
		}
		for (int i = R; i > airX + 1; i--) {
			board[i][C] = board[i - 1][C];
		}

		for (int j = C; j > 2; j--) {
			board[airX][j] = board[airX][j - 1];
			board[airX + 1][j] = board[airX + 1][j - 1];
		}

		board[airX][2] = 0;
		board[airX + 1][2] = 0;

	}

}// 프로그램 종료 ㅃㅇ
