package com.vivo.vivinho_streams.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Assinatura {
    private int id_assinatura;
    private Integer id_cliente;
    private String plano;
    private String velocidade;
    private String status;
    private Long data_inicio;
    private Long data_fim;
    private Long data_criacao;
}
