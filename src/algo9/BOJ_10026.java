package algo9;

// 10026 적록색약
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static char map[][];
	static int N;
	static int result1, result2;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		bfs();
		bfs2();
		bw.write(result1 + " " + result2 + " ");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	private static void bfs() {
		boolean chk[][] = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		result1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (chk[i][j])
					continue;
				q.add(new Point(i, j));
				chk[i][j] = true;
				result1++;
				char c = map[i][j];

				while (!q.isEmpty()) {
					Point p = q.poll();

					int x = p.x;
					int y = p.y;

					for (int k = 0; k < 4; k++) {
						int mx = x + dx[k];
						int my = y + dy[k];

						if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
							continue;
						if (chk[mx][my])
							continue;
						if (c != map[mx][my])
							continue;

						chk[mx][my] = true;
						q.add(new Point(mx, my));
					}

				}

			}

		}

	}

	private static void bfs2() {
		boolean chk[][] = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		result2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (chk[i][j])
					continue;
				q.add(new Point(i, j));
				chk[i][j] = true;
				result2++;
				char c = map[i][j];

				while (!q.isEmpty()) {
					Point p = q.poll();

					int x = p.x;
					int y = p.y;

					for (int k = 0; k < 4; k++) {
						int mx = x + dx[k];
						int my = y + dy[k];

						if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
							continue;
						if (chk[mx][my])
							continue;
						if (c == 'B' && map[mx][my] != 'B')
							continue;
						if (c != 'B' && map[mx][my] == 'B')
							continue;

						chk[mx][my] = true;
						q.add(new Point(mx, my));
					}

				}

			}

		}

	}

}// 프로그램 종료 ㅃㅇ
