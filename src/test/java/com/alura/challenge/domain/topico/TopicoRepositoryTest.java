package com.alura.challenge.domain.topico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.alura.challenge.dto.DadosCadastroTopico;
import com.alura.challenge.topicos.Topico;
import com.alura.challenge.topicos.TopicoRepository;
import com.alura.challenge.usuario.Usuario;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.alura.challenge.topicos.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class TopicoRepositoryTest {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deveria retornar true quando já existe tópico com mesmo título e mensagem")
    void existsByTituloAndMensagemCenario1() {
        // Arrange (Preparar)
        var titulo = "Dúvida Java";
        var mensagem = "Erro no Spring";
        var autor = cadastrarUsuario("User Test", "123456");
        cadastrarTopico(titulo, mensagem, autor, "Java Spring");

        // Act (Executar)
        var existe = repository.existsByTituloAndMensagem(titulo, mensagem);

        // Assert (Verificar)
        assertThat(existe).isTrue();
    }

    private Topico cadastrarTopico(String titulo, String mensagem, Usuario autor, String curso) {
        var dados = new DadosCadastroTopico(titulo, mensagem, curso);
        var topico = new Topico(dados, autor);
        em.persist(topico);
        return topico;
    }

    private Usuario cadastrarUsuario(String login, String senha) {
        var usuario = new Usuario(null, login, senha);
        em.persist(usuario);
        return usuario;
    }
}