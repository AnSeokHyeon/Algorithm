package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1748 {
	static int N, M, x, y;
	static long size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
	    for (int i = 1; i <= N; i *= 10) {

			cnt += N - i + 1;
	    	
	    }
	    bw.write(cnt+"");
		br.close();
		bw.close();
	}
}