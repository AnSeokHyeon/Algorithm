package algo11;
// 2475 검증수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long result = 0;
		
		while(st.hasMoreTokens()) {
			
			int num = Integer.parseInt(st.nextToken());
			
			result += Math.pow(num, 2);
			
		}
		
		result %= 10;
		bw.write(result+"");
		bw.close();
		br.close();
	}

}