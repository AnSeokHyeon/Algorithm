package algo12;

//9465 스티커
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(T-- > 0) {
			
			int N = Integer.parseInt(br.readLine());
			int A[]= new int[N+1];
			int B[] =new int[N+1];
			int C[] = new int[N+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i= 1; i<N+1; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i= 1; i<N+1; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			C[1] = Math.max(A[1],B[1]);
			for(int i = 2; i<N+1; i++) {
				int max = C[i-2];
				A[i] += Math.max(B[i-1],max);
				B[i] += Math.max(A[i-1],max);
				C[i] = Math.max(A[i], B[i]);
			}
			
			sb.append(C[N]+"\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}