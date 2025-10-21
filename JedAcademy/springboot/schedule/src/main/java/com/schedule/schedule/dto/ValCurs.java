package com.schedule.schedule.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class ValCurs {
    @JacksonXmlProperty(isAttribute = true, localName = "Date")
    private String date;

    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String name;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ValType")
    private List<ValType> valTypes;
}
