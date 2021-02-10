package algo5;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16234 {
	static int N, L, R, result;
	static int[][] board;
	static int[][] boardChk;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		boardChk = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		while(true) {
			for(int i = 0; i<N; i++) {
				Arrays.fill(boardChk[i], 0);
				
			}

			int count = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (boardChk[i][j] > 0)
						continue;
					Opening(i, j, count++);
				}
			}
			if(count > N *N)break;
			result++;
		}
		bw.write(result + "");
		bw.close();
		br.close();
	}

	static void Opening(int n, int m, int idx) {
		boardChk[n][m] = idx;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(n, m));
		int cnt = 1;
		int sum = board[n][m];
		while (!q.isEmpty()) {
			Point top = q.poll();

			int x = top.x;
			int y = top.y;

			for (int i = 0; i < 4; i++) {

				int mx = x + dx[i];
				int my = y + dy[i];
				
				if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
					continue;
				if (boardChk[mx][my] > 0)
					continue;
				int gap = Math.abs(board[mx][my] - board[x][y]);
				if (gap > R || gap < L)
					continue;

				cnt++;
				sum += board[mx][my];
				boardChk[mx][my] = idx;
				q.add(new Point(mx, my));

			}

		}
		int avg = sum / cnt;
		

		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				if (boardChk[i][j] == idx)
					board[i][j] = avg;
			}
		}

	}

}
