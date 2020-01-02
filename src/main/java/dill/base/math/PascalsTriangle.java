package dill.base.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度:简单
 * 描述：Given numRows, generate the first numRows of Pascal's triangle.
 * <p/>
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/30
 * Time: 21:17
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) return res;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> t = new ArrayList<Integer>();
            t.add(1);
            for (int j = 1; j < i; ++j) {
                t.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            t.add(1);
            res.add(t);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> lists = pascalsTriangle.generate(5);

        System.out.println("[");
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");

    }
}
