// 좌표 정렬하기
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import algo2.Boj11651.Location;

public class Boj11650 {
	static class Location {
		int x;
		int y;
	}

	static class MyComparator implements Comparator<Location> {
		@Override
		public int compare(Location l1, Location l2) {
			if (l1.x > l2.x) {
				return 1;
			} else if (l1.x == l2.x) {
				if (l1.y > l2.y) {
					return 1;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Location> l = new ArrayList<Location>();
		for (int i = 0; i < N; i++) {
			Location xy = new Location();
			String s = br.readLine();
			String[] sp = s.split(" ");
			xy.x = Integer.parseInt(sp[0]);
			xy.y = Integer.parseInt(sp[1]);
			l.add(xy);
		}
		MyComparator myComparator = new MyComparator();

		Collections.sort(l, myComparator);
		for (int i = 0; i < N; i++) {
			int x = l.get(i).x;
			int y = l.get(i).y;

			System.out.println(x + " " + y);
		}

	}
}
