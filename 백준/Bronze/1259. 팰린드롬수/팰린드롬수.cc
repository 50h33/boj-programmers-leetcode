#include <bits/stdc++.h>
using namespace std;
string s, a;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	while (true) {
        cin >> s;
        if (s == "0") break;
        a = s;
        reverse(s.begin(), s.end());
        if (s == a) cout << "yes\n";
        else cout << "no\n";
    }
}