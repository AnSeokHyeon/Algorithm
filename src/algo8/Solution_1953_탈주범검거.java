package algo8;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int pipeLine[][] = {
		{0,0,0,0},
		{1,1,1,1},
		{1,0,1,0},
		{0,1,0,1},
		{1,1,0,0},
		{0,1,1,0},
		{0,0,1,1},
		{1,0,0,1}
	};

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int board[][] = new int[N+1][M+1];
			int chk[][] = new int[N+1][M+1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R+1, C+1));
			chk[R+1][C+1] = 1;
			while (!q.isEmpty()) {
				Point top = q.poll();

				int x = top.x;
				int y = top.y;
				int time = chk[x][y];
				int pipe = board[x][y];

				if (time == L) {
					break;
				}

				for (int i = 0; i < 4; i++) {
					if (pipeLine[pipe][i] == 0)
						continue;
					int mx = x + dx[i];
					int my = y + dy[i];
					if(mx< 1||my< 1||mx >N||my>M) continue;
					if (board[mx][my] == 0 || chk[mx][my] > 0)
						continue;
					if (pipeLine[board[mx][my]][(i + 2) % 4] == 0)
						continue;
					chk[mx][my] = time + 1;
					q.add(new Point(mx, my));

				}
			}
			int result = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (chk[i][j] > 0)
						result++;
				}
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}