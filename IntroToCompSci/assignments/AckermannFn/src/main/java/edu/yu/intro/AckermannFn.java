package edu.yu.intro;

/** "AckermannFn" for Yeshiva University.
*
* @author Ophir Amon
*/

public class AckermannFn{
    public static void main(String[] args) {
        System.out.println(ackermann(3L, 1L));
    }

    public static long ackermann(long m, long n){
        if(m == 0){
            return n + 1;
        }
        if(n == 0){
            return ackermann(m - 1, 1);
        }
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}