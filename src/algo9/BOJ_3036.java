package algo9;
// 3036 링
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3036 {
	static int GCD(int a, int b) {
		if(a%b == 0) {
			return b;
		}
		
		return GCD(b, a%b);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i= 1; i<N; i++) {
			
			int gcd = GCD(num[0], num[i]);
			int A = num[0] / gcd;
			int B = num[i] / gcd;
			
			sb.append(A + "/"+B+"\n");
 			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}