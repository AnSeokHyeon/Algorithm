package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16926 {

	static int N, M, R, max, min;

	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void turn(int x, int y) {
		int size = x;
		int temp =  board[x][y];
		int temp2 = board[x][y];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < max; j++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				if(mx < 1 +(size-1) || my < 1 +(size-1)|| mx > N - (size-1) || my > M -(size-1)) break;
				temp = board[mx][my];
				board[mx][my] = temp2;
				temp2 = temp;
				x = mx;
				y = my;
				/*System.out.println("****************");
				for (int a = 1;a < N + 1; a++) {
					for (int b= 1; b < M + 1;b++) {
						System.out.print(board[a][b] + " ");
					}
					System.out.println();
				}
*/
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Math.max(N, M);
		min = Math.min(N, M);

			for (int i = 1; i < N + 1; i++) {
				if (i > min+1 / 2)
					break;
				int num = R % ((N+1-i) * (M+1-i) - 4);
				while(num-- > 0) {
					turn(i, i);	
				}
			}


		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
