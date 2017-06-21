import java.util.*;
import java.io.*;
public class Main {
    public static int[] add(int[] a) { 
        int carry = 1;

        for(int i = a.length - 1; i >= 0; i--) { 
            a[i] = a[i] + carry; 
            if(a[i] < 10) 
                carry = 0; 
            else { // 進位 
                a[i] = a[i] - 10; 
                carry = 1; 
            } 
        }

        return a;
    }
    public static int[] sub(int[] a) { 
        int borrow = 1; 

        for(int i = a.length - 1; i >= 0; i--) { 
            a[i] = a[i] - borrow; 
            if(a[i] >= 0) 
                borrow = 0; 
            else { // 借位 
                a[i] = a[i] + 10; 
                borrow = 1; 
            } 
        }

        return a;
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        String S = in.nextLine();
        for (int i = 1; i <= T; i++) 
        {
            S = in.nextLine();
            String[] s = S.split("");
            int[] N = new int[s.length];

            for (int j = 0; j < s.length; j++) 
            {
                try 
                {
                    N[j] = Integer.parseInt(s[j]);
                } 
                catch (NumberFormatException nfe) 
                {
                    //NOTE: write something here if you need to recover from formatting errors
                };
            }

            boolean found = false;
            while(!found)
            {
                boolean changeTo9 = false;
                for (int j = 0; j < N.length - 1; j++) 
                {
                    if(changeTo9 == true)
                    {
                        N[j] = 9;
                    }
                    else if(changeTo9 == false)
                    {
                        if(N[j] > N[j+1])
                        {
                            N[j] = N[j] - 1;
                            changeTo9 = true;
                        }
                    }
                }
                if(changeTo9 == true)
                {
                    N[N.length - 1] = 9;
                }
                found = true;
                for (int j = 0; j < N.length - 1; j++) 
                {
                    if(N[j] > N[j+1])
                    {
                        found = false;
                    }
                }
            }

            System.out.print("Case #" + i + ": ");
            boolean print = false;
            for (int j = 0; j < N.length; j++) 
            {
                if(!print && N[j] != 0)
                {
                    print = true;
                }
                if(print)
                {
                    System.out.print(N[j]);
                }
            }
            System.out.println("");
        }
    }
}
