package dill.base;

/**
 * @author krisjin on 2019/5/9
 */
public class BinarySearchUtil {


    public static int rank(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

}




