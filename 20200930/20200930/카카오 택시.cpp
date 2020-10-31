#include <iostream>
#include <queue>
#include <vector>
#include <cstdio>
using namespace std;
struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};
pos des[500];
struct car {
	int x;
	int y;
	int l;
	car() {
		this->x = 0;
		this->y = 0;
		this->l = 0;
	}
	car(int x, int y, int l) {
		this->x = x;
		this->y = y;
		this->l = l;
	}
};
car taxi;
int dx[] = {-1,0,0,1};
int dy[] = {0,-1,1,0};
int map[21][21];
int chk[21][21];
int guest[21][21];
struct cmp {
	bool operator()(pos a, pos b) {
		if (a.x == b.x)
			return a.y > b.y;
		return a.x > b.x;
	}
};

int main(void) {

	queue<car> q;
	queue<car> q2;
	int N,M,L;
	cin >> N >> M >> L;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
		}
	}
	cin >> taxi.x >> taxi.y;
	taxi.l = L;
	for (int i = 1; i <= M; i++) {
		int x, y;
		cin >> x >> y;
		guest[x][y] = i;
		cin >> des[i].x >> des[i].y;
	}
	int T = M;
	while (T) {
		//cout << " 자 이제 운행 시작해볼까? " << endl;
		bool result = false;
		int limits = 987654321;
		q.push(car(taxi.x, taxi.y, taxi.l)); 
		priority_queue < pos, vector<pos>, cmp> pq;

		chk[taxi.x][taxi.y] = 1;
		while (!q.empty()) {
			//cout << " 자 손님 찾아 볼까? " << endl;
			car f = q.front();
			q.pop();
			int x = f.x;
			int y = f.y;
			int l = f.l;
			int d = taxi.l - l;
			//cout << x << " , " << y << " /" << l << endl;
			if (d > limits) break;
			if (guest[x][y] != 0) {
				//cout << " 찾았당 " << endl;
				if (limits == 987654321) limits = d;
				pq.push(pos(x, y));
			}
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				if (mx < 1 || my < 1 || mx > N || my > N)continue;
				if (map[mx][my] == 1) continue;
				if (chk[mx][my] == 1) continue;
				if (l == 0) continue;
				chk[mx][my] = 1;
				q.push(car(mx, my, l - 1));

			}
		}

		while (!pq.empty()) {
			pos f = pq.top();
			pq.pop();
			int x = f.x;
			int y = f.y;
			int n = guest[x][y];
			guest[x][y] = 0;
			map[des[n].x][des[n].y] = 9;
			taxi.l = taxi.l - limits;
			taxi.x = x;
			taxi.y = y;
			chk[taxi.x][taxi.y] = 2;
			q2.push(car(x, y, taxi.l));
			T--;
			break;
		}
		
		/*
		cout << " 현재 지도 " << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}
		cout << " 운행 지도 " << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << chk[i][j] << " ";
			}
			cout << endl;
		}
		cout<< " 현재 택시 상태 : "  << taxi.x << " , " << taxi.y << " / " << taxi.l << endl;
		*/

		while (!q2.empty()) {
			//cout << " 자 이제 데려다 줘 볼까?" << endl;
  			car f = q2.front();
			q2.pop();
			int x = f.x;
			int y = f.y;
			int l = f.l;
			//cout << x << " , " << y << " /" << l << endl;
			if (map[x][y] == 9) {
				//cout << " 도착했당 일했당 " << endl;
				result = true;
				taxi.l = taxi.l * 2 - l;
				taxi.x = x;
				taxi.y = y;
				map[x][y] = 0;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx < 1 || my < 1 || mx > N || my > N)continue;
				if (map[mx][my] == 1) continue;
				if (chk[mx][my] == 2) continue;
				if (l == 0) continue;
				chk[mx][my] = 2;

				//cout << mx << " , " << my << " /" << l << endl;
				q2.push(car(mx, my, l - 1));

			}
		}

		//cout << " 종료 지도 !@!@!@!@!@!@" << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << " 운행 지도 " << endl;

		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << chk[i][j] << " "; 
		//		chk[i][j] = 0;
		//	}
		//	cout << endl;
		//}


		//cout << " 운행 지도 " << endl;

		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << guest[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << " 현재 택시 상태 : " << taxi.x << " , " << taxi.y << " / " << taxi.l << endl;

		if (result == false) {
			taxi.l = -1;
			break;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk[i][j] = 0;
			}
		}
		while (!q.empty())q.pop();
		while (!q2.empty())q2.pop();
	}
	cout << taxi.l << endl;

}