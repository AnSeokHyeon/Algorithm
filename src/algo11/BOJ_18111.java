package algo11;

// 18111 마인크래프트
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_18111 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int board[][] = new int[N + 1][M + 1];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
				min = Math.min(min, board[i][j]);
			}
		}
		
		int resultTime = Integer.MAX_VALUE;
		int result = 0;

		for (int h = min; h <= max; h++) {
			int time = 0;
			int item = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j] == h) continue;
					time += (board[i][j] > h)? 2 * (board[i][j] - h) :1 * (h - board[i][j]); 
					item += (board[i][j] > h)? 1 * (board[i][j] - h):-1* (h - board[i][j]);
					
				}
			}
			if(item + B < 0) continue;
			
			if(resultTime > time) {
				resultTime = time;
				result = h;
			}
			else if(resultTime == time) {
				result = Math.max(result, h);
						
			}
		}
		bw.write(resultTime + " " + result);
		bw.close();
		br.close();
	}

}