package algo11;

// 1600 말이 되고픈 원숭이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

	static int dx[] = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dy[] = { 0, 0, 1, -1, 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Position {
		int x; 
		int y;
		int d; // 이동횟수
		int k;

		public Position(int x, int y, int d, int k) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int board[][] = new int[N + 1][M + 1];
		boolean chk[][][] = new boolean[N + 1][M + 1][K + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Position> q = new LinkedList<>();
		q.add(new Position(1, 1, 0, K));
		chk[1][1][K] = true;
		int result = -1;
		int flag = 1;
		while (!q.isEmpty()) {
			Position p = q.poll();

			int x = p.x;	int y = p.y;
			int d = p.d;	int k = p.k;

			if (x == N && y == M) {
				result = d;
				break;
			}
			flag = k==0 ? 0 : 1;
			for (int i = 0; i < 4 + 8 * flag; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;
				int mk = k;
				if (i > 3) mk--;
				if (mx < 1 || my < 1 || mx > N || my > M) continue;
				if (chk[mx][my][mk] || board[mx][my] == 1) continue;
				chk[mx][my][mk] = true;
				q.add(new Position(mx, my, md, mk));
			}

		}

		System.out.println(result);
		br.close();
	}

}