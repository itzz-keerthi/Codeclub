/* TASK
It seems many of you helped our Suppandi really well in the previous challenge. He was very impressed, and has referred you to Chhota Bheem. Unlike Suppandi, Chhota Bheem is very smart. He doesn't need your help, instead he wants to test you.

Chhota Bheem's notebook is encrypted with a secret password. He never remembers the password, because he uses a hint and a formula to generate the password.

The hint is a series of N positive numbers. Some of these numbers are purposely left blank, and these are denoted by -1

He tells you that the way to generate the password is:

First you need to fill in the blanks. If numbers on both sides of the blank are both odd, or are both even, then fill it with the absolute difference of both numbers.

However, if both the numbers different (i.e. one is odd and the other is even), in that case fill it with the floor of the arithmetic mean of the 2 numbers.

Second, after you have filled in the blanks, reduce all numbers by 1 except the last number and the numbers whose value is already 1.

Finally, print all the numbers without any spaces. That is the password.

Note: The blanks never appear at the start or end of the list. The blanks also never appear next to each other

Input Format

• The first line contains T the number of test cases • The following T lines contains N followed by N numbers (all greater than 0). This is the hint as given by Chhota Bheem

Constraints

Note: N>=3

Output Format

• Print T passwords in a separate line

Sample Input 0

2
5 9 -1 8 1 2
3 9 1 4
Sample Output 0

87712
814
Explanation 0

In the first case, the blank is replaced by (9+8) / 2 = 8.5, since we take floor, we take 8. Then all numbers are subtracted by 1 as per the conditions: 8 7 7 1 2. Finally, print: 87712
In the second case, there are no blanks to fill, so we just subtract 1 from applicable numbers. In this case, that is the first number 9. Thus we print 814   */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            ArrayList<Integer> list=new ArrayList<Integer>();
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int ele=sc.nextInt();
                list.add(ele);
            }
            for(int j=0;j<list.size();j++){
                if(list.get(j)==-1){
                    if(((list.get(j-1))%2==0) && ((list.get(j+1))%2==0)){
                    list.set(j,Math.abs(list.get(j-1)-list.get(j+1)));
                             }
                    else if(((list.get(j-1))%2!=0) && ((list.get(j+1))%2!=0)){
                    list.set(j,Math.abs(list.get(j-1)-list.get(j+1)));
                             }
                    else{
                        list.set(j,(list.get(j-1)+list.get(j+1))/2);
                    }
                }
                else if(list.get(j)==1){
                    list.set(j,list.get(j)+1);
                }
            }
            int last=n-1;
            list.set(last,list.get(last)+1);
            for(int k=0;k<list.size();k++){
                System.out.print(list.get(k)-1);
            }System.out.println();
        }
    }
}
