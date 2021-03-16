package algo10;
// 2004 조합 0의 개수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2004 {
	
	static int five(int n) {
		int count = 0;
		for(long i = 5; i<=n; i*=5) {
			System.out.println("five : " + i);
			count += (n / i);
		}
		return count;
	}

	static int two(int n) {
		int count = 0;
		for(long i = 2; i<=n; i*=2) {
			System.out.println("two : " + i);
			count += (n / i);
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = a - b;
		int fiveCnt = five(a) - five(b) - five(c);
		int twoCnt = two(a) - two(b) - two(c);
		
		
		int result = Math.min(fiveCnt, twoCnt);
		bw.write(result+"");
		br.close();
		bw.close();
	}

}