#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <cstdio>
#include <math.h>

using namespace std;

struct pos {
	int x;
	int y;
	int n;
	int d;
	int t;
	pos() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
		this->d = 0;
		this->t = 0;
	}
	pos(int x, int y, int n, int d, int t) {
		this->x = x;
		this->y = y;
		this->n = n;
		this->d = d;
		this->t = t;
	}
};

struct cmp {
	bool operator()(pos t, pos u) {
		if (t.x == u.x) {
			return t.y > u.y;
		}
		return t.x > u.x;
	}
};

pos fish[400];
pos shark;
int cnt = 0;
int map[21][21];
int chk[21][21];
int N;
int dx[] = {-1,0,0,1};
int dy[] = { 0,-1,1,0};
int ans = 0;
void baby() {
	queue<pos> q; 
	priority_queue< pos, vector<pos>, cmp > pq;
	chk[shark.x][shark.y] = 1;
	q.push(pos(shark.x, shark.y, shark.n,shark.d, shark.t));
	while (!q.empty()) {
		int fd=1000;
		pos f2;
		pos f = q.front();
		if (!pq.empty()) {
			f2 = pq.top();
			fd = f2.d;
			shark.x = f2.x;
			shark.y = f2.y;
		}
		q.pop();
		int x = f.x;
		int y = f.y;
		int n = f.n;
		int d = f.d;
		int t = f.t;
		if (d == fd) {
			map[shark.x][shark.y] = 0;
	/*		for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (shark.x == j && shark.y == k) cout << "@" << " ";
					else cout << map[j][k] << " ";
				}
				cout << endl;
			}*/
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					//printf("%2d ", chk[j][k]);
					chk[j][k] = 0;
				}
				//cout << endl;
			}
			while (!q.empty()) q.pop();
			while (!pq.empty()) pq.pop();
			x = f2.x;
			y = f2.y;
			d = f2.d;
			t = f2.t;
			n = f2.n;
		}
		//cout << "ÇöÀç »óÅÂ  : " << x << " , " << y << " ½ºÅÜ : " << d << " ¸ÔÀÌ Å©±â : " << n << endl;
		for (int i = 0; i < 4; i++) {
			int step = d + 1;
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx < 1 || my< 1 || mx > N || my > N) continue;
			if (map[mx][my] > n) continue;
			if (chk[mx][my] > 0) continue;
			if (map[mx][my] > 0 && map[mx][my] < n ) {
				chk[mx][my] = step;
				//cout << " ¸ÔÀÌ µé¾î¿È " << endl;
				shark.x = mx;
				shark.y = my;
				int dn = n;
				int dt = t - 1;
				if (dt == 0) {
					dn++;
					dt = dn;
				}
				shark.t = dt;
				shark.n = dn;
				ans = step;
				
				chk[mx][my] = step;
				pq.push(pos(mx, my, dn, step, dt));
			}
			chk[mx][my] = step;
			
			q.push(pos(mx, my, n, step,t));
		}	
	}
}
int main(void) {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] > 0 && map[i][j] < 9) {
				fish[cnt].x = i;
				fish[cnt].y = j;
				fish[cnt].n = map[i][j];
				cnt++;
			}
			else if (map[i][j] == 9) {
				shark.x = i;
				shark.y = j;
				shark.n = 2;
				shark.t = 2;
				map[i][j] = 0;
			}
		}
	}
	if (cnt == 0) cout << cnt << endl;
	else {
		baby();
		cout << ans << endl;
	}		 
}