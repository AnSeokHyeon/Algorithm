package algo9;
// 11051 이항계수 1
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11050 {
	static int N;
	static long choose(int n, int r) {
		long memo[][] = new long[N+1][N+1];
		
		if(memo[n][r] > 0) {
			
			return memo[n][r];
		}
		
		if(r == 0 || n == r) {
			return memo[n][r] = 1;
		}
		
		return memo[n][r] = choose(n-1, r-1) + choose(n-1, r);		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		N = Math.max(a, b);
		
		long result = choose(a, b);
		bw.write(result + "");
		br.close();
		bw.close();
	}

}