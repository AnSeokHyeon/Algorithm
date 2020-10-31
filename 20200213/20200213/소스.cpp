#include <iostream>
#include <cstdio>

using namespace std;

struct number {
	int NO; //고객번호
	int AT; //도착시간
	int Nnum; //접수 창구 번호
	int Mnum; //정비 창구 번호
	bool Ntf; // 접수 완료 여부
	bool Mtf; // 정비 완료 여부
	int timer; // ㅅ요시간

	number() {
		this->NO = 0;
		this->AT = 0;
		this->Nnum = 0;
		this->Mnum = 0;
		this->Ntf = false;
		this->Mtf = false;
		this->timer = 0;
	}

};
number person[1001];
int N, M, K, A, B;
int a[10][10], b[10][10];
int t[1001];
int clientnum;

int main(void) {
	int T; // 테스트 케이스
	freopen("sample_input.txt", "r", stdin);
	cin >> T; // 테스트 케이스 갯수 입력
	while (T--) {
		clientnum = 0;
		cin >> N >> M >> K >> A >> B;
		// 접수 창구 N, 정비 창구 M, 고객수 K, 분실 접수 A ,분실 정비 B;

		for (int i = 1; i <= N; i++) {
			cin >> a[i][0];
			a[i][1] = false;
		}

		for (int i = 1; i <= M; i++) {
			cin >> b[i][0];
			b[i][1] = false;
		}

		for (int i = 1; i <= K; i++) {
			cin >> t[i];
			person[i].NO = i;
			person[i].AT = t[i]; 
			person[i].Nnum = 0;
			person[i].Mnum = 0;
			person[i].Ntf = false;
			person[i].Mtf = false;
			person[i].timer = 0;
		}

		for (int i = 0; i < 2000; i++) {
			for (int j = 1; j <= K; j++) {
				if(person[j].AT > i) continue; // 현재 시간보다 도착시간이 느린 경우 pass
				if (person[j].Ntf && person[j].Mtf) continue;

				if (!person[j].Ntf) {
					if (person[j].timer > 0) {
						person[j].timer--;
						if (person[j].timer == 0) {
							person[j].Ntf = true;
							a[person[j].Nnum][1] = false;
						}
					}

					for (int x = 1; x <= N; x++) {
						if (person[j].Nnum > 0) continue;
						if (a[x][1]) continue;
						person[j].Nnum = x;
						person[j].timer = a[x][0];
						a[x][1] = true;
					}
				}

				if(!person[j].Mtf && person[j].Ntf)  {
					if (person[j].timer > 0) {
						person[j].timer--;
						if (person[j].timer == 0) {
							person[j].Mtf = true;
							b[person[j].Mnum][1] = false;
							if (person[j].Nnum == A && person[j].Mnum == B)
								clientnum = clientnum + person[j].NO;
						}
					}

					for (int x = 1; x <= N; x++) {
						if (person[j].Mnum > 0) continue;
						if (b[x][1]) continue;
						person[j].Mnum = x;
						person[j].timer = b[x][0];
						b[x][1] = true;
					}
				}
			}
			/*cout << i << "일때"<<endl;
			for (int a = 1; a <= K; a++) {
				cout << person[a].NO << " ";
				cout << person[a].AT << " ";
				cout << person[a].Nnum << " ";
				cout << person[a].Mnum << " ";
				cout << person[a].Ntf << " ";
				cout << person[a].Mtf << " ";
				cout << person[a].timer << endl;
			}*/
		}
		if (clientnum == 0) cout << -1;
		cout << clientnum << endl;
	}
}