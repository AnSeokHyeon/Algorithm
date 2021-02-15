package algo6;

// 부분합
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1806 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		int num = 0;
		while (st.hasMoreTokens()) {
			arr[num++] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int result = 978654321;
		int size = 0;
		while (true) {
			if (sum < M) {
				sum += arr[end++];
			}  else {
				
				size = end - start;
				result = Math.min(result, size);
				sum -= arr[start++];
			}
			if (end > N)
				
				break;

		}
		if(result == 978654321) result = 0;
		bw.write(result + "");

		br.close();
		bw.close();
	}

}