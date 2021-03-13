package algo9;

// 1037. 약수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1037 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int min = Integer.MAX_VALUE;
		int max = 0;
		while(N-- > 0) {
			num[idx++] = Integer.parseInt(st.nextToken());
			min = Math.min(min, num[idx-1]);
			max = Math.max(max, num[idx-1]);
		}
		
		bw.write((max*min) + "");
		br.close();
		bw.close();
	}

}