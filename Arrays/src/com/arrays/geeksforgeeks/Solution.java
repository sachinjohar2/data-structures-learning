/* IMPORTANT: Multiple classes and nested static classes are supported */



//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Solution {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i =0; i< n; i++){
            arr[i] = s.nextInt();

        }
        int MAX_G = 0;
        int MAX = 0;
        for(int i =0; i< n; i++){
            if(arr[i] <= 0){
                continue;
            }
            int temp = arr[i];
            MAX = arr[i];
            for(int j=i+1; j< n; j++){

                if(arr[j] > 0 && arr[j] % temp == 0  && arr[j] >temp) {
                    MAX +=arr[j];
                    temp = arr[j];
                }
            }

            if(MAX > MAX_G){
                MAX_G = MAX;
            }
        }

        System.out.println(MAX_G);

    }
}
