package com.vivo.vivinho_streams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.transform.Source;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebeziumData {
    private Cliente before;
    private Cliente after;
    private String op;  // Operação: c (create), u (update), d (delete)
    private long ts_ms;  // Timestamp
    private DebeziumSource source;
}
