package algo9;

// 5086 배수와 약수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A == 0 && B == 0) break;
			if(B%A == 0) {
				sb.append("factor\n");
			}
			else if (A%B == 0){

				sb.append("multiple\n");
				
			}
			else {
				sb.append("neither\n");

			}
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}