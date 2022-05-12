package com.renatohdev.challenge.translate.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Phrases {

    private String phrase;
    private String translatedPhrase;
    private List<String> words;

}
