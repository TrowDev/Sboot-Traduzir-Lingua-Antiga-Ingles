package com.renatohdev.challenge.translate.service;

import com.renatohdev.challenge.translate.domain.TranslateDTO;
import com.renatohdev.challenge.translate.domain.TranslateWord;

public interface TranslateService {

    TranslateWord translate(TranslateDTO dto);

}
