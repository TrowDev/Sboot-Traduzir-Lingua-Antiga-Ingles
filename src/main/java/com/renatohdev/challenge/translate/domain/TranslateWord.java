package com.renatohdev.challenge.translate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TranslateWord implements Serializable {

    private List<Phrases> translatedPhrases;

}
