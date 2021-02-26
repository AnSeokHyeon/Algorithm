package algo7;

// 2669 직사각형 네개의 합집합의 면적 구하기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean board[][] = new boolean[101][101];
		int result = 0;
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			
			for(int j = x; j<dx; j++) {
				for(int k = y; k<dy; k++) {
					if(board[j][k]) continue;
					board[j][k] = true;
					result++;
				}
			}
		}
		bw.write(result+"");
		br.close();
		bw.close();

	}

}