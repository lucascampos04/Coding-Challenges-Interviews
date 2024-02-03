/**
 * 
 * Version used : Java 8
 * 
 * 
 * 
 */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getMinFlips' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING pwd as parameter.
     */

    public static int getMinFlips(String pwd) {
    int n = pwd.length();
    int[] prefixSum = new int[n + 1];
    
    for (int i = 1; i <= n; i++){
        prefixSum[i] = prefixSum[i -1] + (pwd.charAt(i - 1) == '1' ? 1 : 0);
    }
    
    int minFlips = Integer.MAX_VALUE;
    
    for (int i = 2; i <= n; i+=2){
        int flipsEven = prefixSum[i] - prefixSum[i / 2];
        int flipsOdd = (i - prefixSum[i]) - (i / 2 - prefixSum[i / 2]);
        
        minFlips = Math.min(minFlips, Math.min(flipsEven, flipsOdd));
    }
    return minFlips;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String pwd = bufferedReader.readLine();

        int result = Result.getMinFlips(pwd);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}