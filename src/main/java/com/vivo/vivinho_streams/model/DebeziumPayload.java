package com.vivo.vivinho_streams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebeziumPayload {
    private DebeziumData payload;
}
