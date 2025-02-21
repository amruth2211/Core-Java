package DSA;

//Sum of N natural number's
public class NaturalSum {

    /* We Analyse the program based on asymtotic analysis, The first function will take c2(n)+c3 and second one takes C1 
       time which is linear and for the second one it is based on n which keeps on increasing the time based on the value of n
       We always use the 2-d graphs to compare the functions in asymptotic functions */

    public static void main(String[] args) {
        System.out.println(sum(3));
    }

    // This takes more time as we are iterating n times
    public static int sum(int n){
        int res = 0;
        for(int i=1; i<=n; i++){
            res+= i;
        }
        return res;
    }

    // This is more effecient
    public static int sum2(int n){
        return n*(n+1)/2;
    }


}
