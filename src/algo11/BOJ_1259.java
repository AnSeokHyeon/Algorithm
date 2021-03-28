package algo11;
// 1259 팰린드롬수 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1259 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(Integer.parseInt(s) == 0) break;
			
			int left = 0;
			int right = s.length()-1;
			boolean chk = true;
			while(left < right) {
				if(s.charAt(left) != s.charAt(right)) {
					chk = false;
					break;
				}
				
				left++;
				right--;
				
			}
			
			if(chk) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}