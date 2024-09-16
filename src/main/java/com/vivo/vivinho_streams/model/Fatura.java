package com.vivo.vivinho_streams.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Fatura {
    private int idFatura;
    private int idAssinatura;
    private String mesReferencia;
    private BigDecimal valorFatura;
    private String status;
    private Timestamp dataCriacao;
}
