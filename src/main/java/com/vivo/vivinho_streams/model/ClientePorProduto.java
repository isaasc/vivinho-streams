package com.vivo.vivinho_streams.model;

//import org.springframework.data.cassandra.core.mapping.Table;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.Map;

@Data
@Table("clientes_por_produto")
public class ClientePorProduto {

    @PrimaryKey
    private String id_cliente;
    private String nome;
    private String email;
    private String telefone;
    private Map<String, Map<String, String>> produtos;
    private Date data_criacao;

}
