package nowcoder;

import org.junit.Test;

import java.util.HashSet;

public class nc190_generatePermutation {
    StringBuilder path;
    HashSet<String> set;
    char[] str;

    public String[] generatePermutation(String s) {
        char[] str = s.toCharArray();
        StringBuilder path = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        this.path = path;
        this.set = set;
        this.str = str;
        generatePermutation(0);
        String[] res = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            res[i++] = s1;
        }
        return res;
    }

    //构成重载的递归函数
    public void generatePermutation(int i) {
        if (i == str.length) {
            //收集路径
            set.add(path.toString());
            return;
        }
//        //要当前的i
//        path.append(str[i]);
//        generatePermutation(i + 1);
//        //恢复现场
//        path.deleteCharAt(path.length() - 1);
//        //不要
//        generatePermutation(i + 1);

        //不要
        generatePermutation(i + 1);
        //要
        path.append(str[i]);
        generatePermutation(i + 1);
        //恢复现场
        path.deleteCharAt(path.length() - 1);
    }

    @Test
    public void test() {
        String[] strings = generatePermutation("abcde");
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
