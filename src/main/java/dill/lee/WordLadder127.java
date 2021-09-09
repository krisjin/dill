package dill.lee;

import java.util.*;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder
 * <pre>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * </pre>
 */
public class WordLadder127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        HashMap<String, Integer> map = new HashMap<>();//用来存储已访问的节点，并存储其在路径上的位置，相当于BFS算法中的isVisted功能
        Queue<String> queue = new LinkedList<>();//构建队列，实现广度优先遍历。
        queue.add(beginWord);//加入源顶点

        map.put(beginWord, 1);//添加原顶点为“已访问”，并记录它在路径的位置

        while (!queue.isEmpty()) {
            String word = queue.poll();//记录正在处理的顶点
            int level = map.get(word);//记录现在路径的长度

            for (int i = 0; i < word.length(); i++) {
                char[] wordLetter = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordLetter[i] == j) continue;
                    wordLetter[i] = j;//对于每一位字母，分别替换成另外25个字母
                    String check = new String(wordLetter);
                    if (check.equals(endWord)) return map.get(word) + 1;//如果已经抵达目标节点，返回当前路径长度+1
                    if (wordSet.contains(check) && !map.containsKey(check)) {//如果字典中存在邻接节点，且这个邻接节点还未被访问
                        map.put(check, level + 1);//标记这个邻接节点为已访问，记录其在路径上的位置
                        queue.add(check);//加入队列，以供广度搜索
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int count = ladderLength(beginWord, endWord, wordList);
        System.out.println(count);
    }

}
