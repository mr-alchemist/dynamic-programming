#include <iostream>
#include <string>
using namespace std;

int main()
{
    int N = 0;
    cin >> N;
    int64_t x5 = 1, x8 = 1, x55 = 0, x88 = 0;
    int64_t bufx5, bufx8, bufx55, bufx88;
    for(int i = 2; i <= N; i++){
        bufx5 = x8 + x88;
        bufx8 = x5 + x55;
        bufx55 = x5;
        bufx88 = x8;
        //
        x5 = bufx5;
        x8 = bufx8;
        x55 = bufx55;
        x88 = bufx88;
    }
    int64_t res = x5 + x8 + x55 + x88;
    cout << res;
    return 0;
}
