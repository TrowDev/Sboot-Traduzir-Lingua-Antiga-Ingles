package com.renatohdev.challenge.translate.rules.impl;

import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.TranslateRule;
import com.renatohdev.challenge.utils.RulesUtil;

public class RuleReversePrefixStem implements TranslateRule {

    @Override
    public Word execute(String word) {
        return null;
    }

    @Override
    public Word executeWord(Word word) {

        boolean onlyVowel = onlyVowel(word.getWord());
        String suffix = onlyVowel
                ? RulesUtil.suffixWithOutConsoant : RulesUtil.suffixWithConsoant;

        word.setOnlyVowel(onlyVowel);
        word.setTranslatedWord(word.getStem() + word.getPrefix() + suffix);

        return word;
    }

    public boolean onlyVowel(String word) {
        boolean onlyVowel = true;
        for(int i = 0; i < word.length(); i++) {
            String ch = word.charAt(i)+"";
            if(!RulesUtil.vowels.contains(ch.toLowerCase())) {
                onlyVowel = false;
                break;
            }
        }
        return onlyVowel;
    }

}
