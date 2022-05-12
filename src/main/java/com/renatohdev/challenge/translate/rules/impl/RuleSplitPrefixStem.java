package com.renatohdev.challenge.translate.rules.impl;

import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.TranslateRule;
import com.renatohdev.challenge.utils.RulesUtil;

public class RuleSplitPrefixStem implements TranslateRule {

    @Override
    public Word execute(String word) {
        return null;
    }

    @Override
    public Word executeWord(Word word) {

        boolean stopPrefix = false;
        for(int i = 0; i < word.getWord().length(); i++) {
            String letter = word.getWord().charAt(i)+"";
            if(RulesUtil.punctuations.contains(letter)) continue;
            if(RulesUtil.vowels.contains(letter)) {
                stopPrefix = true;
            }
            if(!stopPrefix) {
                word.setPrefix(word.getPrefix()+letter);
            } else {
                word.setStem(word.getStem()+letter);
            }
        }

        return word;
    }
}
