package br.edu.nassau.apicursos.service;

import br.edu.nassau.apicursos.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private final List<Curso> cursos = new ArrayList<>();

    private Long proximoId = 1L;

    public CursoService() {
        cursos.add(new Curso(proximoId++, "Java", 40));
        cursos.add(new Curso(proximoId++, "Spring Boot", 60));
        cursos.add(new Curso(proximoId++, "Banco de Dados", 80));
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso cadastrarCurso(Curso curso) {
        curso.setId(proximoId++);
        cursos.add(curso);
        return curso;
    }
    public Curso buscarCursoPorId(Long id) {
        return cursos.stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {

        Curso curso = buscarCursoPorId(id);

        if (curso == null) {
            return null;
        }

        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());

        return curso;
    }
    public boolean excluirCurso(Long id) {

        Curso curso = buscarCursoPorId(id);

        if (curso == null) {
            return false;
        }

        cursos.remove(curso);
        return true;
    }
}