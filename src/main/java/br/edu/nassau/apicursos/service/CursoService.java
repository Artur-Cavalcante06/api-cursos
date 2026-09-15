package br.edu.nassau.apicursos.service;

import br.edu.nassau.apicursos.model.Curso;
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
        return cursoRepository.findAll();
    }

    public Curso cadastrarCurso(Curso curso) {

        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do curso é obrigatório.");
        }

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        }

        curso.setId(null);

        return cursoRepository.save(curso);
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {

        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            return null;
        }

        if (cursoAtualizado.getNome() == null || cursoAtualizado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do curso é obrigatório.");
        }

        if (cursoAtualizado.getCargaHoraria() == null || cursoAtualizado.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        }

        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());

        return cursoRepository.save(curso);
    }

    public boolean excluirCurso(Long id) {

        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            return false;
        }

        cursoRepository.delete(curso);

        return true;
    }
}