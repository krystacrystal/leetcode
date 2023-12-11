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

    char[] path1;

    public String[] generatePermutation1(String s) {
        char[] str = s.toCharArray();
        char[] path1 = new char[str.length];
        HashSet<String> set = new HashSet<>();
        this.path1 = path1;
        this.set = set;
        this.str = str;
        generatePermutation1(0, 0);
        String[] res = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            res[i++] = s1;
        }
        return res;
    }

    //size表示当前path中已经填了多少个字符
    public void generatePermutation1(int i, int size) {
        if (i == str.length) {
            set.add(String.valueOf(path1,0,size));
            return;
        }
        //要
        path1[size] = str[i];
        generatePermutation1(i + 1, size + 1);
        //不要
        generatePermutation1(i + 1, size);
    }


    @Test
    public void test() {
        String[] strings = generatePermutation1("abcde");
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
