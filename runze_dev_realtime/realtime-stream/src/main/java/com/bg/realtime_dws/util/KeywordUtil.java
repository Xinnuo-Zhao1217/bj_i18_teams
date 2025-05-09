package com.bg.realtime_dws.util;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Package com.bg.realtime_dws.util.IkUtil
 * @Author Chen.Run.ze
 * @Date 2025/4/14 11:19
 * @description: Ik分词器
 */
public class KeywordUtil {

    public static Set<String> split(String s) {
        Set<String> result = new HashSet<>();
        // String => Reader

        Reader reader = new StringReader(s);
        // 智能分词
        // max_word
        IKSegmenter ikSegmenter = new IKSegmenter(reader, true);

        try {
            Lexeme next = ikSegmenter.next();
            while (next != null) {
                String word = next.getLexemeText();
                result.add(word);
                next = ikSegmenter.next();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return result;
    }
}
