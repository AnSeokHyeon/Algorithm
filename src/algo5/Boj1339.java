
// 단어 수학
package algo5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boj1339 {
	static String[] S;
	static int alpha[];
	static ArrayList<Point> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		S = new String[N];
		alpha = new int[26];
		arr = new ArrayList<Point>();
		int T = 0; 
		while(T <N) {
			S[T++] = br.readLine();
			for(int i= 0,len = S[T-1].length() ; i < len; i++) {
				int num = S[T-1].charAt(i) - 'A';
				alpha[num] += Math.pow(10, len-1-i);
			}
		}
		for(int i = 0; i<26; i++) {
			if(alpha[i] == 0) continue;
			arr.add(new Point(alpha[i], i));
		}
		Collections.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return (o1.x - o2.x)*-1;
			}
		});
		int sum = 0;
		int pt = 9;
		for(int i = 0; i < arr.size(); i++) {
			sum += arr.get(i).x * (pt--);
		}
		bw.write(sum+ "");
		br.close();
		bw.close();
	}

}