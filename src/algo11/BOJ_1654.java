package algo11;

// 1654 랜선자르기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1654 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N];

		long left = 1;
		long right = 0;
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			right = Math.max(num[i], right);
		}
		long result = 0;
		while(left <= right) {
			int temp = 0;
			long mid = (left + right) / 2;
			
			for(int i = 0; i<N; i++) {
				temp += num[i]/mid;
			}
			
			if(temp >= K) {
				left = mid +1;
				result = Math.max(result, mid);
			}
			else {
				right = mid -1;
			}
			
		}
		
	
		bw.write(result + "");
		bw.close();
		br.close();
	}

}