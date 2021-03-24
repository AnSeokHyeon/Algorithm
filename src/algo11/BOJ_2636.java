package algo11;

// 2636 치즈
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int board[][] = new int[N + 1][M + 1];
		boolean chkBoard[][] = new boolean[N + 1][M + 1];

		int time = 0;
		int result = 0;
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		Queue<Point> cheeze = new LinkedList<>();
		Queue<Point> air = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					cheeze.add(new Point(i, j));
				}
			}
		}

		air.add(new Point(1, 1));
		chkBoard[1][1] = true;

		while (!air.isEmpty()) {
			Point p = air.poll();

			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 1 || my < 1 || mx > N || my > M)
					continue;
				if (chkBoard[mx][my] || board[mx][my] == 1)
					continue;

				chkBoard[mx][my] = true;
				air.add(new Point(mx, my));
			}
		}

		while (true) {
			int cheezeSize = cheeze.size();
			if (cheezeSize == 0)
				break;
			else
				result = cheezeSize;
			while (cheezeSize-- > 0) {
				Point p = cheeze.poll();

				int x = p.x;
				int y = p.y;

				boolean check = true;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];

					if (board[mx][my] == 0 && chkBoard[mx][my]) {
						air.add(new Point(x, y));
						chkBoard[x][y] = true;
						check = false;
						break;
					}
				}

				if (check) {
					cheeze.add(new Point(x, y));
				}

			}

			time++;

			while (!air.isEmpty()) {
				Point p = air.poll();

				int x = p.x;
				int y = p.y;

				board[x][y] = 0;

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (board[mx][my] == 1 || chkBoard[mx][my])
						continue;
					chkBoard[mx][my] = true;

					air.add(new Point(mx, my));

				}

			}
			
		}
		System.out.println(time);
		System.out.println(result);
		br.close();
	}

}