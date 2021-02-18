package algo6;

// 3109 빵집

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer;

public class Boj3109 {
	static char map[][];
	static int R, C;
	static boolean chk[][];
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 1, 1, 1 };
	static int result;

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		chk = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		result = 0;
		for (int i = 0; i < R; i++) {
			cal(i, 0);
		}

		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static boolean cal(int n, int m) {
		chk[n][m] = true;
		if (m == C - 1) {
			result++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int x = n + dx[i];
			int y = m + dy[i];
			if (x > R - 1 || x < 0)
				continue;
			if (map[x][y] == 'x')
				continue;

			if (chk[x][y])
				continue;

			if (cal(x, y))
				return true;

		}

		return false;

	}
}// 프로그램 종료 ㅃㅇ
