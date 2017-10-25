#include <iostream>

int main()
{
    int m[3][4] = {
        {-3, -2, -1, 1},
        {-2, 2, 3, 4},
        {4, 5, 7, 8}
    };
    int i, j;
    int c = 0;

    for (i=0; i<3; i++) 
    {
        for (j=0; j<4; j++)
        {
            if (m[i][j] < 0) c++;
        }
    }

    std::cout << "negative integers: " << c << std::endl; 
    return 0;
}
