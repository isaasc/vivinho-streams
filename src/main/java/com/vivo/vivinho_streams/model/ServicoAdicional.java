package com.vivo.vivinho_streams.model;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Data
public class ServicoAdicional {
    private int idServico;
    private int idAssinatura;
    private String descricao;
    private BigDecimal valorMensal;
    private String status;
    private Timestamp dataInicio;
    private Timestamp dataFim;
}