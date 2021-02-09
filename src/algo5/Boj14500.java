package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj14500 {
	static int dx[] = {0,-2,-2,-1,-1,-1,-1,0,0,0,0,0,1,1,1,1,2,2,3,-1,-2,1,2 };
	static int dy[] = {0,-1,0,-1,0,1,2,-2,-1,1,2,3,-2,-1,0,1,0,1,0,-2,1,2,-1 };
	static int[][] matrix = { {0,9,10,11},{0,14,16,18}, //----
			{0,9,14,15}, // --**
			{0,14,16,17}, {0,9,10,6}, {0,4,2,1},{0,8,7,12}, //--* 
			{0,14,16,22},{0,8,7,19},{0,4,2,20},{0,9,10,21},
			{0,14,15,17},{0,9,5,6}, //-*
			{0,14,13,22},{0,9,15,21},
			{0,3,4,5}, {0,5,9,15},{0,3,8,13},{0,13,14,15}

	};
	static int[][] map;
	static int N, M, result;

	static void dfs(int n, int m) {

		int x = n;
		int y = m;
		
		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			boolean chk = true;
			for (int j = 0; j < 4; j++) {
				int d = matrix[i][j];
				
				int mx = x + dx[d];
				int my = y + dy[d];
				if (mx < 1 || my < 1 || mx > N || my > M) {
					chk = false;
					break;
				}
				sum += map[mx][my];

			}

			if (chk) {

				result = Math.max(result, sum);

			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub\

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		result = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				dfs(i, j);
			}
		}

		bw.write(result + "");
		bw.close();
		br.close();

	}

}
