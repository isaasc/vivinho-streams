package com.vivo.vivinho_streams.model;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Data
public class PacoteDados {
    private int idPacote;
    private int idLinha;
    private String descricao;
    private BigDecimal franquiaGb;
    private String status;
    private Timestamp dataInicio;
    private Timestamp dataFim;
}
