#include <iostream>
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
pos start;
int N, X;
int map[21][21];
int chk[21][21];
int cnt;
int mx, my, hgap;
double airx[21];
double airy[21];
int sum = 0;
int test;

void updown(double a[]) {

	//if (test == 5) {
	//	cout << endl;
	//	cout << " ���ö� ����" << endl;
	//	for (int i = 1; i <= N; i++) {
	//		cout << a[i] << " ";
	//	}
	//	cout << endl;
	//}
	
	cnt = 1;
	int hill =  1;
	for (int i = 1; i < N; i++) {
		double gap = a[i] - a[i + 1];
		if (gap >-1 && gap <-0.5) {
			cnt = 0;
			hill = 0;
			break;
		}

		if (gap < 1.34 && gap >= 1.19) gap = 1;

		if ((gap >=0.19 && gap<0.34) || gap == 0) continue;
		else if (gap == 1) {
			//cout << "���⼭ �������� ���� �������� : "<< i+1  << endl;
			int temp = a[i];
			for (int j = 1; j <= X; j++) {
				if (i + j > N) break;
				else if (i + j == N && j != X) {
					cnt = 0;
					hill = 0;
					break;
				}
				else if (a[i+j]+1 == temp) {
					a[i + j] = a[i + j] + (X + 1 - j) / (double)(X + 1);
					if (j == X) { i = i + X - 1; 
					}

				}
				else {
					cnt = 0; 
					hill = 0;
					break;
				}
			}
		}
		
		else if (gap == -1) {
			int temp = a[i+1];
			//cout << "������� �ö󰡴� ���� �������� : " << i << endl;
			for (int j = 1; j <= X; j++) {
				if (a[i+1 -j] < 1) break;
				else if (i +1- j == 1 && j != X) {
					cnt = 0;
					hill = 0;
					break;
				}
				else if (a[i +1- j]+1 == temp) {
					a[i + 1 - j] = a[i + 1 - j] + (X + 1 - j) / (double)(X + 1);
				}
				else {
					cnt = 0;
					hill = 0;
					break;
				}
			}
		}
	
		else {
			//cout << "���� ����� ��� break" << endl;
			cnt = 0;
			hill = 0;
			break;
		}
		if (hill == 0) break;
	}
	
	sum += cnt;

	//if (test == 5) {
	//	cout << " ���� ��ġ ���� : " << cnt << endl;
	//	cout << " ���� ��ġ ������ �� ���� " <<  sum << endl;
	//	cout << "���� ��ġ ��" << endl;
	//for(int i = 1; i <= N; i++) {
	//	printf("%.1f ", a[i]);
	//}
	//cout << endl;
	//}
}


int main(void) {

	int T;
	freopen("sample_input.txt", "r", stdin);
	cin >> T;
	test=0;
	while (T--) {
		cin >> N >> X;
		sum = 0;
		test++;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}
	//	if(test == 5){
	//		cout << N << X<< endl;
	//for (int i = 1; i <= N; i++) {
	//	for (int j = 1; j <= N; j++) {
	//		cout << map[i][j];
	//	}
	//	cout << endl;
	//}
	//	}
	

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				airx[j] = map[i][j];
				airy[j] = map[j][i];
			}
			updown(airx);
			updown(airy);
		}
		cout << "#"<<test << " " << sum << endl;
	}
}
