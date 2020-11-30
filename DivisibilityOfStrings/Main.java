package DivisibilityOfStrings;

public class Main {
    
    public static void main(String[] args) {
        System.out.println(func("bcdbcdbcd", "bcdbcd") + " -1");
        System.out.println(func("bcdbcdbcdbcdbcdbcd", "bczbcdbcd") +  " -1");
        System.out.println(func("bcdbcdbcdbcdbcdbcd", "bcdbcdbcd") +  " 3");
        System.out.println(func("aaaaaa","aa") +  " 1");
        String s7 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd";
        String s8 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd";
        System.out.println(func(s7, s8) + " 194");
    }

    private static int func(String a, String b) {
        /*
        Compare length 
        Check if its divisible - Using loop 
        for every substring in b check if its a subunit, b 
        substring of length 1 
            loop through b to check if every substring is the same 
        substring of length 2 
            loop through b to check if b.charAt(j) == b.charAt(j%(i+1))
        if it manage to reach the end then i+1 is the length;
        */

        if (a.length() % b.length() != 0)  return -1;
        int blen = b.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i%blen)) return -1;
        }
        for (int i = 0; i < b.length(); i++) {
            int j = 0;
            for (; j < b.length(); j++) {
                if (b.charAt(j) != b.charAt(j%(i+1))) break;
            }
            if (j == b.length()) return i+1;
        }
        return 0;
    }
}
