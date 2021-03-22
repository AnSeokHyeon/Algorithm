package algo11;

//1681
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로 {
	
	static int board[][];
	static int N;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		for(int i =1 ; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<N+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0,1, 0,0);
		bw.write(result + "");
		br.close();
		bw.close();
	}
	private static void find(int n,int start, int sum, int flag) {
		// TODO Auto-generated method stub
		
		
		if(n == N) {
			result = Math.min(result, sum);
			return;
		}
		
		if(sum >= result) {
			return;
		}
		
		for(int i = 1; i<N+1; i++) {
			if((flag & (1<<i)) != 0) continue;
			if(start == i) continue;
			if(n < N-1 && i == 1) continue;
			
			int weight = board[start][i];
			if(weight == 0) continue;
			find(n+1,i, sum + weight, flag| 1<<i);
			
		}
		
	}
	

}