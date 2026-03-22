#include <bits/stdc++.h>
using namespace std;
int n, a, ans;
int go(int num) {
    if (num == 1) return 0;
    if (num == 2) return 1;
    if (num == 3) return 1;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return 0;
    }
    return 1;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a;
        ans += go(a);
    }
    cout << ans << "\n";
}