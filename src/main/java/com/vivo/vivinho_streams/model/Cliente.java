package com.vivo.vivinho_streams.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Cliente {
    private int id_cliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Timestamp data_criacao;
}

