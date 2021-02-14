

// 수들의 합 2
package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2003 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr  = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		int num = 0;
		while(st.hasMoreTokens()) {
			arr[num++] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while(true) {
			if(sum < M) {
				sum += arr[end++];
			}
			else if(sum == M) {
				System.out.println("같아");
				sum += arr[end++];
				cnt++;
			}
			else {
				sum -= arr[start++];
			}
			if(end > N) break;			
			System.out.println(sum + " : " + arr[start]+ " // " + arr[end]);

		}
		bw.write(cnt+"");

		br.close();
		bw.close();
	}


}