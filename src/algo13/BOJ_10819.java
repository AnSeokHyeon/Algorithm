package algo13;

//10819 차이를 최대로
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10819 {
	static int N;
	static int num[];
	static int pick[];
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		pick = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int  i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
	private static void dfs(int n, int flag) {
		if(n == N) {
			int sum = 0;
			for(int i = 0; i<N-1; i++) {
				sum += Math.abs(pick[i] - pick[i+1]);
			}
			result = Math.max(result, sum);
			
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if((flag & 1 << i) > 0) continue;
			pick[n] = num[i];
			dfs( n+1, flag|1<<i);
		}
		
	}
	


}