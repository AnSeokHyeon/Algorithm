#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	int time;
	
	pos() {
		this->x = 0;
		this->y = 0;
		this->time = 0;
	}
	pos(int x, int y, int time) {
		this->x = x;
		this->y = y;
		this->time = time;
	}
};

pos vPos[10];
pos onPos[10];
int map[51][51];
int ck[51][51];
int N, M, vN, wall, bfscnt=0;
int ckTime=10000;
int minTime[10000000];
queue<pos> q;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };

void bfs() {
	wall = 0;
	//ck 벽 -2을 세운다,, 바이러스 -1, 빈칸 0
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1) {
				ck[i][j] = -2;
				wall++;
			}
			else if (map[i][j] == 2) 	ck[i][j] = -1; 
			else ck[i][j] = 0;
		}
	}

	//활성 바이러스 ck 0으로 변경 및 큐에 푸시
	for (int i = 0; i < M; i++) {
		int x = onPos[i].x;
		int y = onPos[i].y;
		q.push(pos(x, y, 0));
		ck[x][y] = 0;
	}

	int temptime = 0;
	int size = (N * N) - vN -wall;
	//cout << size << "  " << vN << "  " << wall<< endl;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int time = f.time;
		if (temptime < time) temptime = time;
		if (map[x][y] == 0) {
			size--;
		}
		if (size == 0)break;
	
		//cout<< "size : " << size << " x : " << x << " y :  " << y << " time : " << time << endl;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mtime = time + 1;

			if (mx > N || my > N) continue;
			if (mx < 1 || my < 1) continue;
			if (ck[mx][my] > 0)	continue;
			if (ck[mx][my] == 0 && map[mx][my] == 0) {
				ck[mx][my] = mtime;
				q.push(pos(mx, my, mtime));
			}
			if (ck[mx][my] == -1) {
				ck[mx][my] = mtime;
				q.push(pos(mx, my, mtime));
			}
		}

	}


	minTime[bfscnt] = temptime;
	//if (bfscnt == 64) cout << "요기다~~~~~~~~~~~~~~~~~~~~~~~~";
	//cout << minTime[bfscnt] << endl;
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			/*if (ck[i][j] == -2) cout << '-';
			else if (ck[i][j] == -1) cout << '*';
			else if (ck[i][j] == 0 && map[i][j] == 2) cout << "v";
			else cout << ck[i][j];*/

			if (ck[i][j] == 0 && map[i][j] == 0) {
				minTime[bfscnt] = -1;
			}
		}
		//cout << endl;
	}
	bfscnt++;
	//cout << "############################" <<endl;
}

void virus(int x, int y) {

	if (y == M) {
		bfs();
		return;
	}

	for (int i = x; i < vN; i++) {
		onPos[y].x = vPos[i].x;
		onPos[y].y = vPos[i].y;
		virus(i + 1, y + 1);
	}
}

int main(void) {
	cin >> N >> M;
	vN = 0;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				vPos[vN].x = i;
				vPos[vN].y = j;
				vN++;
			}
		}
	}

	virus(0,0);

	for (int i = 0; i < bfscnt; i++) {
		//cout<< i << " 번째 : " << minTime[i]<<endl;
		if (minTime[i] < 0) continue;
		if (ckTime > minTime[i]) ckTime = minTime[i];
	}

	if (ckTime == 10000) cout << -1;
	else cout << ckTime;
	return 0;
}