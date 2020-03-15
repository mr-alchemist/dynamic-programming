import java.util.*;

public class Program
{
    public static void main (String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = scanner.nextInt();
        
        int[] L = new int[N];
        int[] R = new int[N];
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int prev = A[0];
        for(int i = 0; i < N; i++){
            if(A[i] >= prev)
                stack.push(i);
            else{
                int border = i - 1;                
                while(stack.peekFirst() != null && A[stack.peekFirst()] > A[i])
                    R[stack.pop()] = border;
                
                stack.push(i);
            }
            prev = A[i];
        }
        while(stack.peekFirst() != null)
            R[stack.pop()] = N - 1;

        
        prev = A[N-1];
        for(int i = N - 1; i >= 0; i--) {
        	if(A[i] >= prev)
                stack.push(i);
        	else {
        		int border = i + 1;
        		while(stack.peekFirst() != null && A[stack.peekFirst()] > A[i])
                    L[stack.pop()] = border;
        		
        		stack.push(i);
        	}
        	prev = A[i];
        }
        while(stack.peekFirst() != null)
            L[stack.pop()] = 0;
        
        for(int i = 0; i < N - 1; i++)
            System.out.print(L[i] + " ");
        System.out.print(L[N-1]);
        System.out.println("");
        
        for(int i = 0; i < N - 1; i++)
            System.out.print(R[i] + " ");
        System.out.print(R[N-1]);
        System.out.println("");
        
    }
}
