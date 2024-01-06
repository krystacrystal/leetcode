package nowcoder;

import java.util.HashSet;
import java.util.LinkedList;

public class MyTest {

    private char[] str;
    private char[] path;
    private HashSet<String> res;

    public String[] generatePermutation(String s) {
        char[] str = s.toCharArray();
        char[] path = new char[str.length];
        HashSet<String> res = new HashSet<>();
        this.res = res;
        this.path = path;
        this.str = str;
        generatePermutation(0, 0);//从0字符往后生成所有的子序列
        String[] ans = new String[res.size()];
        int i = 0;
        for (String s1 : res) {
            ans[i++] = s1;
        }
        return ans;
    }

    //从i字符往后生成所有的子序列，当前path中已经存放了size个字符，是之前存好的
    public void generatePermutation(int i, int size) {
        if (i == str.length) {
            res.add(String.valueOf(path, 0, size));
            return;
        }
        //要
        path[size] = str[i];
        generatePermutation(i + 1, size + 1);
        //不要
        generatePermutation(i + 1, size);
    }




}
