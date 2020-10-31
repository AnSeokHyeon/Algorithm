#include <iostream>
#include <queue>
#include <cstdio>
#include <functional>

using namespace std;

struct pos {
	int idx;
	int x;
	int y;
	int d;
	int n;
	int t;
	pos(int idx, int x, int y, int d, int n, int t) {
		this->idx = idx;
		this->x = x;
		this->y = y;
		this->d = d;
		this->n = n;
		this->t = t;
	}
	pos() {
		this->idx = 0;
		this->x = 0;
		this->y = 0;
		this->d = 0;
		this->n = 0;
		this->t = 0;
	}
};
pos bug[1001];
int dx[] = { 0, -1,1,0,0 };
int dy[] = { 0, 0,0,-1,1 };

int map[101][101];
int sum[4];
int cnt = 0;
int N, M, K;

void find(int i, int j) {
	int temp = 0;
	int total = 0; 
	for (int a = 0; a < K; a++) {
		if (bug[a].x == i && bug[a].y == j) {
			int temp2 = bug[a].n;
			total += temp2;
			if (temp2 > temp) temp = temp2;
		}
	}
	int temp3 = 0;
	for (int a = 0; a < K; a++) {
		if (bug[a].x == i && bug[a].y == j) {
			if (temp == bug[a].n) temp3 = a;
			else bug[a].n = 0;
		}
	}
	bug[temp3].n = total;

}


int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N >> M >> K;
		//if (Tcnt == 9) cout << N << " " << M << " " << K << endl;
		for (int i = 0; i < K; i++) {
			int x, y, n, d;
			cin >> x >> y >> n >> d;
			//if (Tcnt == 9)cout << x << " " << y << " " << n << " " << d << " " << endl;
			bug[i].idx = i;
			bug[i].x = x;
			bug[i].y = y;
			bug[i].n = n;
			bug[i].d = d;
			//pq.push(pos(i, x, y, n, d, 0));
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				if (bug[j].n == 0) continue;

				int mx = bug[j].x + dx[bug[j].d];
				int my = bug[j].y + dy[bug[j].d];

				map[mx][my]++;

				if (mx == 0 || my == 0 || mx == N - 1 || my == N - 1) {
					if (bug[j].d % 2 == 0) bug[j].d--;
					else bug[j].d++;
					bug[j].n /= 2;
				}
				bug[j].x = mx;
				bug[j].y = my;
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					//cout << map[j][k] << " ";
					if (map[j][k] > 1) {
						cnt = 0;
						find(j, k);
					}
					map[j][k] = 0;
				}
				//cout << endl;
			}

			//for (int j = 0; j < K; j++) {
			//	cout << bug[j].idx << " 번째 :  ";
			//	cout << bug[j].x << " , ";
			//	cout << bug[j].y << " 크기 : ";
			//	cout << bug[j].n << " 방향 : ";
			//	cout << bug[j].d << endl;

			//}
		}


		int result = 0;
		for (int i = 0; i < K; i++) {
			if (bug[i].n == 0) continue;
			result += bug[i].n;
		}



		cout << "#" << Tcnt++ << " " << result << endl;
	}
}