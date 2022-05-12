package com.renatohdev.challenge.translate.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Word {

    private String word;
    private String translatedWord;
    private String prefix;
    private String stem;
    private boolean onlyVowel;
    private List<Punctuation> punctuations;

}
