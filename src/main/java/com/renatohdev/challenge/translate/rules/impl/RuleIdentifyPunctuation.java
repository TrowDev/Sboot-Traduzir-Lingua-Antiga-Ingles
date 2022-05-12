package com.renatohdev.challenge.translate.rules.impl;

import com.renatohdev.challenge.translate.domain.Punctuation;
import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.TranslateRule;
import com.renatohdev.challenge.utils.RulesUtil;

import java.util.ArrayList;
import java.util.List;

public class RuleIdentifyPunctuation implements TranslateRule {

    @Override
    public Word execute(String word) {

        Word w = Word.builder()
                .punctuations(new ArrayList<>())
                .prefix("").stem("").word(word)
                .build();

        for(int i = 0; i < word.length(); i++) {
            String punc = word.charAt(i)+"";
            if(RulesUtil.punctuations.contains(punc)) {
                w.getPunctuations().add(Punctuation.builder().position(i).punctuation(punc).build());
            }
        }

        return w;
    }

    @Override
    public Word executeWord(Word word) {
        return null;
    }
}
