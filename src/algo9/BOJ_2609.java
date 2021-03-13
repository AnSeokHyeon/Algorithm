package algo9;
// 2609 최대 공약수 최소 공배수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int idx = 2;
		int limit = Math.min(A, B);
		int max = 1;
		
		while(idx <= limit) {
			if(A%idx == 0 && B%idx == 0) {
				max *= idx;
				A /= idx;
				B /= idx;
				limit = Math.min(A, B);
			}
			else {
				idx++;
			}
		}
		int min = max * A * B;
		bw.write(max+"\n");
		bw.write(min+"");
		br.close();
		bw.close();
	}

}