// 부등호
package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 부등호가 메인인거처럼 보이는
// 조합 
// 백트래킹


public class Boj2529 {
	static int N; //입력값
	static ArrayList<String> arr; // 결과 값 저장
	static int[] pick; // 숫자 위치
	static boolean[] chk; // 숫자 체크
	static char[] in; // 부등호

	static void dfs(int n) {
		if (n == N + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N + 1; i++) {
				sb.append(pick[i]);
			}
			arr.add(sb.toString());
			return;

		}

		for (int i = 0; i < 10; i++) {
			if (chk[i])
				continue;
			if(n >0 && in[n-1] == '<' && pick[n-1] > i) continue; 
			if(n >0 && in[n-1] == '>' && pick[n-1] < i) continue; 
			pick[n] = i;
			chk[i] = true;

			dfs(n + 1);

			chk[i] = false;

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		chk = new boolean[10];
		pick = new int[N + 1];
		in = new char[N];
		arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {

			in[i] = st.nextToken().charAt(0);
		}

		dfs(0);
		
		String max = arr.get(arr.size()-1);
		String min = arr.get(0) ;
		
		bw.write(max + "\n");
		bw.write(min);
		bw.close();
		br.close();

	}

}
