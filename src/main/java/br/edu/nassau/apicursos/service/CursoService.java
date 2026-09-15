package br.edu.nassau.apicursos.service;

import br.edu.nassau.apicursos.Curso;
import br.edu.nassau.apicursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.listarTodos();
    }

    public Curso cadastrarCurso(Curso curso) {
        curso.setId(null);
        return cursoRepository.salvar(curso);
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.buscarPorId(id);
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Curso curso = cursoRepository.buscarPorId(id);

        if (curso == null) {
            return null;
        }

        cursoAtualizado.setId(id);

        return cursoRepository.atualizar(cursoAtualizado);
    }

    public boolean excluirCurso(Long id) {
        return cursoRepository.excluir(id);
    }
}