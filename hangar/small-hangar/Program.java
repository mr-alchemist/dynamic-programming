import java.util.Scanner;

public class Program{
    public static void main (String [] args){
        Program pr = new Program();
        pr.run();
    }
    int [][] map = null;
    int N = 0;
    int M = 0;
    public void run(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                map[j][i] = scanner.nextInt();
        
        int res = 0;
        for(int y = 0; y < M; y++)
            for(int x = 0; x < N; x++){
                if(map[x][y] == 0){
                    int curArea = getLocalMaxArea(x, y);
                    if(curArea > res) res = curArea;
                }
            }

        System.out.println(res);
    }
    int getLocalMaxArea(int x, int y){
        int localMaxArea = 0;
        int wLimit = N;
        for(int yi = y, h = 1; yi < M; yi++, h++){
            int widthToRight = freeToRight(x, yi);
            if(widthToRight < wLimit) wLimit = widthToRight ;
            int area = h*wLimit;
            if(area > localMaxArea)localMaxArea = area;
        }
        return localMaxArea;
    }
    int freeToRight(int x, int y){
        int res = 0;
        for(int i = x; i < N; i++){
            if(map[i][y]==1)break;
            res++;
        }
        return res;
    }
}
