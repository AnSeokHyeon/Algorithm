package algo14;

// 15961 회전초밥
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15961 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 음식 가지수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		int sushi[] = new int[N * 2];
		boolean chk[] = new boolean[d + 1];
		int sushinum[] = new int[d + 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			sushi[i + N] = sushi[i];
		}
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < N+k; i++) {
			if (i - k >= 0) {
				sushinum[sushi[i - k]]--;
				if (sushinum[sushi[i - k]] == 0) {
					cnt--;
					chk[sushi[i- k]] = false;
				}
			}
			
			if (!chk[sushi[i]]) {
				chk[sushi[i]] = true;
				cnt++;
			}
			sushinum[sushi[i]]++;
			
			result = chk[c] ? Math.max(result,cnt) : Math.max(result,cnt+1); 
		}
		bw.write(result + "");
		br.close();
		bw.close();
	}
}