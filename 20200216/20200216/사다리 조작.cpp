#include <iostream>

using namespace std;
int map[32][11];
int chk[32][11];
int N, M, H;
int tempLine, minLine;
int cntLine;
int dx[] = { 1,0,0 };
int dy[] = { 0,1,-1 };
bool arrival[12] = { false };
bool result = false;
int mx, my;
int addLineNum;
int Nj;
void ladder(int x, int y) {
	int nx = x;
	int ny = y;
	for (int i = 1; i <= H + 1; i++) {
		for (int j = 1; j <= N; j++) {
			chk[i][j] = 0;
		}
	}
	//	cout << "@@@�ʱ�ȭ ��  üũ  ����@@@" << endl; 
	//	for(int i = 0; i<=H+1;i++){
	//		int cnt = 0;
	//		for(int j = 1; j<=N; j++){
	//			cout<<chk[i][j];
	//		}
	//		cout<<endl;
	//	} 
	//	cout << "@@@�Է��� ����@@@" << endl; 
	//	for(int i = 0; i<=H+1;i++){
	//		int cnt = 0;
	//		for(int j = 1; j<=N; j++){
	//			if(i == x && j == y) cout << "*" ;  
	//			else cout<<map[i][j];
	//		}
	//		cout<<endl;
	//	} 
			//cout<< " ���� ��ǥ : " << nx << " " << ny <<" " << map[nx][my] << endl;
	for (int i = 0; i < 2 * (H + 1); i++) {
		mx = nx + dx[map[nx][ny]];
		my = ny + dy[map[nx][ny]];
		if (chk[mx][my] != 0) {
			mx = nx + dx[0];
			my = ny + dy[0];
		}
		//cout<< " �̵� ��ǥ : " << mx << " " << my << " " << map[mx][my] <<  endl;
		if (mx == H + 1 && my == y) {
			//	cout<< x << ", "<< y << " :  " << "����" << mx << "," <<my <<endl; 
			arrival[y] = true;
		}
		if (mx > H + 1) {
			break;
		}
		chk[mx][my] = i + 1;
		nx = mx;
		ny = my;
	}
	//	cout << "@@@�̵���  ����@@@" << endl; 
	//	for(int i = 0; i<=H+1;i++){
	//		int cnt = 0;
	//		for(int j = 1; j<=N; j++){
	//			if(i == x && j == y) cout << "*" ;  
	//			else cout<<chk[i][j];
	//		}
	//		cout<<endl;
	//	} 
	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		if (arrival[i] == true) {
			cnt++;
		}
	}
	if (cnt == N) {
		result = true;
		if (minLine > addLineNum) minLine = addLineNum;
	}
}

void control(int n, int m)
{
	cout << Nj << endl;
	if (n == 0) {
				cout << "@@@ ���@@@" << endl; 
				for(int i = 1; i<=H;i++){
					for(int j = 1; j<=N; j++){
						cout<<map[i][j];
					}		
					cout << endl;
				}
		for (int i = 1; i <= N; i++) {
			ladder(0, i);
		}

		for (int i = 1; i <= N; i++) {
			arrival[i] = false;
		}
		return;
	}
	for (int i = m; i <= H+1; i++) {
		if (i == H + 1) { 
			Nj++; 
			i = 1;
			continue;
		}
		if (map[i][Nj] == 0 && map[i][Nj + 1] == 0 && Nj < N) {
			map[i][Nj] = 1;
			map[i][Nj + 1] = 2;
			control(n - 1, i);
			map[i][Nj] = 0;
			map[i][Nj + 1] = 0;
		}
	}

}

int main(void) {
	cin >> N >> M >> H;
	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = 1;
		map[a][b + 1] = 2;
	}
	minLine = 100000;

	//	cout << "@@@�Է��� ����@@@" << endl; 
	//	for(int i = 1; i<=H;i++){
	//		int cnt = 0;
	//		for(int j = 1; j<=N; j++){
	//			cout<<map[i][j];
	//		}
	//		cout<<endl;
	//	}
	for (int i = 0; i <= 3; i++) {
		addLineNum = i;
		Nj = 1;
		control(i, 1);
	}
	if (!result) cout << -1;
	else if (minLine > 3) cout << -1;
	else cout << minLine;

}
