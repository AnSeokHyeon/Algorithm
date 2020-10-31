#include <iostream>

using namespace std;

char map[31][31];
int chk[31][31];
int result;
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int N, M;


void find(int n, int m, int l, int d, int size) {
	if (size == 0) {
		if (result == -1) result = l - 1;
		else if (result > l - 1) result = l - 1;
		return;
	}
	if (result != -1 && l-1 > result) return;
	int x = n;
	int y = m;
	int t = l;

	for (int i = d; i < d + 4; i++) {
		int n = 0;
		int mx, my;
		
		while (1) {
			 mx = x + dx[i % 4] * (n+1);
			 my = y + dy[i % 4] * (n+1);

			if ((mx < 1 || my < 1 || mx > N || my > M) || chk[mx][my] != 0 || map[mx][my] != '.') {
				break;
			}
			chk[mx][my] = t;
			n++;
		}

		if (n == 0) continue;

		find(x + dx[i % 4] *n, y + dy[i % 4] * n , t + 1, d + 1, size - n);

		while (n>0) {
			mx = x + dx[i % 4] * (n );
			my = y + dy[i % 4] * (n );

			chk[mx][my] = 0;
			n--;
		}
	}
}
int main(void) {
	int Tcnt = 1;

	while (	cin >> N >> M) {

		result = -1;

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cin >> map[i][j];
				chk[i][j] = 0;
				if (map[i][j] == '*') {
					chk[i][j] = -1;
					cnt++;
				}
			}
		}

		int size = N * M - cnt-1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == '.') {
					chk[i][j] = 1;
					find(i, j, 1, 0, size);
					chk[i][j] = 0;
				}
			}
		}

		cout << "Case " << Tcnt++ << " : " << result << endl;
	}
}