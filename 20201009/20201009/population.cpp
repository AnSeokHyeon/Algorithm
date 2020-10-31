#include <iostream>
#include <queue>
#include <math.h>
using namespace std;

struct pos {
	int x;
	int y;
	pos(int x, int y){
		this->x = x;
		this->y = y;
	}
};

int map[51][51];
int chk[51][51];
int open[3000];
int tot[3000];

int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };


int main(void) {
	int N, L, R;
	cin >> N >> L >> R;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
		}
	}
	int t = 0;
	while (1) {
		bool moving = false;

		queue<pos> q;
		int cnt = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (chk[i][j] > 0) continue;
				chk[i][j] = cnt;
				open[cnt]++;
				tot[cnt] += map[i][j];
				q.push(pos(i, j));

				while (!q.empty()) {
					pos f = q.front();
					q.pop();
					int x = f.x;
					int y = f.y;
					int p = map[x][y];
					for (int k = 0; k < 4; k++) {
						int mx = x + dx[k];
						int my = y + dy[k];
						if (mx < 1 || my < 1 || mx > N || my >N) continue;
						if (chk[mx][my] > 0) continue;
						int np = map[mx][my];
						int gap = abs(np - p);
						if (gap < L || gap > R) continue;
						chk[mx][my] = cnt;
						open[cnt]++;
						tot[cnt] += np;
						q.push(pos(mx, my));
					}
				}
				if (moving == false && open[cnt] > 1) moving = true;
				cnt++;
			}
		}
		//cout << "개방 결과" << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				//cout << chk[i][j] << " ";
				int sec = chk[i][j];
				map[i][j] = tot[sec] / open[sec];
				chk[i][j] = 0;
			}
			//cout << endl;
		}
		//cout << " 인구 이동 결과" << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		for (int i = 1; i <= cnt; i++) {
			tot[i] = 0;
			open[i] = 0;
		}


		if (moving == false) break;
		t++;

	}
	cout << t << endl;
}