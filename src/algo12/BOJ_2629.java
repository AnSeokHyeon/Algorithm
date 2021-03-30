package algo12;
// 2629 양팔저울 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2629 { 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw 객체  생성
		
		StringBuilder sb = new StringBuilder(); // sb 객체 생성
		
		int N = Integer.parseInt(br.readLine()); // 추의 갯수입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w[] = new int[N+1]; //  추 배열 선언
		for(int i = 1; i<N+1; i++) {
			w[i] = Integer.parseInt(st.nextToken()); // 추 중량 입력
		}
		
		boolean dp[][] = new boolean[N+1][40001]; // dp 배열 선언
		
		for(int i = 1; i<N+1; i++) {
			dp[i][w[i]] = true; // i의 추 무게 체크
			if(i == 1) continue;
			for(int j = 1; j<40001; j++) {
				if(!dp[i-1][j]) continue; // i-1번째 추의 무게가 측정되지 않았으면  pass
				
				dp[i][j] = true; 
				dp[i][Math.abs(j-w[i])] = true; // j - w[i] 의 절대값 무게 체크
				dp[i][j+w[i]] = true; // j + w[i] 체크

			}
		}
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
		st = new StringTokenizer(br.readLine(), " ");
		while (T-- > 0) {
			int num = Integer.parseInt(st.nextToken()); // 숫자 입력 받기
			if(dp[N][num]) sb.append("Y "); // 체크가 true 이면 측정 가능한 숫자
			else sb.append("N "); // 체크가 false 이면 측정 불가 숫자
			
		}
		
		
		
		bw.write(sb.toString()); // sb 출력
		bw.close(); // BufferedWriter 종료
		br.close(); // BufferedReader 종료 
	}
}
