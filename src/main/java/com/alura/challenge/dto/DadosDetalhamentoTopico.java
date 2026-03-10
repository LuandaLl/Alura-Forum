package com.alura.challenge.dto;

import com.alura.challenge.topicos.Topico;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String autor, String curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor().getLogin(), topico.getCurso());
    }
}