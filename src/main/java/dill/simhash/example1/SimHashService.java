/**
 *
 */
package dill.simhash.example1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author zhangcheng
 *
 */
public class SimHashService {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {


        SimHash simHash = new SimHash(new BinaryWordSeg());

        // DocHashes is a list that will contain all of the calculated hashes.
//        ArrayList<Long> docHashes = Lists.newArrayList();
        Map<Integer,Long> docHashes= new HashMap<>();


        //Maps 12-bit key with the documents matching the partial hash
        Map<BitSet, HashSet<Integer>> hashIndex = Maps.newHashMap();

        // Read the documents. (Each line represents a document).
        Map<Integer, String> docs = readDocs(args);

        Map<String, String> docMap = new HashMap<>();


        long start = System.currentTimeMillis();
        int idx = 0;
        System.out.println("Start to build index...");

        //构建索引

        for (Map.Entry<Integer, String> entry : docs.entrySet()) {
            String doc = entry.getValue();
            long docHash = simHash.simHash64(doc);
            docHashes.put(entry.getKey(),docHash);//Store the document hash in a list.
            BitSet key = new BitSet(12);

            int step = 0;
            for (int i = 0; i < 64; ++i) {
                key.set(step, ((docHash >> i) & 1) == 1);
                if (step++ == 12) {
                    /*
                     * a) Separates the hash in 12-bit keys.
                     * b) This value will be a key in hashIndex.
                     * c) hashIndex will contain sets of documents matching each key (12-bits).
                     */
                    if (hashIndex.containsKey(key)) {
                        hashIndex.get(key).add(entry.getKey());
                    } else {
                        HashSet<Integer> vector = new HashSet<Integer>();
                        vector.add(entry.getKey());
                        hashIndex.put(key, vector);
                    }
                    step = 0;
                    key = new BitSet(12); // reset key holder.
                }
            }
            ++idx;
        }

//        docs.forEach((docId,doc) -> {
//            long docHash = simHash.simHash64(doc);
//            docHashes.add(docHash);//Store the document hash in a list.
//            BitSet key = new BitSet(12);
//
//            int step = 0;
//            for (int i = 0; i < 64; ++i) {
//                key.set(step, ((docHash >> i) & 1) == 1);
//                if (step++ == 12) {
//                    /*
//                     * a) Separates the hash in 12-bit keys.
//                     * b) This value will be a key in hashIndex.
//                     * c) hashIndex will contain sets of documents matching each key (12-bits).
//                     */
//                    if (hashIndex.containsKey(key)) {
//                        hashIndex.get(key).add(idx);
//                    } else {
//                        HashSet<Integer> vector = new HashSet<Integer>();
//                        vector.add(idx);
//                        hashIndex.put(key, vector);
//                    }
//                    step = 0;
//                    key = new BitSet(12); // reset key holder.
//                }
//            }
//            ++idx;
//        });


//        for (String doc : docs) {
//            long docHash = simHash.simHash64(doc);
//            docHashes.add(docHash);//Store the document hash in a list.
//            BitSet key = new BitSet(12);
//
//            int step = 0;
//            for (int i = 0; i < 64; ++i) {
//                key.set(step, ((docHash >> i) & 1) == 1);
//                if (step++ == 12) {
//                    /*
//                     * a) Separates the hash in 12-bit keys.
//                     * b) This value will be a key in hashIndex.
//                     * c) hashIndex will contain sets of documents matching each key (12-bits).
//                     */
//                    if (hashIndex.containsKey(key)) {
//                        hashIndex.get(key).add(idx);
//                    } else {
//                        HashSet<Integer> vector = new HashSet<Integer>();
//                        vector.add(idx);
//                        hashIndex.put(key, vector);
//                    }
//                    step = 0;
//                    key = new BitSet(12); // reset key holder.
//                }
//            }
//            ++idx;
//        }

        System.out.println("Index has been built.");

        idx = 0;
        BitSet bits = new BitSet(docs.size());


        for (Map.Entry<Integer, String> entry : docs.entrySet()) {
            String doc = entry.getValue();

            if (bits.get(idx)) {
                ++idx;
                continue;
            }

            // Calculates document hash.
            long docHash = simHash.simHash64(doc);
            BitSet key = new BitSet(12);

            int step = 0;
            HashSet<Integer> docSimilarCandidates = Sets.newHashSet();

            for (int i = 0; i < 64; ++i) {
                key.set(step, ((docHash >> i) & 1) == 1);

                if (step++ == 12) {
                    /*
                     * a) Separates the hash in 12-bit keys. b) This value will
                     * be a key in hashIndex. c) hashIndex will contain sets of
                     * documents matching each key (12-bits).
                     */
                    if (hashIndex.containsKey(key)) {
                        docSimilarCandidates.addAll(hashIndex.get(key));
                    }
                    step = 0;
                    key = new BitSet(12);
                }
            }
            List<Integer> similarDocs = Lists.newLinkedList();
            Map<Integer, Integer> docDistances = Maps.newHashMap();

            for (Integer i : docSimilarCandidates) {
                int dist = simHash.hammingDistance(docHash, docHashes.get(i));
                if (dist <= 3) {
                    similarDocs.add(i);
                    bits.set(i);
                    docDistances.put(i, dist);
                }
            }

            if (!similarDocs.isEmpty()) {
                for (int i : similarDocs) {
                    if (i == idx)
                        continue;

                    System.err.println("[" + docs.get(i) + "]\tDistance=[" + docDistances.get(i) + "]\n");


                }

            }
            bits.set(idx);
            ++idx;
        }


//        for (String doc : docs) {
//            if (bits.get(idx)) {
//                ++idx;
//                continue;
//            }
//
//            // Calculates document hash.
//            long docHash = simHash.simHash64(doc);
//            BitSet key = new BitSet(12);
//
//            int step = 0;
//            HashSet<Integer> docSimilarCandidates = Sets.newHashSet();
//
//            for (int i = 0; i < 64; ++i) {
//                key.set(step, ((docHash >> i) & 1) == 1);
//
//                if (step++ == 12) {
//                    /*
//                     * a) Separates the hash in 12-bit keys. b) This value will
//                     * be a key in hashIndex. c) hashIndex will contain sets of
//                     * documents matching each key (12-bits).
//                     */
//                    if (hashIndex.containsKey(key)) {
//                        docSimilarCandidates.addAll(hashIndex.get(key));
//                    }
//                    step = 0;
//                    key = new BitSet(12);
//                }
//            }
//            List<Integer> similarDocs = Lists.newLinkedList();
//            Map<Integer, Integer> docDistances = Maps.newHashMap();
//
//            for (Integer i : docSimilarCandidates) {
//                int dist = simHash.hammingDistance(docHash, docHashes.get(i));
//                if (dist <= 3) {
//                    similarDocs.add(i);
//                    bits.set(i);
//                    docDistances.put(i, dist);
//                }
//            }
//
//            if (!similarDocs.isEmpty()) {
//                for (int i : similarDocs) {
//                    if (i == idx)
//                        continue;
////                    Files.append("[" + docs.get(i) + "]\tDistance=[" + docDistances.get(i) + "]\n", null, Charsets.UTF_8);
//                }
//
//            }
//            bits.set(idx);
//            ++idx;
//        }

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
    }

    private static Map<Integer, String> readDocs(String[] args) throws IOException {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "微软公司有六周的时间敲定收购TikTok美国业务计划的细节。在这笔交易推进仍需解决的所有棘手问题中，有一个问题特别突出，那就是这家视频分享应用想要出售的业务到底价值多少？");
        map.put(2, "微软公司有六周的时间敲定收购TikTok美国业务计划的细节，以满足特朗普政府和TikTok中国母公司字节跳动股东的要求。在这笔交易推进仍需解决的所有棘手应用想要出售的业务到底价值多少？");
        map.put(3, "微软公司有六周的时间敲定收购TikTok美国业务计划的细节，以满足特朗普政府和TikTok中国母公司字节跳动股东的要求afafasfasfasfa。在这笔交易推进仍需解决的所有棘手问题中，有一个问题特别突出，那就是这家视频分享应用想要出售的业务到底价值多少？");
        map.put(4, "微软公司有六周的时间敲定收购TikTok美国业务计划的细节，在这笔交易推进仍需解决的所有棘手问题中，有一个问题特别突出，那就是这家视频分享应用想要出售的业务到底价值多少？");

        return map;
    }
}
