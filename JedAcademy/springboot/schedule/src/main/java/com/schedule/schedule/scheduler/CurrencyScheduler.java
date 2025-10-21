package com.schedule.schedule.scheduler;

import com.schedule.schedule.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class CurrencyScheduler {

    private final CurrencyService currencyService;

//    @Scheduled(cron = "0 0 10 * * *")
    @Scheduled(fixedRate = 10000)
    public void runDaily() {
        log.info("💰 Məzənnə məlumatı yenilənir...");
        currencyService.fetchAndPrintCurrencies();
    }
}
