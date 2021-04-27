package algo15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1019 {
	static long ans[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
			ans = new long[10];
			
			long start = 1;
			long end = Long.parseLong(br.readLine());
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
			
			for(int i = 0; i<10; i++) {
				System.out.print(ans[i] + " ");
				
			}
			
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