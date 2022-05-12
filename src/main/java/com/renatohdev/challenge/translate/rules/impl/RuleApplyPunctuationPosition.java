package com.renatohdev.challenge.translate.rules.impl;

import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.TranslateRule;
import com.renatohdev.challenge.utils.RulesUtil;

public class RuleApplyPunctuationPosition implements TranslateRule {

    @Override
    public Word execute(String word) {
        return null;
    }

    @Override
    public Word executeWord(Word word) {

        StringBuilder sb = new StringBuilder(word.getTranslatedWord());

        int addAtPosition = word.isOnlyVowel()
                ? RulesUtil.suffixWithOutConsoant.length() : RulesUtil.suffixWithConsoant.length();

        word.getPunctuations().forEach(p -> sb.insert(p.getPosition() + addAtPosition, p.getPunctuation()));

        word.setTranslatedWord(sb.toString());

        return word;
    }
}
