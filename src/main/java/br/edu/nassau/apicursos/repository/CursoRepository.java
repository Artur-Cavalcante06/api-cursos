package br.edu.nassau.apicursos.repository;

import br.edu.nassau.apicursos.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {

    private final List<Curso> cursos = new ArrayList<>();

    private Long proximoId = 1L;

    public CursoRepository() {
        cursos.add(new Curso(proximoId++, "Java", 40));
        cursos.add(new Curso(proximoId++, "Spring Boot", 60));
        cursos.add(new Curso(proximoId++, "Banco de Dados", 80));
    }

    public List<Curso> listarTodos() {
        return cursos;
    }

    public Curso salvar(Curso curso) {
        curso.setId(proximoId++);
        cursos.add(curso);
        return curso;
    }

    public Curso buscarPorId(Long id) {
        return cursos.stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Curso atualizar(Curso cursoAtualizado) {
        Curso curso = buscarPorId(cursoAtualizado.getId());

        if (curso == null) {
            return null;
        }

        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());

        return curso;
    }

    public boolean excluir(Long id) {
        Curso curso = buscarPorId(id);

        if (curso == null) {
            return false;
        }

        cursos.remove(curso);
        return true;
    }
}