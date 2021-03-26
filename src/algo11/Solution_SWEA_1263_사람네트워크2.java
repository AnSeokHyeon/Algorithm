package algo11;

//1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int board[][] = new int[N+1][N+1];
			for(int i = 1; i<N+1; i++) {
				Arrays.fill(board[i], Integer.MAX_VALUE/2);
				board[i][i] = 0;
 				for(int j = 1; j<N+1; j++) {
					int num = Integer.parseInt(st.nextToken());
					if( num == 1) board[i][j] =  num;
				}
			}
			
			for(int k = 1; k<N+1; k++) {
				for(int i = 1;i<N+1; i++) {
					for(int j =1;j<N+1; j++) {
						if(board[i][j] > board[i][k] + board[k][j]){
							board[i][j]= board[i][k] + board[k][j];
						}
					}
				}
			}
			
			int result = Integer.MAX_VALUE;
			for(int i = 1;i<N+1; i++) {
				int sum = 0;
				for(int j =1;j<N+1; j++) {
					if(i == j) continue;
					
					if(board[i][j] == Integer.MAX_VALUE/2) continue;
						sum += board[i][j];
				}
				result = Math.min(sum, result);
			}
			
			sb.append("#" + (Tcnt++) + " " + result+ "\n");
		}
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}