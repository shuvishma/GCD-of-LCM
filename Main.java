import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.Buffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    public static int gcd(int a, int b) {
        if(a == 0) return b ;
        return gcd(b%a, a) ;
    }
    public static int lcm(int a, int b) {
        return (a/gcd(a, b)) * b ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        int n = Integer.parseInt(read.readLine()) ;
        String[] str = read.readLine().trim().split(" ") ;
        int[] arr = new int[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]) ;
        }
        
        int[] temp = new int[n] ;
        for(int i=0; i<n; i++) {
            temp[i] = 1 ;
        }
        temp[n-1] = arr[n-1] ;
        for(int i=n-2; i>=0; i--) {
            temp[i] = gcd(arr[i], temp[i+1]) ;
        }
        int[] wemp = new int[n-1] ;
        for(int i=0; i<n-1; i++) {
            wemp[i] = lcm(arr[i], temp[i+1]) ;
        }
        int result = wemp[0] ;
        for(int i=1; i<n-1; i++) {
            result = gcd(result, wemp[i]) ;
        }
        System.out.println(result);

    }
}