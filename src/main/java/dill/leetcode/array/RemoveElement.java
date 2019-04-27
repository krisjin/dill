package dill.leetcode.array;

/**
 * 在一个数组里面移除指定value，并且返回新的数组长度。这题唯一需要注意的地方在于，不能新建另一个数组
 * 重新给指定数组赋值
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 14:09
 */
public class RemoveElement {

    public static int removeElement(int[] arr, int val) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[j++] = arr[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 5, 5};
        int len = removeElement(ids, 5);
        System.out.println(len);
    }

}
