package com.renatohdev.challenge.translate.v1;

import com.renatohdev.challenge.translate.domain.TranslateDTO;
import com.renatohdev.challenge.translate.domain.TranslateWord;
import com.renatohdev.challenge.translate.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/translate")
public class TranslateController {

    @Autowired
    private TranslateService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<TranslateWord> translate(@RequestBody TranslateDTO word) {
        return ResponseEntity.ok(service.translate(word));
    }

}
