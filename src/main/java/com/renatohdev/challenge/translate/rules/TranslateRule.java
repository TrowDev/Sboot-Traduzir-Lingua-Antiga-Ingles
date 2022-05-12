package com.renatohdev.challenge.translate.rules;

import com.renatohdev.challenge.translate.domain.Word;

import java.util.List;

public interface TranslateRule {

    Word execute(String word);

    Word executeWord(Word word);

}
