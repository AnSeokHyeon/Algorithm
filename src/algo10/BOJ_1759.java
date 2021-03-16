package algo10;

// 1759 암호 만들기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L, C;
	static int idx[];	
	static char alphabet[];
	static boolean chk[] = new boolean[26];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		idx = new int[L];
		chk[0] = chk[4] = chk[8] = chk[14] = chk[20] = true;
		alphabet= new char[C]; 
		
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i<C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		
		password(0,0, 0, 0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void password(int n, int m, int a, int b) {
		if( n == L ) {
			if(a > 0 && b > 1) {

				for(int i = 0; i<n; i++) {
					sb.append((alphabet[idx[i]]));
				}
				sb.append("\n");
			}
			return;
			
		}
		for(int i = m; i<C; i++) {
			idx[n] = i;
			if(chk[alphabet[idx[n]] - 'a']) {
				password(n+1, i+1, a+1, b);
			}
			else {
				password(n+1, i+1, a, b+1);
			}
			
		}
		
	}

}