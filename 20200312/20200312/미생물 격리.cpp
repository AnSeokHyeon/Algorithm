#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <cstdio>

using namespace std;

struct pos {
	int num;
	int x;
	int y;
	int n;
	int d;
	int t;
	pos() {
		this->num = 0;
		this->x = 0;
		this->y = 0;
		this->n = 0;
		this->d = 0;
		this->t = 0;
	}
	pos(int num, int x, int y, int n, int d, int t) {
		this->num = num;
		this->x = x;
		this->y = y;
		this->n = n;
		this->d = d;
		this->t = t;
	}
};
pos flu[1001];
struct cmp {
	bool operator()(pos t, pos u) {
		if (t.t == u.t) {
			return t.n < u.n;
		}
		else
			return t.t > u.t;
	}
};
int map[100][100];
priority_queue<pos, vector<pos>, cmp > pq;


int dx[] = { 0, -1,1,0,0 };
int dy[] = { 0, 0,0,-1,1 };

int main(void) {
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		Tcnt++;
		int N, M, K;
		cin >> N >> M >> K;
		//cout << N << " " << M << " " << K << endl;
		for (int i = 1; i < K + 1; i++) {
			cin >> flu[i].x >> flu[i].y >> flu[i].n >> flu[i].d;
			//cout << flu[i].x << " " << flu[i].y << " " << flu[i].n << " " << flu[i].d << endl;
			flu[i].num = i;
			map[flu[i].x][flu[i].y] = flu[i].num;
			pq.push(pos(flu[i].num, flu[i].x, flu[i].y, flu[i].n, flu[i].d, flu[i].t));
		}

		//for (int i = 0; i <= K; i++) {
		//	cout<< flu[i].num << " "<< flu[i].x << " " << flu[i].y << " " << flu[i].n << " " << flu[i].d << " " << flu[i].t << endl;
		//}

		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < N; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
		int fluTime = 0;
		while (1) {
			for (int i = 0; i <= K; i++) {
				cout << flu[i].num << " " << flu[i].x << " " << flu[i].y << " " << flu[i].n << " " << flu[i].d << " " << flu[i].t << endl;
			}
			while (!pq.empty()) {

				pos f = pq.top();
				int num = f.num;
				int x = f.x;
				int y = f.y;
				int t = f.t;
				int n = f.n;
				int d = f.d;
				//cout << x << " " << y << " " << n << " " << d << endl;
				if (t > fluTime) break;
				//cout << fluTime << b  " : " << n << endl;
				pq.pop();
				int mx = x + dx[d];
				int my = y + dy[d];
				int mt = t + 1;
				int nmap = map[mx][my];

				if (mx < 1 || my < 1 || mx > N - 2 || my > N - 2) {
					cout << " 반감기 들어옴 " << endl;
					if (n == 1) {
						map[x][y] = 0;
						flu[num].num = 0;	flu[num].x = 0;	flu[num].y = 0;	flu[num].n = 0;	flu[num].d = 0;
						flu[num].t = 0;
						continue;
					}
					flu[num].n = n / 2;
					n = n / 2;
					if (d == 1) {
						flu[num].d = 2;
						d = 2;
					}
					else if (d == 2) {
						flu[num].d = 1;
						d = 1;
					}
					if (d == 3) {
						flu[num].d = 4;
						d = 4;
					}
					else if (d == 4) {
						flu[num].d = 3;
						d = 3;
					}
				}

				if (nmap > 0 && (flu[num].t == mt)) {
					flu[nmap].n = flu[nmap].n + flu[num].n;
					map[x][y] = 0;
					flu[num].num = 0;
					flu[num].x = 0;
					flu[num].y = 0;
					flu[num].n = 0;
					flu[num].d = 0;
					flu[num].t = 0;
					continue;
				}

				map[mx][my] = num;
				map[x][y] = 0;
				flu[num].x = mx;
				flu[num].y = my;
				flu[num].t = mt;
				pq.push(pos(flu[num].num, flu[num].x, flu[num].y, flu[num].n, flu[num].d, flu[num].t));

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cout << map[i][j] << " ";
				}
				cout << endl;
			}

			for (int i = 0; i <= K; i++) {
				cout << flu[i].num << " " << flu[i].x << " " << flu[i].y << " " << flu[i].n << " " << flu[i].d << " " << flu[i].t << endl;
			}

			fluTime++;
			if (fluTime == M)break;
			//cout << endl;
			//for (int i = 1; i < K + 1; i++) {
			//	if (flu[i].n == 0) continue;
			//	cout << flu[i].n << endl;
			//}
			//cout << endl;
		}
		int sum = 0;
		for (int i = 1; i < K + 1; i++) {
			if (flu[i].n == 0) continue;
			sum += flu[i].n;
		}
		cout << "#" << Tcnt << " " << sum << endl;
	}

}