package algo11;

// 9205 맥주 마시면서 걸어가기
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9205 {

	static ArrayList<Point> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			arr.clear();

			int M = Integer.parseInt(br.readLine());
			int N = M + 2;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr.add(new Point(x, y));
			}

			int board[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(board[i], Integer.MAX_VALUE / 2);
				int x = arr.get(i).x;
				int y = arr.get(i).y;

				for (int j = 0; j < N; j++) {
					int x2 = arr.get(j).x;
					int y2 = arr.get(j).y;

					int distance = Math.abs(x - x2) + Math.abs(y - y2);
					if (distance > 1000)
						continue;
					board[i][j] = distance;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(board[i][j] >  board[i][k] + board[k][j]) {
							board[i][j]  = board[i][k] + board[k][j];
						}
					}
				}
			}
			
			if(board[0][M+1] != Integer.MAX_VALUE/2) {
				sb.append("happy\n");
			}
			else {
				sb.append("sad\n");
			}

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}