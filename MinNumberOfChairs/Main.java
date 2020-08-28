/*
There are n guests who are invited to a party. The k-th guest will attend the party at time S[k] and leave the party at time E[k].
Given an integer array S and an integer array E, both of length n, return an integer denoting the minimum number of chairs you need such that everyone attending the party can sit down.
*/

public class Main {

    static int func(int[] s,int[] e){
        return 0;
    }

    public static void main(String[] args) {
        int[] s1 = {1, 2, 6, 5, 3};
        int[] e1 = {5, 5, 7, 6, 8};
        int expected = 3;
        int result = func(s1, e1);
        System.out.println(result);
        System.out.println(result==expected);

        int[] s1 = {1, 2, 9, 5, 5};
        int[] e1 = {4, 5, 12, 9, 12};
        int expected = 3;
        int result = func(s1, e1);
        System.out.println(result);
        System.out.println(result==expected);
    }
}