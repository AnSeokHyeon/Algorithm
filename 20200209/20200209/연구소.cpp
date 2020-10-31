#include <iostream>
#include <queue>
#include <vector>
// 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ��
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
}; //��ġ ����
int map[8][8]; //�� �ִ� 8/8 
int chk[8][8]; //�� üũ  8/8
pos virusPos[100]; //���̷��� ��ġ ���� ����
pos wall[3];
int virusN = 0; // ���̷��� ���� ���� ����
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int N, M, temp, safeMax = 0;
void bfs() {
	queue<pos> q; // ť ����
	for (int i = 0; i < virusN; i++) {
		int x = virusPos[i].x;
		int y = virusPos[i].y;
		q.push(pos(x, y));// ���̷��� ť �ױ� 
		chk[x][y] = 1; // ���̷��� üũ
	} 	

	for (int i = 0; i < 3; i++) {
		int x = wall[i].x;
		int y = wall[i].y;
		chk[x][y] = 1; // ���� ���� �� üũ (�ʿ� �����Ƿ�) 
	}
	
	while (!q.empty()) { // ť�� ��� ���� ������
		pos f = q.front(); // ť �Ǿ� ���̷��� ��ǥ ����
		q.pop(); // ť ����
		int x = f.x; // ���̷��� ��ǥ ����
		int y = f.y; // ���̷��� ��ǥ ����
		//cout <<"���̷��� ��ǥ  :  "<< x << "  " << y << endl;
		for (int i = 0; i < 4; i++) { // ���̷��� ���� �¿� �̵�
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx > N || my > M) continue; // �ʺ��� ũ�� ����
			if (mx < 1 || my < 1) continue; // �ʺ��� ������ ����
			if (chk[mx][my] == 1) continue; // ���� ���� ���̰ų� �̹� ���̷��� ���� �� üũ
			if (map[mx][my] == 0) {
				q.push(pos(mx, my)); //���̷��� ���� �Ǿ���
				chk[mx][my] = 1; //���̷��� ���� üũ
			}
		}
	}

	int n = 0; // �������� ã��

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (chk[i][j] == 0 && map[i][j]==0) {
				n++; //Ȯ������ �������̸鼭 �������� ���������� ���
			}
			chk[i][j] = 0; // ���� ������ ��� üũ ����Ʈ �ʱ�ȭ
		}
	}
	if (n > safeMax) safeMax = n;
}

int main(void) {
	cin >> N >> M;
	for(int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			int num;
			cin >> num;
			map[i][j] = num;
			if (num == 2) {
				virusPos[virusN].x = i;
				virusPos[virusN].y = j;
				virusN++;
				chk[i][j] = 2;
			}
		}
	}
	for (int x1 = 1; x1 <= N; x1++) {
		for (int y1 = 1; y1 <= M; y1++) {
			if (map[x1][y1] != 0) continue; // ���϶� ���� && ���̷��� ����
			wall[0].x = x1; //���� �ƴҶ� x1��ǥ ����
			wall[0].y = y1; //���� �ƴҶ� y1��ǥ ����
			for (int x2 = 1 ; x2 <= N; x2++) {
				for (int y2 = y1; y2 <= M; y2++) {
					if (map[x2][y2] != 0) continue; // ���϶� ���� && ���̷��� ����
					if ((y1 == y2) && (x2 <= x1)) continue; //
					wall[1].x = x2;//���� �ƴҶ� x2��ǥ ����
					wall[1].y = y2;//���� �ƴҶ� y2��ǥ ����
					for (int x3 = 1; x3 <= N; x3++) {
						for (int y3 = y2; y3 <= M; y3++) {
							if (map[x3][y3] != 0) continue; // ���϶� ���� && ���̷��� ����
							if ((y2 == y3) && (x3 <= x2)) continue;
							wall[2].x = x3;//���� �ƴҶ� x3��ǥ ����
							wall[2].y = y3;//���� �ƴҶ� y3��ǥ ����
							bfs();
							wall[2].x = 0;//�� �ʱ�ȭ
							wall[2].y = 0;//�� �ʱ�ȭ
						}
					}
					wall[1].x = 0;//�� �ʱ�ȭ
					wall[1].y = 0;//�� �ʱ�ȭ
				}
			}
			wall[0].x = 0; //�� �ʱ�ȭ
			wall[0].y = 0; //�� �ʱ�ȭ
		}
	}
	bfs();
	cout << safeMax;
	return 0;
}