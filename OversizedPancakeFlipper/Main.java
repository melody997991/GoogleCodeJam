import java.util.*;
import java.io.*;
public class Main {
public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String S = in.nextLine();
    for (int i = 1; i <= T; i++) 
    {
        S = in.next();
        String[] s = S.split("");
        int K = in.nextInt();
        int count = 0;
        //for(int j = 0; j < s.length ; j++)
        for(int j = 0; j < s.length - K; j++)
        {
            if(s[j].equals("+"))
                continue;
            else if(s[j].equals("-"))
            {
                for(int k = 0; k < K; k++)
                {
                    //System.out.println("before: " + s[j+k]);
                    if(s[j+k].equals("+"))
                        s[j+k] = "-";
                    else
                        s[j+k] = "+";
                    //System.out.println("after: " + s[j+k]);
                }
                count++;
            }
        }
        boolean allTheSame = true;
        for(int j = s.length - 2; j > s.length - K - 1; j--)
        {
            if(!s[s.length - 1].equals(s[j]))
                allTheSame = false;
        }
        if(s[s.length - 1].equals("-"))
        {
            count++;
        }
        if(allTheSame == false)
        {
            System.out.print("Case #" + i + ": IMPOSSIBLE");
            System.out.println("");
        }
        else
        {
            System.out.print("Case #" + i + ": " + count);
            System.out.println("");
        }
    }
}
}
