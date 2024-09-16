package com.vivo.vivinho_streams.repository;

import com.vivo.vivinho_streams.model.ClientePorProduto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePorProdutoRepository extends CassandraRepository<ClientePorProduto, String> {
}
