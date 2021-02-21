package algo6;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2638 {
	static int board[][];
	static boolean boardchk[][];
	static int N, M;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		boardchk = new boolean[N + 1][M + 1];//산소 활성 비활성 체크
		Queue<Point> q = new LinkedList<Point>(); // 치즈가 있는 곳
		Queue<Point> q2 = new LinkedList<Point>(); // 산소 (활성 / 비활성)
		ArrayList<Point> arr = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					q.add(new Point(i, j));
				} 
			}
		}
		
		q2.add(new Point(1, 1));
		boardchk[1][1] = true;

		int time = 0;
		while (true) {
			arr.clear();
			while (!q2.isEmpty()) {
				Point top = q2.poll();
				int x = top.x;
				int y = top.y;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];

					if (mx < 1 || my < 1 || mx > N || my > M)
						continue;
					if (board[mx][my] == 1)
						continue;
					if (boardchk[mx][my])
						continue;
					boardchk[mx][my] = true;
					q2.add(new Point(mx, my));
				}
			}

			int size = q.size();
			while (size-- > 0) {
				Point top = q.poll();
				int x = top.x;
				int y = top.y;
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];

					if (mx < 1 || my < 1 || mx > N || my > M)
						continue;
					if (board[mx][my] == 1)
						continue;
					if (!boardchk[mx][my])
						continue;
					cnt++;
				}

				if (cnt > 1) {
					arr.add(new Point(x, y));
				} else {
					q.add(new Point(x, y));
				}

			}
			int len = arr.size();
			for (int i = 0; i < len; i++) {
				int x = arr.get(i).x;
				int y = arr.get(i).y;
				board[x][y] = 0;
				boardchk[x][y] = true;
				q2.add(new Point(x, y));
			}
			time++;
			if (q.isEmpty())
				break;
		}
		bw.write(time + "");
		bw.close();
		br.close();
	}

}