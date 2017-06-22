import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; i++) 
    {
    	long N = in.nextLong();
    	long K = in.nextLong();
        long maxPowerOfK = 1;
        long partOfLocate = 0;
        long remainingStalls = 0;
        long quotient = 0;
        long reminder = 0;
        long sumResult = 0;
        long L_s = 0;
        long R_s = 0;
        long k = K;
        /*while(Math.pow(2, maxPowerOfK) - 1 < K)
        {
            //System.out.println("maxPowerOfK = " + maxPowerOfK);
            //System.out.println("result = " + Math.pow(2, maxPowerOfK));
            maxPowerOfK++;
        }*/
        while(k >> 1 > 0)
        {
            k = k >> 1;
            maxPowerOfK++;
            //System.out.println("maxPowerOfK = " + maxPowerOfK);
        }
        //System.out.println("maxPowerOfK = " + maxPowerOfK);
        maxPowerOfK--;
        partOfLocate = K - (long)Math.pow(2, maxPowerOfK) + 1;
        remainingStalls = N - (long)Math.pow(2, maxPowerOfK) + 1;
        quotient = remainingStalls / (long)Math.pow(2, maxPowerOfK);
        reminder = remainingStalls % (long)Math.pow(2, maxPowerOfK);
        //System.out.println("maxPowerOfK = " + maxPowerOfK);
        //System.out.println("remainingStalls = " + remainingStalls);
        //System.out.println("partOfLocate = " + partOfLocate);
        //System.out.println("quotient = " + quotient);
        //System.out.println("reminder = " + reminder);
        if(partOfLocate <= reminder)
        {
            sumResult = quotient + 1;
        }
        else
        {
            sumResult = quotient;
        }
        
        if(sumResult % 2 == 0)
        {
            L_s = sumResult / 2 - 1;
            R_s = sumResult / 2;
        }
        else
        {
            L_s = sumResult / 2;
            R_s = sumResult / 2;
        }
        
        //System.out.println("sumResult = " + sumResult);
        
        System.out.print("Case #" + i + ": " + Math.max(L_s, R_s) + " " + Math.min(L_s, R_s));
        System.out.println("");
        
    }
}
}
