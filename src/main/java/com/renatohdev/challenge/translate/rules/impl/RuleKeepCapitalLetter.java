package com.renatohdev.challenge.translate.rules.impl;

import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.TranslateRule;

public class RuleKeepCapitalLetter implements TranslateRule {
    @Override
    public Word execute(String word) {
        return null;
    }

    @Override
    public Word executeWord(Word word) {
        boolean isCapital = Character.isUpperCase(word.getWord().charAt(0));

        String retWord = word.getTranslatedWord();
        String firstLet= retWord.charAt(0)+"";

        if(isCapital) {
            firstLet = firstLet.toUpperCase();
        } else {
            firstLet = firstLet.toLowerCase();
        }

        word.setTranslatedWord(firstLet + retWord.substring(1).toLowerCase());

        return word;
    }
}
