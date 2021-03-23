package algo11;

// 2660 회장뽑기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		int board[][] = new int[N + 1][N + 1];
		int pt[] = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE / 2);
			board[i][i] = 0;
		}

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) break;
			board[a][b] = 1;
			board[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			int max = 0;
			for (int j = 1; j < N + 1; j++) {
				if(board[i][j] == Integer.MAX_VALUE/2) continue;
				max = Math.max(max, board[i][j]);
			}
			if(max ==0 )continue;
			pt[i] = max;
			
			min = Math.min(max, min);
			
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i<N+1; i++) {
			if(min != pt[i]) continue;
			arr.add(i);
		}
		
		int size = arr.size();
		sb.append(min + " " + size + "\n");
		
		for(int i = 0; i<size; i++) {
			sb.append(arr.get(i) + " ");
		}
	
		
		

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}