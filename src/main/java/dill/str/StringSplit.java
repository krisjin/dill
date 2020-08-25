package dill.str;

/**
 * User:krisjin
 * Date:2020-08-03
 */
public class StringSplit {


    public static void main(String[] args) {

        String orgStr = "a,b,c,d,e,f,";

        String tmp = orgStr;
        for (int i = 0; i < 1000; i++) {
            while (true) {
                String splitStr = null;
                int j = tmp.indexOf(",");    //找分隔符的位置
                if (j < 0) break;             //没有分隔符存在，break
                splitStr = tmp.substring(0, j);  //找到分隔符，截取子字符串
                tmp = tmp.substring(j + 1);       //剩下需要处理的字符串
            }
            tmp = orgStr;
        }
    }


//
//    /**
//     * @Description: 通过charAt分割字符串
//     * @Param: [str, regx]
//     * @return: java.lang.String[]
//     * @Author: YinYichang
//     * @Date: 2018/7/18
//     */
//    public static String[] splitByCharAt(String str, char regx) {
//        //字符串截取的开始位置
//        int begin = 0;
//        //截取分割得到的字符串
//        String splitStr = "";
//        ArrayList<String> result = new ArrayList<String>();
//        int length = str.length();
//        //计数器
//        int i = 0;
//        for (i = 0; i < length; i++) {
//            if (str.charAt(i) == regx) {
//                splitStr = str.substring(begin, i);
//                result.add(splitStr);
//                str = str.substring(i + 1, length);
//                length = str.length();
//                i = 0;
//            }
//        }
//        if (!StringUtil.isBlank(str)) {
//            result.add(str);
//        }
//        String[] strs = new String[result.size()];
//        return result.toArray(strs);
//    }


}
