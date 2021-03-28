package algo11;

// 1520 내리막 길
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
	
	static int N, M;
	static int board[][];
	static int dp[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		
		
		for(int i  = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], -1);
			for(int j =1; j<M+1; j++) {
				board[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(1, 1));
		
		br.close();
		bw.close();

	}

	private static int dfs(int x, int y) {
		// TODO Auto-generated method stub
		if(x== N && y == M) {
			return 1;
		}
		
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			for(int k = 0; k<4; k++) {
				int mx = x + dx[k];
				int my = y + dy[k];
				
				if(mx < 1 || my < 1 || mx > N || my> M) continue;
				if(board[mx][my] >= board[x][y]) continue;
				
				dp[x][y] += dfs(mx, my);
				
			}
		}
		
		
		
		
		return dp[x][y];
	}
	
	

}
