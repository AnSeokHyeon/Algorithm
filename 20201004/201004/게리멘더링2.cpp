#include<iostream>

using namespace std;
int map[21][21];
int chk[21][21];
int N;
int result = 987654321;
void partition(int x, int y, int d1, int d2) {

	for (int i = 0; i <=  d1; i++) {
			chk[x+i][y-i] = 5;
			chk[x + d2 + i][y + d2 - i] = 5;
	}
	for (int i = 0; i <= d2; i++) {
			chk[x+i][y+i] = 5;
			chk[x + d1 + i][y - d1 + i] = 5;
	}
	for (int i = 1; i < x + d1; i++) {
		for (int j = 1; j <= y; j++) {
			if (chk[i][j] == 5) break;
			chk[i][j] = 1;
		}
	}

	for (int i = 1; i <= x + d2; i++) {
		for (int j = N; j > y; j--) {
			if (chk[i][j] == 5) break;
			chk[i][j] = 2;
		}
	}
	for (int i = x + d1; i <=N; i++) {
		for (int j = 1; j < y - d1 + d2; j++) {
			if (chk[i][j] == 5) break;
			chk[i][j] = 3;
		}
	}
	for (int i = x+d2+1; i <=N; i++) {
		for (int j = N; j >= y-d1+d2; j--) {
			if (chk[i][j] == 5) break;
			chk[i][j] = 4;
		}
	}

	for (int i = x; i <= x + d1 + d2; i++) {
		for (int j = y - d1; j <= y + d2; j++) {
			if (chk[i][j] == 0)
				chk[i][j] = 5;
		}
	}
	int a[6] = { 0 };
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int temp = chk[i][j];
			a[temp] += map[i][j];
			chk[i][j] = 0;
		}
	}
	int mintemp = 987654321;
	int maxtemp = 0;
	for (int i = 1; i < 6; i++) {
		if (a[i] > maxtemp) maxtemp = a[i];
		if (mintemp > a[i])mintemp = a[i];
	}
	int resulttemp = maxtemp - mintemp;
	if (result > resulttemp) result = resulttemp;
}

int main(void) {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			chk[i][j] = 0;
		}
	}

	for (int i = 1; i < N-1; i++) {
		for (int j = 2; j <N; j++) {
			for (int d1 = 1; d1 < j; d1++) {
				for (int d2 = 1; (d2 < N-j+1) && (d2 < N-i-d1+1) ; d2++) {
					partition(i, j, d1, d2);
 				}
			}
		}
	}
	cout << result;
}