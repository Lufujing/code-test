package com.demo.codetest.utils;

import org.junit.Assert;
import org.junit.Test;

public class SplitUtilsTests {

    @Test
    public void testRemoveContinuousCharacter() {
        Assert.assertEquals("d", SplitUtils.LoopReplaceConsecutiveLetters("aabcccbbad", 3, ""));
        Assert.assertEquals("ab", SplitUtils.LoopReplaceConsecutiveLetters("ab", 3, ""));
        Assert.assertEquals("abc", SplitUtils.LoopReplaceConsecutiveLetters("aaaabbbbcccc", 3, ""));
    }

    @Test
    public void testReplaceContinuousCharacter() {
        Assert.assertEquals("d", SplitUtils.replaceConsecutiveLettersToPrefix("abcccbad", 3));
        Assert.assertEquals("abc", SplitUtils.replaceConsecutiveLettersToPrefix("abc", 3));
        Assert.assertEquals("ab", SplitUtils.replaceConsecutiveLettersToPrefix("aaabbbccc", 3));
        Assert.assertEquals("", SplitUtils.replaceConsecutiveLettersToPrefix("aaaaaaaaa", 3));
    }

}
