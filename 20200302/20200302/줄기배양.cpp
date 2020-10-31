#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <cstdio>

using namespace std;
struct cell {
	int x;
	int y;
	int time;
	int newTime;
	int lifeTime;
	int deadTime;

	cell() {
		this->x = 0;
		this->y = 0;
		this->time = 0;
		this->newTime = 0;
		this->lifeTime = 0;
		this->deadTime = 0;
	}

	cell(int x, int y, int time, int newTime, int lifeTime, int deadTime) {
		this->x = x;
		this->y = y;
		this->time = time;
		this->newTime = newTime;
		this->lifeTime = lifeTime;
		this->deadTime = deadTime;
	}
};
cell pos[100000];

struct cmp {
	bool operator()(cell t, cell u) {
		if (t.newTime == u.newTime)
			return t.time < u.time;
		return t.newTime > u.newTime;
	}
};
struct cmp2 {
	bool operator()(cell t, cell u) {
		if (t.lifeTime == u.lifeTime)
			return t.time < u.time;
		return t.lifeTime > u.lifeTime;
	}
};
struct cmp3 {
	bool operator()(cell t, cell u) {
		return t.deadTime > u.deadTime;
	}
};

int map[401][401];

int chk[401][401];
int N, M, K;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
queue <cell> q;
priority_queue< cell, vector<cell>, cmp > pq;
priority_queue< cell, vector<cell>, cmp2 > pq2;
priority_queue< cell, vector<cell>, cmp3 > pq3;
int cnt;

void bfs() {
	//cout << " µé¾î¿È " << endl;
	for (int i = 0; i < cnt; i++) {
		pq.push(cell(pos[i].x, pos[i].y, pos[i].time, 0, pos[i].time, pos[i].time * 2));
	}
	for (int t = 0; t <= K; t++) {
	//	cout << "½Ã°£ :  " << t << endl;
		while (!pq.empty()) {
			//cout << " pq µé¾î¿È " << endl;
			cell f = pq.top();
			int newTime = f.newTime;
			if (newTime > t) break;
			if (map[f.x][f.y] != 0 && t != 0) {
				pq.pop();
				continue;
			}
			map[f.x][f.y] = f.time;
			pq2.push(cell(f.x, f.y, f.time, f.newTime, f.lifeTime, f.deadTime));
			
			//cout << "pq2 Çª½¬ÇÔ : " << f.x << ", " << f.y << ", : " << map[f.x][f.y] << endl;
		//	cout << " »ý¼º ½Ã°£ : " << f.newTime << " È°¼º ½Ã°£ :  " << f.lifeTime << " ºñÈ°¼º ½Ã°£ : " << f.deadTime << endl;
			pq.pop();
		}
	//	cout << "@@@@@@@@@@" << endl;
		while (!pq2.empty())
		{

			//cout << " pq2 µé¾î¿È " << endl;
			cell f2 = pq2.top();

			int lifeTime = f2.lifeTime;
			if (lifeTime > t) break;
			int x = f2.x;
			int y = f2.y;
			int tempTime = f2.time;
			//cout << x << " , " << y << " , " << f2.time<< " , "<< f2.newTime << " , " << lifeTime << " , " << f2.deadTime<< endl;
			
			pq3.push(cell(f2.x, f2.y, f2.time, f2.newTime, f2.lifeTime, f2.deadTime));

			//cout << "pq3 Çª½¬ÇÔ : " << f2.x << ", " << f2.y << ", : " << map[f2.x][f2.y] << endl;
			pq2.pop();

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (map[mx][my] != 0) continue;
				if (chk[mx][my] != 0) continue;
				pq.push(cell(mx, my, tempTime, t + 1, t + 1 + tempTime, t + 1 + tempTime * 2));
				chk[mx][my] = 1;
				//cout << "pq Çª½¬ÇÔ : " << mx << ", " << my << ", : " << tempTime << endl;
			}

		}
		//cout << "pq3 ÀÔÀå" << endl;

		//cout << "@@@@@@@@@@" << endl;
		while (!pq3.empty())
		{
			cell f3 = pq3.top();
			int deadTime = f3.deadTime;
			if (deadTime > t) break;
			map[f3.x][f3.y] = -1;
			pq3.pop();

		}
		//for (int i = 1; i < 15; i++) {
		//	for (int j = 1; j <15; j++) {
		//		if (map[i][j] < 0) cout << "*";
		//		else 
		//		cout << map[i][j];
		//	}
		//	cout << endl;
		//}
	}

	while (!pq.empty()) pq.pop();
	while (!pq2.empty()) pq2.pop();
	while (!pq3.empty()) pq3.pop();

}
int main(void) {

	int T;
	cin >> T;
	while (T--) {
		cin >> N >> M >> K;
		cnt = 0;
		for (int i = 0; i <= 400; i++) {
			for (int j = 0; j <= 400; j++) {
				map[i][j] = 0;
			}
		}
		for (int i = 0; i <= 400; i++) {
			for (int j = 0; j <= 400; j++) {
				chk[i][j] = 0;
			}
		}
		//for (int i = 0; i < 100000; i++) {
		//	pos[i].x = 0;
		//	pos[i].y = 0;
		//	pos[i].time = 0;
		//	pos[i].newTime = 0;
		//	pos[i].lifeTime = 0;
		//	pos[i].deadTime = 0;
		//	
		//}
		int anw = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cin >> map[175 + i][175 + j];
				if (map[175 + i][175 + j] != 0) {
					pos[cnt].x = 175 + i;
					pos[cnt].y = 175 + j;
					pos[cnt].time = map[175 + i][175 + j];
					cnt++;

					chk[175+i][175+j] = 1;
				}
			}
		}

		bfs();
		for (int i = 1; i <= 400; i++) {
			for (int j = 1; j <= 400; j++) {
				//if (map[i][j] < 0) cout << "*";
				//else cout << map[i][j];
				if (map[i][j] > 0) anw++;
			}
		}
		cout<< "ÃÑ °¹¼ö : " << anw << endl;
	}
}