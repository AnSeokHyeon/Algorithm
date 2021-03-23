package algo11;

// 1507 궁금한 민호
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int board[][] = new int[N+1][N+1];
		int line[][] = new int[N+1][N+1];
		
		for(int i = 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<N+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				line[i][j] = board[i][j];
			}
		}
		
		boolean chk = true;
		for(int k = 1; k<N+1; k++) {
			for(int i = 1; i<N+1; i++) {
				for(int j = 1; j<N+1; j++) {
					if(i == k || k == j) continue;
					if(board[i][j] > board[i][k] + board[k][j]) {
						chk = false;
					}
					if(board[i][j] == board[i][k] + board[k][j]) {
						line[i][j] = Integer.MAX_VALUE / 2;
					}
					
				}
			}
		}
		int result = 0;
		for(int i = 1; i<N+1; i++) {
			for(int j = i; j<N+1; j++) {
				if(line[i][j] == Integer.MAX_VALUE/2) continue;
				result+=line[i][j];
			}
		}
		if(chk) bw.write(result + "");
		else bw.write("-1");
		br.close();
		bw.close();
	}

}