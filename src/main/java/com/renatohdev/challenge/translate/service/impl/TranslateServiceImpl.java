package com.renatohdev.challenge.translate.service.impl;

import com.renatohdev.challenge.translate.domain.Phrases;
import com.renatohdev.challenge.translate.domain.TranslateDTO;
import com.renatohdev.challenge.translate.domain.TranslateWord;
import com.renatohdev.challenge.translate.domain.Word;
import com.renatohdev.challenge.translate.rules.impl.*;
import com.renatohdev.challenge.translate.service.TranslateService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TranslateServiceImpl implements TranslateService {

    private RuleIdentifyPunctuation identifyPunctuation;
    private RuleSplitPrefixStem splitPrefixStem;
    private RuleReversePrefixStem reversePrefixStem;
    private RuleKeepCapitalLetter keepCapitalLetter;
    private RuleApplyPunctuationPosition applyPunctuationPosition;

    public TranslateServiceImpl() {
        identifyPunctuation = new RuleIdentifyPunctuation();
        splitPrefixStem = new RuleSplitPrefixStem();
        reversePrefixStem = new RuleReversePrefixStem();
        keepCapitalLetter = new RuleKeepCapitalLetter();
        applyPunctuationPosition = new RuleApplyPunctuationPosition();
    }

    @Override
    public TranslateWord translate(TranslateDTO words) {

        List<Phrases> wordsTranslate = new ArrayList<>();
        List<Phrases> finalWords = new ArrayList<>();

        convertAndSplitEachPhraseAndWords(words, wordsTranslate);

        TranslateWord tw = TranslateWord.builder().build();

        wordsTranslate.stream().forEach(phrase -> {
            List<Word> listWords = new ArrayList<>();

            applyRules(phrase, listWords);

            String phraseTranslated = defineTranslatedPhrase(listWords);

            phrase.setTranslatedPhrase(phraseTranslated);

            finalWords.add(phrase);
        });

        tw.setTranslatedPhrases(finalWords);

        return tw;
    }

    private String defineTranslatedPhrase(List<Word> listWords) {
        String phraseTranslated = "";

        for(Word w : listWords) {
            phraseTranslated += w.getTranslatedWord() + " ";
        }
        if(phraseTranslated.endsWith(" ")) {
            phraseTranslated = phraseTranslated.substring(0, phraseTranslated.length()-1)+".";
        }
        return phraseTranslated;
    }

    private void applyRules(Phrases phrase, List<Word> listWords) {
        phrase.getWords().forEach(word -> {
            if(NumberUtils.isCreatable(word)) {
                listWords.add(Word.builder()
                        .translatedWord(word)
                        .word(phrase.getPhrase()).build());
            } else {
                Word translate = identifyPunctuation.execute(word);
                translate = splitPrefixStem.executeWord(translate);
                translate = reversePrefixStem.executeWord(translate);
                translate = keepCapitalLetter.executeWord(translate);
                translate = applyPunctuationPosition.executeWord(translate);

                listWords.add(translate);
            }
        });
    }

    private void convertAndSplitEachPhraseAndWords(TranslateDTO words, List<Phrases> wordsTranslate) {
        words.getWords().forEach(word -> Collections.addAll(wordsTranslate,
                Phrases.builder()
                        .phrase(word)
                        .words(Arrays.asList( word.split(" ") ))
                        .build()));
    }
}
