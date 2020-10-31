#include <iostream>
#include <queue>
#include <math.h>

using namespace std;

struct pos {
	int x;
	int y;
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

struct person {
	int n;
	int m;
	person() {
		this->n = 0;
		this->m = 0;
	}
};
person mv[2500];
bool result = false;
int N, L, R, cnt, n;
int A[50][50];
int chk[50][50];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
void bfs(int n, int m, int l) {
	//cout << "큐 진입 : " << n << " , " << m << " :: " << A[n][m] << endl;
	queue<pos> q;
	q.push(pos(n, m));
	chk[n][m] = l;
	int sum = A[n][m];
	cnt = 1;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		//cout << " 현황  : " << x << " , " << y << " 합 : " << sum << " 카운트 : " << cnt << endl;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int gap = abs(A[x][y] - A[mx][my]);
			//cout << " 현황  : " << mx << " , " << my << " 차이 : " << gap << endl;
			if (mx<0 || my<0 || mx>N-1 || my>N-1)continue;
			if (gap<L || gap>R) continue;
			if (chk[mx][my] !=0) continue;
			chk[mx][my] = l;
			q.push(pos(mx, my));
			//cout << "큐푸시" << endl;
			cnt++;
			sum += A[mx][my];
			result = true;
		}
	}
	mv[l].m = sum / cnt;
}
int main(void) {
	cin >> N >> L >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}
	int ans = 0;
	while (1) {
		result = false;
		n = 1;
		//cout << "들어옴 "<< endl;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (chk[i][j] !=0) continue;
				bfs(i, j, n);
				n++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (chk[i][j] != 0) {
					A[i][j] = mv[chk[i][j]].m;
				}
			}
		}
		for (int i = 0; i <=n; i++) {
			mv[i].m = 0;
		}
		if (result == false) break;
		ans++;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chk[i][j] = 0;
			}
		}
	}
	cout << ans;
}