package dill.leet.test;

import com.jd.jr.jseg.Jseg;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import jdk.nashorn.internal.parser.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;

/**
 * User:krisjin
 * Date:2020-08-03
 */
public class T {

    public static void main(String[] args) {
       double d=Math.pow(2,64);
        BigDecimal num = new BigDecimal(d);
        System.err.println(num.toPlainString());

        List<String> dd=Jseg.conciseSeg("【研报掘金】资金面波动白酒估值回落明显，中长期配置价值显著",true);

        System.err.println(dd);



    }
}
