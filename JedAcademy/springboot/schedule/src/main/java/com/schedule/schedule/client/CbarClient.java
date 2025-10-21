package com.schedule.schedule.client;

import com.schedule.schedule.dto.ValCurs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cbarClient", url = "${cbar.base-url}")
public interface CbarClient {

    @GetMapping(value = "/currencies/{date}.xml", produces = "application/xml")
    ValCurs getCurrencies(@PathVariable("date") String date);
}
