package algo9;

// 17779 게리멘더링2
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17779 {
	static int N;
	static int board[][];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {

				board[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int x = 1; x < N - 1; x++) {
			for (int y = 2; y < N; y++) {
				for (int d1 = 1; d1 < y; d1++) {
					for (int d2 = 1; d2 <= N - y; d2++) {
						if (x + d1 + d2 > N)
							continue;
						vote(x, y, d1, d2);
					}
				}
			}

		}
		bw.write(result+ "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void vote(int x, int y, int d1, int d2) {
		int map[][] = new int[N + 1][N + 1];
		int idx[] = new int[6];
		// 5번 경계선 칠하기
		for (int i = 0; i <= d1; i++) {
			int x1 = x + i;
			int y1 = y - i;
			int x2 = x + d2 + i;
			int y2 = y + d2 - i;
			map[x1][y1] = 5;
			map[x2][y2] = 5;

		}
		for (int i = 0; i <= d2; i++) {
			int x1 = x + i;
			int y1 = y + i;
			int x2 = x + i + d1;
			int y2 = y + i - d1;

			map[x1][y1] = 5;
			map[x2][y2] = 5;

		}

		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 1;
			}
		}

		for (int i = 1; i <= x + d2; i++) {

			for (int j = N; j > y; j--) {
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 2;
			}
		}
		for (int i = N; i >= x + d1; i--) {

			for (int j = 1; j < y - d1 + d2; j++) {
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 3;
			}
		}

		for (int i = N; i > x + d2; i--) {

			for (int j = N; j >= y - d1 + d2; j--) {
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 4;
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if(map[i][j] == 0) map[i][j] = 5;
				idx[map[i][j]] += board[i][j];
			}
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<6; i++) {
			max = Math.max(max, idx[i]);
			min = Math.min(min, idx[i]);
		}

		result = Math.min(result, max - min);

	}

}// 프로그램 종료 ㅃㅇ
