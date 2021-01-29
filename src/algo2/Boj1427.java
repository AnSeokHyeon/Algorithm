// 소트인사이드
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Boj1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		ArrayList<Integer> n = new ArrayList<Integer>();
		
		for(int i = 0; i<s.length(); i ++) {
			Integer num = (Integer.parseInt(s)/(int)Math.pow(10, s.length()-1-i))%10;
			n.add(num);
		}
		Collections.sort(n, Collections.reverseOrder());
		
		for(int i = 0; i<s.length(); i ++) {
			System.out.print(n.get(i));
		}

	}

}
