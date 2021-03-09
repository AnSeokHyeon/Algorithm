package algo9;

// 2573 빙산
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Ice {
		int x;
		int y;
		int h;

		public Ice(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}

	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Ice> q = new LinkedList<>();
		int map[][] = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0)
					q.add(new Ice(i, j, map[i][j]));
			}
		}

		int time = 0;
		while (true) {
			int size = q.size();
			if (size == 0) {
				time = 0;
				break;
			}
			boolean chk[][] = new boolean[N + 1][M + 1];
			int copy[][] = new int[N + 1][M + 1];
			boolean result = false;
			Queue<Point> q2 = new LinkedList<>();
			q2.add(new Point(q.peek().x, q.peek().y));
			chk[q.peek().x][q.peek().y] = true;
			int iceCnt = 1;
			while (!q2.isEmpty()) {
				Point p = q2.poll();
				int x = p.x;
				int y = p.y;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (mx < 1 || my < 1 || mx > N || my > M)
						continue;
					if (map[mx][my] == 0)
						continue;
					if (chk[mx][my])
						continue;
					chk[mx][my] = true;
					q2.add(new Point(mx, my));
					iceCnt++;
				}
			}
			if (iceCnt == size)
				result = true;
			if (!(result))
				break;

			time++;

			while (size-- > 0) {
				Ice ice = q.poll();

				int x = ice.x;
				int y = ice.y;
				int h = ice.h;
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (mx < 1 || my < 1 || mx > N || my > M)
						continue;
					if (map[mx][my] > 0)
						continue;
					cnt++;
				}

				h -= cnt;
				if (h > 0) {
					copy[x][y] = h;
					q.add(new Ice(x, y, h));
				}
			}

			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < M + 1; j++) {
					map[i][j] = copy[i][j];
				}
			}
			/*
			 * System.out.println("결과"); for(int i = 1; i<N+1; i++) { for(int j = 1;
			 * j<M+1;j++) { System.out.print(map[i][j] + " "); } System.out.println(); }
			 */

		}
		bw.write(time + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
