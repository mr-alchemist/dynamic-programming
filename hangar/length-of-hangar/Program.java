import java.util.Scanner;

public class Program{
    public static void main (String [] args){
        Program pr = new Program();
        pr.run();
    }
    int [][] map = null;
    int [][] answer = null;
    int N = 0;
    int M = 0;
    public void run(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                map[j][i] = 0;
        
        int P = scanner.nextInt();
        for(int i = 0; i < P; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x][y] = 1;
        }

        answer = new int[N][M];

        for(int y = 0; y < M; y++)
            for(int x = 0; x < N; x++){
                if(map[x][y] == 1){
                    answer[x][y] = 0;
                    continue;
                }
                if(y == 0){
                    answer[x][y] = 1;
                    continue;
                }
                answer[x][y] = answer[x][y - 1] + 1;
            }
        
        printAnswer();
    }
    
    private void printAnswer(){
        for(int y = 0; y < M; y++){
            for(int x = 0; x < N; x++){
                System.out.print(answer[x][y]);
                if(x != (N-1))
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
}
