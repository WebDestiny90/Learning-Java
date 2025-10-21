package com.schedule.schedule.service;

import com.schedule.schedule.client.CbarClient;
import com.schedule.schedule.dto.ValCurs;
import com.schedule.schedule.dto.ValType;
import com.schedule.schedule.dto.Valute;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CbarClient cbarClient;

    public void fetchAndPrintCurrencies() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        ValCurs valCurs = cbarClient.getCurrencies(date);

        log.info("📅 Tarix: {}", valCurs.getDate());
        for (ValType type : valCurs.getValTypes()) {
            log.info("==== {} ====", type.getType());
            for (Valute v : type.getValutes()) {
                log.info("{} ({}) = {} AZN", v.getName(), v.getCode(), v.getValue());
            }
        }
    }
}
