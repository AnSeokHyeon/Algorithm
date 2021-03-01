// 2605 줄세우기
package algo7;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			int idx = i - Integer.parseInt(st.nextToken());
			arr.add(idx, i+1);
		}
		
		for(int i = 0; i<arr.size(); i++) {
			System.out.print(arr.get(i)+ " ");
		}
		
		br.close();
		bw.close();

	}

}s