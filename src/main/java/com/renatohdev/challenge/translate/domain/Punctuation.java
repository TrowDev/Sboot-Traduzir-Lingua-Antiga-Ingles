package com.renatohdev.challenge.translate.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Punctuation {

    private int position;
    private String punctuation;

}
