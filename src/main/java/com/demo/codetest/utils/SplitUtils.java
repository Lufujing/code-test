package com.demo.codetest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtils {

    public static String replaceConsecutiveLettersToPrefix(String str, int count) {
        String replaceResult = replaceOperation(str, count, findMatchChar(str, count));
        if (replaceResult.equals(str)) {
            return replaceResult;
        }
        return replaceConsecutiveLettersToPrefix(replaceResult, count);
    }

    /**
     * 查找是否存在给定数量的重复字符串, (.)\\1{%d} 表示单个字符后面连续着%d个相同字符
     * @param str 需要查找的字符串
     * @param count 重复字符个数
     * @return 存在匹配重复字符串的前一个字符
     */
    public static String findMatchChar(String str, int count) {
        String regex = String.format("(.)\\1{%d}", count - 1);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        char matchPrefixChar = ' ';
        if (matcher.find()) {
            String match = matcher.group();
            char matchChar = match.charAt(0);
            if (matchChar > 'a' && matchChar < 'z') {
                matchPrefixChar = (char) ((int) matchChar - 1);
            }
            System.out.printf("%s >> %s%n", match, matchPrefixChar);
        }
        return String.valueOf(matchPrefixChar).replaceAll(" ", "");
    }

    /**
     * 循环替换连续字符串直至没有能替换退出
     * @param str 需要替换的字符串
     * @param count 字符连续个数
     * @param replacement 替换字符串
     * @return 最终字符串结果
     */
    public static String LoopReplaceConsecutiveLetters(String str, int count, String replacement) {
        String result = replaceOperation(str, count, replacement);
        if (str.equals(result)) {
            return result;
        }
        return LoopReplaceConsecutiveLetters(result, count, replacement);
    }

    /**
     * 替换操作, (.)\\1{%d} 表示单个字符后面连续着%d个相同字符
     * @param str 所需替换字符串
     * @param count 字符连续个数
     * @param replacement 替换字符串
     * @return 替换后字符串
     */
    public static String replaceOperation(String str, int count, String replacement) {
        String regex = String.format("(.)\\1{%d}", count - 1);
        String result = str.replaceFirst(regex, replacement);
        System.out.printf("%s >> %s%n", str, result);
        return result;
    }

}
