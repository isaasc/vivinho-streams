package com.vivo.vivinho_streams.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class LinhaMovel {
    private int idLinha;
    private int idCliente;
    private String numeroLinha;
    private String plano;
    private String status;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private Timestamp dataCriacao;
}
