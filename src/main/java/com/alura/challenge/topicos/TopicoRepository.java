package com.alura.challenge.topicos;

import org.springframework.data.jpa.repository.JpaRepository;

 public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
} 