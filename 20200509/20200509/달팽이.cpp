#include <iostream>

using namespace std;

int map[11][11];
int chk[11][11];
int dx[] = {0,1,0,-1};
int dy[] = { 1,0,-1,0 };
int N;

void dfs(int x, int y, int n, int d) {
	map[x][y] = n;

	if (n == N * N) return;
	int mx = x + dx[d % 4];
	int my = y + dy[d % 4];

	if (mx < 1 || my < 1 || mx > N || my > N || map[mx][my] != 0) {
		d = d + 1;
	}
	dfs(x + dx[d % 4], y + dy[d % 4], n + 1, d);
	
}


int main(void) {
	int T, Tcnt = 0;
	cin >> T;
	while (T--) {
		Tcnt++;
		cin >> N;
		dfs(1, 1, 1, 0);
		cout << "#" << Tcnt << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << map[i][j] << " ";
				map[i][j] = 0;
			}
			cout << endl;
		}
	}
}