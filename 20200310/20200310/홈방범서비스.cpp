#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;
struct pos {
	int x;
	int y;
	int n;
	pos(int x, int y, int n) {
		this->x = x;
		this->y = y;
		this->n = n;
	}
};
int map[21][21];
int chk[21][21];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int N, M;
int money;
int housecnt;
void home(int n, int m, int l) {
	//cout << "진입함 : " << n << " , " << m << ", " << l << endl;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			chk[i][j] = 0;
		}
	}
	queue <pos> q;
	int cnt = 0;
	q.push(pos(n, m, 1));
	chk[n][m] = 1;
	if (map[n][m] == 1) cnt++;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int n = f.n;
		if (n == l) break;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mn = n + 1;
			if (mx > N || my > N || mx < 1 || my < 1) continue;
			if (chk[mx][my] != 0) continue;

			chk[mx][my] = mn;
			q.push(pos(mx, my, mn));
			if (map[mx][my] == 1) cnt++;
		}
	}

	money = cnt * M - (l * l + (l - 1) * (l - 1));
	//cout << " 주택 카운트 : "  << cnt<< " 손익 :  " << money << endl;
	if (money >= 0 && cnt > housecnt) housecnt = cnt;
	//if (cnt == 399) {
	//	cout << " 들어왔드앙 " << endl;
	//	for (int i = 1; i <= N; i++) {
	//		for (int j = 1; j <= N+1; j++) {
	//			if (i == n && j == m) cout << "*";
	//			else cout << chk[i][j];
	//		}
	//		cout << endl;
	//	}
	//}
}

int main(void) {
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		Tcnt++;
		cin >> N >> M;
		//cout << N << " " << M << endl;
		int max = 0;
		money = 0;
		housecnt = 0;
		int homecnt = 0;
		int maxtemp = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1) homecnt++;
			}
		}


		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				housecnt = 0;
				for (int k = N+1; k > 0; k--) {
					home(i, j, k);
					if (housecnt > maxtemp) maxtemp = housecnt;
					if (housecnt != 0)break;
				}
				if (housecnt == homecnt)break;
			}
			if (housecnt == homecnt)break;
		}
		cout << "#" << Tcnt << " " << maxtemp << endl;
	}
}