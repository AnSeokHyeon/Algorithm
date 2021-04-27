package algo15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1081 {
	static long ans[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
			ans = new long[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long start = Long.parseLong(st.nextToken());
			if(start == 0) start = 1;
			long end = Long.parseLong(st.nextToken());
			long ten = 1;
			
			while(start <= end) {
				
				while(start % 10 != 0 && start <= end) {
					calc(start, ten);
					start++;
				}
				if(start > end) break;
				while(end % 10 != 9 && start <= end) {
					calc(end, ten);
					end--;
				}
				
				long cnt = (end / 10 - start / 10 + 1);
				
				for(int i = 0; i<10; i++) {
					ans[i] += cnt*ten;
					
				}
				start /= 10;
				end /= 10;
				ten *= 10;
			}
			
			long result = 0;
			for(int i = 0; i<10; i++) {
				result += (i * ans[i]);
			}
			System.out.println(result);
			
		
		br.close();
		bw.close();
	}


	private static void calc(long start, long ten) {
		while(start > 0) {
			ans[(int) (start%10)] += ten;
			start /= 10;
			
		}
	}

}