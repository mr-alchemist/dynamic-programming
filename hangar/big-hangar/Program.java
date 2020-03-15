import java.util.*;

public class Program{
    public static void main (String [] args){
        Program pr = new Program();
        pr.run();
    }
    int [][] map = null;
    int [][] heights = null;
    int N = 0;
    int M = 0;
    public void run(){
        readInput();
        calcHeights();
        int res = getMaxSquare();
        System.out.println(res);
    }

    void readInput(){
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
    }    

    void calcHeights(){
        heights = new int[N][M];

        for(int y = 0; y < M; y++)
            for(int x = 0; x < N; x++){
                if(map[x][y] == 1){
                    heights[x][y] = 0;
                    continue;
                }
                if(y == 0){
                    heights[x][y] = 1;
                    continue;
                }
                heights[x][y] = heights[x][y - 1] + 1;
            }
        
    }
    
    int getMaxSquare(){
        int res = 0;
        for(int r = 0; r < M; r++){
            int[] L = getL(r);
            int[] R = getR(r);
            for(int x = 0; x < N; x++){
                int curS = heights[x][r]*(R[x] -  L[x] + 1);
                if(curS > res) res = curS;
            }
        }
        return res;
    }
    
    int[] getL(int row){
        int[] L = new int[N];
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int prev = heights[N-1][row];
        for(int i = N - 1; i >= 0; i--) {
        	if(heights[i][row] >= prev)
                stack.push(i);
        	else {
        		int border = i + 1;
        		while(stack.peekFirst() != null && heights[stack.peekFirst()][row] > heights[i][row])
                    L[stack.pop()] = border;
        		
        		stack.push(i);
        	}
        	prev = heights[i][row];
        }
        while(stack.peekFirst() != null)
            L[stack.pop()] = 0;

        return L;
    }
    
    int[] getR(int row){
        int[] R = new int[N];
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int prev = heights[0][row];
        for(int i = 0; i < N; i++){
            if(heights[i][row] >= prev)
                stack.push(i);
            else{
                int border = i - 1;                
                while(stack.peekFirst() != null && heights[stack.peekFirst()][row] > heights[i][row])
                    R[stack.pop()] = border;
                
                stack.push(i);
            }
            prev = heights[i][row];
        }
        while(stack.peekFirst() != null)
            R[stack.pop()] = N - 1;
        
        return R;
    }
    
}
