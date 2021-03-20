package algo10;

// 17822 원판돌리기
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822 {
	static int N, M, K;
	static int board[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Queue<Point> q;
	static int cnt, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			while (k-- > 0) {
				int cnt = 1;
				while(x*cnt <=N) {
					turn(x*(cnt++), d);	
				}
			}
			find();

		}
		bw.write(sum + "");
		br.close();
		bw.close();
	}

	static void find() {
		sum = 0;
		cnt = 0;
		boolean resultChk = false;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (board[i][j] == 0)
					continue;
				int idx = board[i][j];
				sum += board[i][j];
				cnt++;
				q.add(new Point(i, j));
				boolean chk = false;
				while (!q.isEmpty()) {
					Point p = q.poll();

					int x = p.x;
					int y = p.y;
					for (int k = 0; k < 4; k++) {

						int mx = x + dx[k];
						int my = y + dy[k];

						if (mx > N || mx < 1) continue;
						if (my > M)
							my = 1;
						if (my < 1)
							my = M;

						if (board[mx][my] != idx)
							continue;
						q.add(new Point(mx, my));
						board[mx][my] = 0;
						chk = true;

					}

				}
				if (chk) {
					sum -= idx;
					cnt--;
					resultChk = true;
				}
			}
		}
		if(!resultChk) {
			double avg = (double) sum / cnt;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					if(board[i][j] == 0) continue;
					if(avg > board[i][j]) {
						board[i][j]++;
						sum++;
					}
					else if(board[i][j] > avg) {
						board[i][j]--;
						sum--;
					}
				}
			}
		}

	}

	static void turn(int line, int direction) {

		if (direction == 0) {
			int temp = board[line][M];
			for (int j = M; j > 1; j--) {
				board[line][j] = board[line][j - 1];
			}
			board[line][1] = temp;
		} else {
			int temp = board[line][1];
			for (int j = 1; j < M; j++) {
				board[line][j] = board[line][j + 1];
			}
			board[line][M] = temp;
		}
	}

}