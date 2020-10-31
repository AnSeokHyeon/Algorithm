#include <string>
#include <vector>
#include <iostream>
#include <algorithm>


using namespace std;

struct pos {
	int st;
	int et;
	pos(int st, int et) {
		this->st = st;
		this->et = et;
	}

	pos() {
		this->st = 0;
		this->et = 0;
	}
};
int playing;
int adving;
int chk[370000] = {};
vector <pos> t;
bool comp(pos a, pos b) {
	if (a.st == b.st) {
		return a.et < b.et;
	}
	else
		return a.st < b.st;
}

int find(int n) {
	int total = 0;
	int st = n;
	int et = st + adving;
	for (int i = 0; i < t.size(); i++) {
		if (t[i].st > et) break;
		if (t[i].et < st) {
			continue;
		}
		int temp = 0;
		if (t[i].et > et && t[i].st < st) {
			temp = et - st;
			total += temp;
		}
		else if (t[i].et > et && t[i].st > st && t[i].st < et) {
			temp = et - t[i].st;
			total += temp;
		}
		else if (t[i].et < et && t[i].st < st && t[i].et > st) {
			temp = t[i].et - st;
			total += temp;
		}
		else if (t[i].et <= et && t[i].st >= st) {
			temp = t[i].et - t[i].st;
			total += temp;
		}

	}

	return total;


}

void transform(vector<string> logs) {
	for (int i = 0; i < logs.size(); i++) {
		//cout << lines[i] << endl;

		int H;
		H = (logs[i][0] - '0') * 10 + logs[i][1] - '0';

		int M;
		M = (logs[i][3] - '0') * 10 + logs[i][4] - '0';

		int S;
		S = (logs[i][6] - '0') * 10 + logs[i][7] - '0';

		int starting = H * 3600 + M * 60 + S;

		H = (logs[i][9] - '0') * 10 + logs[i][10] - '0';

		M = (logs[i][12] - '0') * 10 + logs[i][13] - '0';

		S = (logs[i][15] - '0') * 10 + logs[i][16] - '0';

		int ending = H * 3600 + M * 60 + S;

		for (int i = starting; i <= ending; i++) {
			chk[i]++;
		}
		t.push_back(pos(starting, ending));

	}


}
int transfrom2(string str) {

	int H;
	H = (str[0] - '0') * 10 + str[1] - '0';

	int M;
	M = (str[3] - '0') * 10 + str[4] - '0';

	int S;
	S = (str[6] - '0') * 10 + str[7] - '0';

	int timing = H * 3600 + M * 60 + S;

	return timing;
}

string solution(string play_time, string adv_time, vector<string> logs) {

	playing = transfrom2(play_time);
	adving = transfrom2(adv_time);
	transform(logs);
	sort(t.begin(), t.end(), comp);

	int result = 0;
	int ans = 0;
	int timing = 0;
	for (int i = 0; i < playing - adving; i++) {
		int total = 0;
		for (int j = i; j <= i + adving; j++) {
			total += chk[j];
		}
		if (total > result) {
			ans = i;
			result = total;
		}
	}

	//for (int i = 0; i < playing - adving; i++) {
	//	int temp = find(i);
	//	if (temp > result) {
	//		ans = i;
	//		result = temp;
	//	}
	//}
	
	int temp1 = (ans / 3600) / 10;
	int temp2 = (ans / 3600) % 10;
	ans = ans % 3600;
	string hour = to_string(temp1) + to_string(temp2) + ":";

	temp1 = (ans / 60) / 10;
	temp2 = (ans / 60) % 10;
	ans = ans % 60;

	string min = to_string(temp1) + to_string(temp2) + ":";

	temp1 = ans / 10;
	temp2 = ans % 10;

	string sec = to_string(temp1) + to_string(temp2);

	string answer = hour + min + sec;
	cout << answer << endl;
	return answer;
}

int main(void) {

	string play_time;
	cin >> play_time;
	string adv_time;
	cin >> adv_time;
	int n;
	cin >> n;
	vector<string> logs(n);
	for (int i = 0; i < n; i++) {
		cin >> logs[i];
	}


	solution(play_time, adv_time, logs);

}