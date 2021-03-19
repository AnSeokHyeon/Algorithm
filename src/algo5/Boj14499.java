package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14499 {
	static int[][] cube = new int[5][5];
	static int N, M;
	static int[][] map;

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	static void cubing(int n) {
		if (n == 1) {

			for (int i = 4; i > 0; i--) {
				cube[2][i] = cube[2][i-1];
			}
			cube[0][2] = cube[2][4];
			cube[4][2] = cube[2][4];
			cube[2][0] = cube[2][4];

		} else if (n == 2) {

			for (int i = 0; i < 4; i++) {
				cube[2][i] = cube[2][i + 1];
			}
			cube[2][4] = cube[2][0];
			cube[4][2] = cube[2][0];
			cube[0][2] = cube[2][0];

		} else if (n == 3) {

			for (int i = 0; i < 4; i++) {
				cube[i][2] = cube[i+1][2];
			}
			cube[2][4] = cube[0][2];
			cube[4][2] = cube[0][2];
			cube[2][0] = cube[0][2];
			

		} else if (n == 4) {

			for (int i = 4; i > 0; i--) {
				cube[i][2] = cube[i -1][2];
			}
			cube[0][2] = cube[4][2];
			cube[2][4] = cube[4][2];
			cube[2][0] = cube[4][2];

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N ][M];
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		st = new StringTokenizer(br.readLine(), " ");
		while (K-- > 0) {
			System.out.println();
			System.out.println("실행 ***********************");
			System.out.println();
			int d = Integer.parseInt(st.nextToken());
			int mx = x + dx[d];
			int my = y + dy[d];
			if (mx < 0 || my <0 || mx > N-1 || my > M-1)
				continue;

			cubing(d);
			System.out.println("주사위 돌리고나서");
			for (int i = 0; i < 5 ; i++) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(cube[i][j] + " ");
				}
				System.out.println();

			}
			//System.out.println(x + " , " + y + " | " + mx + " , " + my + " | " + d);
			
			if (map[mx][my] == 0) {

				map[mx][my] = cube[2][0];

			}

			else {
				cube[0][2] = map[mx][my];
				cube[2][4] = map[mx][my];
				cube[2][0] = map[mx][my];
				cube[4][2] = map[mx][my];

				map[mx][my] = 0;

			}

			x = mx;
			y = my;
			sb.append(cube[2][2] + "\n");

			System.out.println("지도  돌리고나서");
			for (int i = 0; i < 5 ; i++) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(cube[i][j] + " ");
				}
				System.out.println();

			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
