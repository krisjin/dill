package dill.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dill.lee.array.MergeSortArray88;

import java.util.List;

/**
 * @author kris
 * @date 2023/2/20
 */
public class Test {


    public static void main(String[] args) {
        int[] numberArr1 = {1, 2, 3,0,0,0};
        int[] numberArr2 = {2, 5, 6};


        merger(numberArr1,3, numberArr2,numberArr2.length);



    }

    public static  void merger(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums1Copy = new int[m];
//        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int i = m - 1;
        int j = n - 1;

        for(int k = m + n - 1;k >= 0; k--) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 定义p1 和 p2 指针
        int p1 = m - 1;
        int p2 = n - 1;
        // 定义num1 值设置指针
        int p = m + n - 1;

        // 当p1和p2都包含数据元素是进行大小的比较并赋值给num1
        while ((p1 >= 0) && (p2 >= 0)) {
            //比较nums1和nums2，将最大的值赋值给p索引
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        //添加nums2中缺少的元素
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
