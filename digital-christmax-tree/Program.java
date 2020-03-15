import java.util.Scanner;

public class Program
{
    public static void main (String [] args){
        Program pr = new Program();
        pr.run();
        
    }
    void run(){
        Scanner scanner = new Scanner(System.in);
        int levelCnt = scanner.nextInt();
        int[][] matrix = new int[levelCnt][levelCnt];
        for(int i = 0; i <  levelCnt; i++)
            for(int j = 0; j <= i; j++)
                matrix[i][j] = scanner.nextInt();
        
        for(int level = levelCnt - 2; level >= 0; level--)
            for(int j = 0; j <= level; j++)
                matrix[level][j] += Math.max(matrix[level + 1][j], 
                                             matrix[level + 1][j+1]);
            
        
        System.out.println(matrix[0][0]);
    }
}
