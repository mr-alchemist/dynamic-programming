using System;

class VideoSharp
{
    static void Main()
    {
        string line = Console.ReadLine();
        string[] ss = line.Split('+','/');
        int a = int.Parse(ss[0]);
        int b = int.Parse(ss[1]);
        int c = int.Parse(ss[2]);
        int d = int.Parse(ss[3]);
        //result: num/denom
        int denom = b*d;
        int num = a*d + c*b;
        int gcd = getGCD(num, denom);
        denom = denom/gcd;
        num = num/gcd;
        Console.WriteLine(num + "/" + denom);
    }
    static int getGCD(int x, int y){
        if(x == y)return x;
        
        if(x%2 == 0 && y%2 == 0)
            return 2*getGCD(x/2, y/2);
        
        if(x%2 == 0 && y%2 == 1)
            return getGCD(x/2, y);
        
        if(x%2 == 1 && y%2 == 0)
            return getGCD(x, y/2);
        
        if(x > y)return getGCD((x-y)/2, y);
        else return getGCD(x, (y-x)/2);
    }
}
