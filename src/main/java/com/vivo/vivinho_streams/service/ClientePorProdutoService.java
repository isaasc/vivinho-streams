package com.vivo.vivinho_streams.service;

import com.vivo.vivinho_streams.model.ClientePorProduto;
import com.vivo.vivinho_streams.repository.ClientePorProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientePorProdutoService {

    @Autowired
    private ClientePorProdutoRepository clientePorProdutoRepository;

    public void salvarCliente(ClientePorProduto cliente) {
        clientePorProdutoRepository.save(cliente);
    }
}
