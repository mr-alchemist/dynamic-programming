import java.util.Scanner;

public class Program
{
    public static void main (String [] args)
    {
        Program pr = new Program();
        pr.run();
    }
    int[][] map  = null;
    int N = 0;
    void run(){
        inputData();
        int res = 0;
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(map[x][y] == 1){
                    res++;
                    destroyIsland(x, y);
                }
            }
        }
        
        System.out.println(res);
    }
    
    void destroyIsland(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return;
        if(map[x][y] == 0)
            return;
        map[x][y] = 0;
        destroyIsland(x, y - 1);
        destroyIsland(x, y + 1);
        destroyIsland(x - 1, y);
        destroyIsland(x + 1, y);        
    }
    
    void inputData(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        for(int y = 0; y < N; y++)
            for(int x = 0; x < N; x++)
                map[x][y] = scanner.nextInt();
    }
    
}
