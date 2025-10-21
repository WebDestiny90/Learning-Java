package com.schedule.schedule.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Valute {
    @JacksonXmlProperty(isAttribute = true, localName = "Code")
    private String code;

    @JacksonXmlProperty(localName = "Nominal")
    private String nominal;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "Value")
    private String value;
}
