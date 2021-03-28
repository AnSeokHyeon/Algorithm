package algo11;

// 15829 Hashing
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BOJ_15829 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			map.put((char) ('a' + i), i + 1);
		}
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		long result = 0;
		long r = 1;
		for (int i = 0; i < N; i++) {
			result += map.get(S.charAt(i)) * r;
			r = (r*31)%1234567891;
			result %= 1234567891;
		}
		bw.write(result + "");
		bw.close();
		br.close();
	}

}