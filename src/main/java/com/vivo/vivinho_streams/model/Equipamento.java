package com.vivo.vivinho_streams.model;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class Equipamento {
    private int idEquipamento;
    private int idAssinatura;
    private String tipo;
    private String modelo;
    private Timestamp dataInstalacao;
    private String status;
}
