package com.vivo.vivinho_streams.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivo.vivinho_streams.model.ClientePorProduto;
import com.vivo.vivinho_streams.model.DebeziumPayload;
import com.vivo.vivinho_streams.service.ClientePorProdutoService;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaStreamProcessor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Autowired
    private ClientePorProdutoService clientePorProdutoService;

    @Bean
    public KStream<String, String> process(StreamsBuilder builder) {
        final Serde<String> stringSerde = Serdes.String();

        KStream<String, String> stream = builder.stream(
                Arrays.asList("VIVOFIBRA.public.assinaturas", "VIVOFIBRA.public.clientes", "VIVOFIBRA.public.equipamentos", "VIVOFIBRA.public.pagamentos", "VIVOFIBRA.public.faturas", "VIVOFIBRA.public.servicos_adicionais"),
                Consumed.with(stringSerde, stringSerde)
        );

        stream.foreach((key, value) -> {
            try {
                DebeziumPayload payload = objectMapper.readValue(value, DebeziumPayload.class);
                String tabela = payload.getPayload().getSource().getTable();

                if (payload.getPayload().getOp().equals("c")) {
                    String idCliente = String.valueOf(payload.getPayload().getAfter().getId_cliente());
                    ClientePorProduto cliente = getClientePorProduto(payload, idCliente);

                    clientePorProdutoService.salvarCliente(cliente);

                    System.out.println("Novo cliente criado com ID: " + idCliente);
                    return;
                }

                if(payload.getPayload().getOp().equals("u")) {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return stream;
    }

    private static ClientePorProduto getClientePorProduto(DebeziumPayload payload, String idCliente) {
        String nome = payload.getPayload().getAfter().getNome();
        String email = payload.getPayload().getAfter().getEmail();
        String telefone = payload.getPayload().getAfter().getTelefone();

        ClientePorProduto cliente = new ClientePorProduto();
        cliente.setId_cliente(idCliente);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setData_criacao(new Date());
        cliente.setProdutos(null);
        return cliente;
    }
}
