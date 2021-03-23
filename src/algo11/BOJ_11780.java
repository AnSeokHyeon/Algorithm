package algo11;

// 11780 플로이드2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11780 {

	static int path[][];
	static ArrayList<Integer> step = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int board[][] = new int[N + 1][N + 1];
		path= new int[N+1][N+1];
		for(int  i = 1; i<N+1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE/2);
			board[i][i] = 0;
		}
		

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			board[a][b] = Math.min(board[a][b], w);
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if(board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] =  board[i][k] + board[k][j];
						path[i][j] = k;
					}
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (board[i][j] == 0) sb.append("0\n");
				else
				{
					step.add(i);
					pathfind(i, j);
					step.add(j);
					int size = step.size();
					sb.append(size + " ");
					for(int k = 0; k < size; k++) {
						sb.append(step.get(k) + " ");
					}
					sb.append("\n");
				}
				step.clear();
			}
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void pathfind(int start, int end) {
		// TODO Auto-generated method stub
		int stopover = path[start][end]; // 경유지
		if (stopover == 0) return;

		if(path[start][stopover] != 0) pathfind(start, stopover);
		step.add(stopover);
		if (path[stopover][end] != 0) pathfind(stopover, end);
	}

}