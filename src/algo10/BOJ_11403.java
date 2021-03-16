package algo10;

// 11403 경로 찾기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int board[][] = new int[N+1][N+1];
		for(int i = 1; i<N+1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE / 2);
		}
		
		for(int i= 1; i<N+1; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<N+1; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp > 0) board[i][j] = temp;
			}
		}
		
		for(int k = 1; k<N+1; k++) {

			for(int i= 1; i<N+1; i++) {
				for(int j = 1; j<N+1; j++) {
					if(board[i][j] > (board[i][k] + board[k][j])) {
						board[i][j] = 1;
					}
					
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i= 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				if(board[i][j] == Integer.MAX_VALUE/2) board[i][j] = 0;
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}