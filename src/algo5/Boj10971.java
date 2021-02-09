package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10971 {
	static int[][] board;
	static int N, result;
	static boolean chk[];

	static void trip(int st, int n, int m, int sum) {
		if (m == N) {
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (m < N-1 && i == st) continue; // 여행 출발지가 여행 마지막 전까지 뽑히면 안되므로 컨티뉴
			if (chk[i])
				continue;  // 왔던 여행지 또오면 안되므로 체크로 컨티뉴
			if (board[n][i] == 0) // 이 여행지로 가는 경로가 없으면 컨티뉴
				continue;
			
			chk[i] = true; // 가도 되는 여행지이므로 여행지 선택

			trip(st,i, m+ 1,  sum + board[n][i]); // 여행 출발지 고정, 현재 여행지, 몇번째인지, 비용 총합
  
			chk[i] = false; // 다시 빠꾸

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		chk = new boolean[N];
		board = new int[N][N];
		StringTokenizer st;
		// 여행 비용 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 987654312;
		for (int i = 0; i < N; i++) {
			trip(i, i,0, 0); // 여행  출발지 고정 , 현재 여행 중 도시, 몇번째 방문 도시인지, 그래서 비용얼마인지에 대한 변수 
		}

		bw.write(result + "");
		bw.close();
		br.close();

	}

}
