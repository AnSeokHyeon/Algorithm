package algo15;

// 11401 이항계수 3
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11401 {
	static long NUM = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long fact[] = new long[N+1];
		long fact2[] = new long[N+1];
		fact[1] = 1;
		for(int i = 2; i <= N; i++) {
			fact[i] = (fact[i-1] * i) % NUM;
		}
		fact2[N] = pow(fact[N],  NUM-2);
		for(int i = N-1; i>0; i--) {
			fact2[i] = (fact2[i+1] * (i+1)) % NUM;
		}
		
		if(N == K || K == 0) System.out.println("1");
		else {
			
			long result = (fact[N] * fact2[N-K]) %NUM;
			result = (result * fact2[K]) %NUM;
			System.out.println(result);
		}
		
		br.close();
		bw.close();
	}
	private static long pow(long x, long y) {
		long result = 1;
		while( y > 0) {
			if(y %2 == 1) {
				result *= x;
				result %= NUM;
			}
			
			x *= x;
			x %= NUM;
			y /= 2;
		}
		return result;
	}
}