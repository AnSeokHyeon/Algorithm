#include <iostream>
#include <cstdio>

using namespace std;
int map[21][21];
int ck[101];
int N;
int dx[] = { 1,1,-1,-1 };
int dy[] = { 1,-1,-1,1 };
int cnt, dcnt;
int sum;
int maxD = 0;
int counting = 0;

int tempSum ;
void dessert(int n, int m) {
	int a = 0, b = 0;
	int x1 = n, x2 = n, y1 = m, y2 = m;
	ck[map[n][m]] = 1;
	sum = 0;
	int temp = 0;
	int temp2 = 0;
	tempSum = 0;
	for (int i = 0; i < N - m; i++) {
		int mx = n + dx[0] * (i + 1);
		int my = m + dy[0] * (i + 1);
		if (ck[map[mx][my]] == 1) break;
		if (mx > N || my > N || mx < 1 || my < 1) break;
		ck[map[mx][my]] = 1;
		a++;
	}

	for (int k = 0; k < 101; k++) {
		ck[k] = 0;
	}

	for (int i = 0; i < m; i++) {
		int mx = n + dx[1] * (i + 1);
		int my = m + dy[1] * (i + 1);
		if (ck[map[mx][my]] == 1) break;
		if (mx > N || my > N || mx < 1 || my < 1) break;
		ck[map[mx][my]] = 1;
		b++;
	}

	for (int i = a; i > 0; i--) {

		int mx = n + dx[0] * i;
		int my = m + dy[0] * i;
		// 브랜드 0으로 초기화
		for (int k = 0; k < 101; k++) {
			ck[k] = 0;
		}

		// 브랜드 1로 체크
		for (int j = 0; j <= i; j++) {
			int tempx = n + dx[0] * j;
			int tempy = m + dy[0] * j;
			ck[map[tempx][tempy]] = 1;

		}
		/*if (counting == 9 && a == 8 && b == 11 && i == 8) {
			for (int z = 1; z < 101; z++) {

				if (ck[z]) {
					cout << z << " ";
				}

			}
			cout << endl;
		}*/

		for (int j = 1; j <= b; j++) {

			int mx2 = mx + dx[1] * (j);
			int my2 = my + dy[1] * (j);
			if (ck[map[mx2][my2]] == 1) break;
			if (mx2 > N || my2 > N || mx2 < 1 || my2 < 1) break;

			ck[map[mx2][my2]] = 1;
			/*if (counting == 9 && a == 8 && b == 11 && i == 8) {
				cout << "2번째에서 체크 뽑아냄" << endl;
				for (int z = 1; z < 101; z++) {

					if (ck[z]) {
						cout << z << " ";
					}

				}
				cout << endl;
			}*/
			for (int k = 1; k <= i; k++) {
				int mx3 = mx2 + dx[2] * k;
				int my3 = my2 + dy[2] * k;
				//if (counting == 9 && a == 8 && b == 11 && i == 8 && j == 2) cout << "템프값 : " << temp << endl;
				if (ck[map[mx3][my3]] ==  1) break;
				if (mx3 > N || my3 > N || mx3 < 1 || my3 < 1) break;
				ck[map[mx3][my3]] = 1;
				temp++;
				//if (counting == 9 && a == 8 && b == 11 && i == 8) {
				//	cout << "3번째에서 체크 뽑아냄" << endl;
				//	for (int z = 1; z < 101; z++) {

				//		if (ck[z]) {
				//			cout << z << " ";
				//		}

				//	}
				//	cout << endl;
				//}
				if (k == i) {
					for (int l = 1; l <= j; l++) {
						int mx4 = mx3 + dx[3] * l;
						int my4 = my3 + dy[3] * l;
						if (mx4 == n && my4 == m) {
							sum = 2 * (i + j);
							if (tempSum < sum)tempSum = sum;
						}
						if (ck[map[mx4][my4]] == 1) break;
						if (mx4 > N || my4 > N || mx4 < 1 || my4 < 1) break;
						ck[map[mx4][my4]] = 1;
						temp2++;
					}
					if (temp2 != 0) {
						for (int l = 1; l <= temp2; l++) {
							int mx4 = mx3 + dx[3] * l;
							int my4 = my3 + dy[3] * l;
							ck[map[mx4][my4]] = 0;
						}

						temp2 = 0;
					}
				}
			}
			if (temp != 0) {
				for (int k = 1; k <= temp; k++) {
					int mx3 = mx2 + dx[2] * k;
					int my3 = my2 + dy[2] * k;
					ck[map[mx3][my3]] = 0;
				}
				temp = 0;
			}
		}
	}
}

int main(void) {
	int T;
	freopen("input.txt", "r", stdin);
	cin >> T;

	while (T--) {
		cin >> N;
		maxD = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			map[i][0] = i;
			map[0][i] = i;

		}
		//if (counting == 9) {
		//	for (int i = 0; i <= N; i++) {
		//		for (int j = 0; j <= N; j++) {
		//			printf("%3d ", map[i][j]);
		//		}
		//		cout << endl;
		//	}
		//}

		for (int i = 1; i <= N - 1; i++) {
			for (int j = 2; j <= N - 1; j++) {
				for (int k = 0; k < 101; k++) {
					ck[k] = 0;
				}
				dessert(i, j);
				if (tempSum > maxD) maxD = tempSum;
			}
		}
		counting++;


		if (maxD == 0) cout << "#" << counting << " " << -1 << endl;
		else cout << "#" << counting << " " << maxD << endl;
	}
}