
package br.edu.nassau.apicursos;

import br.edu.nassau.apicursos.model.Curso;
import br.edu.nassau.apicursos.repository.CursoRepository;
import br.edu.nassau.apicursos.service.CursoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CursoServiceTest {

    @Mock
    private CursoRepository repository;

    @InjectMocks
    private CursoService service;

    @Test
    void deveCadastrarCursoComSucesso() {

        // Arrange: preparação do cenário
        Curso curso = new Curso(null, "Java", 40,
                "Curso de programação", "Tecnologia");

        Curso salvo = new Curso(1L, "Java", 40,
                "Curso de programação", "Tecnologia");

        // Configuração do Mock
        when(repository.save(curso)).thenReturn(salvo);

        // Act: execução do método
        Curso resultado = service.cadastrarCurso(curso);

        // Assert: verificação do resultado
        assertEquals(1L, resultado.getId());
        assertEquals("Java", resultado.getNome());

        // Verificação da interação com o Repository
        verify(repository, times(1)).save(curso);
    }

    @Test
    void deveListarCursosComSucesso() {

        Curso curso = new Curso(1L, "Java", 40,
                "Programação", "Tecnologia");

        when(repository.findAll()).thenReturn(List.of(curso));

        List<Curso> resultado = service.listarCursos();

        assertEquals(1, resultado.size());
        assertEquals("Java", resultado.get(0).getNome());

        verify(repository, times(1)).findAll();
    }

    @Test
    void deveRejeitarCursoSemNome() {

        Curso curso = new Curso(null, "", 40,
                "Programação", "Tecnologia");

        assertThrows(IllegalArgumentException.class,
                () -> service.cadastrarCurso(curso));

        verify(repository, never()).save(any(Curso.class));
    }

    @Test
    void deveRejeitarCargaHorariaInvalida() {

        Curso curso = new Curso(null, "Java", 0,
                "Programação", "Tecnologia");

        assertThrows(IllegalArgumentException.class,
                () -> service.cadastrarCurso(curso));

        verify(repository, never()).save(any(Curso.class));
    }
}
