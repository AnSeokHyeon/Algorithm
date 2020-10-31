#include <iostream>

using namespace std;

int N;
int temp;
int map[21][21];
int mv[21][21];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
void shake(int a[][21], int l) {
	if (l == 5) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << a[i][j] << "  ";
				if (a[i][j] > temp) temp = a[i][j];
			}
			cout << endl;
		}
		cout << endl;

		return; 
	}
	int chk[21][21];
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			chk[i][j] = a[i][j];
			mv[i][j] = 0;
		}
	}

	for (int i = 0; i < 4; i++) {
		if (i == 0) {
			for (int n = N - 1; n > 0; n--) {
				for (int m = 1; m <= N; m++) {
					if (chk[n][m] == 0) continue;
					int x = n;
					int y = m;
					while (1) {

						int mx = x + dx[i];
						int my = y + dy[i];
						if (mx > N || my > N || mx < 1 || my < 1) break;
						if (chk[mx][my] == chk[x][y] && mv[mx][my] == 0) {
							chk[mx][my] = chk[mx][my] * 2;
							chk[x][y] = 0;
							mv[mx][my] = 1;
							break;
						}
						else if (chk[mx][my] == 0) {
							chk[mx][my] = chk[x][y];
							chk[x][y] = 0;
							x = mx; y = my;
						}
						else break;
					}
				}
			}
		}
		else if (i == 1) {

			for (int n = 2; n <=N; n++) {
				for (int m = 1; m <= N; m++) {
					if (chk[n][m] == 0) continue;
					int x = n;
					int y = m;
					while (1) {

						int mx = x + dx[i];
						int my = y + dy[i];
						if (mx > N || my > N || mx < 1 || my < 1) break;
						if (chk[mx][my] == chk[x][y] && mv[n][m] == 0) {
							chk[mx][my] = chk[mx][my] * 2;
							chk[x][y] = 0;
							mv[mx][my] = 1;
							break;
						}
						else if (chk[mx][my] == 0) {
							chk[mx][my] = chk[x][y];
							chk[x][y] = 0;
							x = mx; y = my;
						}
						else break;
					}

				}
			}

		}
		else if (i == 2) {

			for (int m = N; m > 0; m--) {
				for (int n = 1; n <= N; n++) {
					if (chk[n][m] == 0) continue;
					int x = n;
					int y = m;
					while (1) {

						int mx = x + dx[i];
						int my = y + dy[i];
						if (mx > N || my > N || mx < 1 || my < 1) break;
						if (chk[mx][my] == chk[x][y] && mv[mx][my] == 0) {
							chk[mx][my] = chk[mx][my] * 2;
							chk[x][y] = 0;
							mv[mx][my] = 1;
							break;
						}
						else if (chk[mx][my] == 0) {
							chk[mx][my] = chk[x][y];
							chk[x][y] = 0;
							x = mx; y = my;
						}
						else break;
					}

				}
			}

		}
		else {

			for (int m = 2; m <= N; m++) {
				for (int n = 1; n <= N; n++) {
					if (chk[n][m] == 0) continue;
					int x = n;
					int y = m;
					while (1) {
						int mx = x + dx[i];
						int my = y + dy[i];
						if (mx > N || my > N || mx < 1 || my < 1) break;
						if (chk[mx][my] == chk[x][y] && mv[mx][my] == 0) {
							chk[mx][my] = chk[mx][my] * 2;
							chk[x][y] = 0;
							mv[mx][my] = 1;
							break;
						}
						else if (chk[mx][my] == 0) {
							chk[mx][my] = chk[x][y];
							chk[x][y] = 0;
							x = mx; y = my;
						}
						else break;
					}

				}
			}
		}
		shake(chk, l + 1);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk[i][j] = a[i][j];
				mv[i][j] = 0;
			}
		}
	}
}

int main(void) {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
		}
	}
	temp = 0;
	shake(map, 0);
	cout << temp ;
}