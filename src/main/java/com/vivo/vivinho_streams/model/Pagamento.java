package com.vivo.vivinho_streams.model;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Data
public class Pagamento {
    private int idPagamento;
    private int idFatura;
    private Timestamp dataPagamento;
    private BigDecimal valorPago;
    private String status;
}
