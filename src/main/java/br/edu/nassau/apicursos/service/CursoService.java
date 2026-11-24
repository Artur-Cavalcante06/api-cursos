
package br.edu.nassau.apicursos.service;

import br.edu.nassau.apicursos.model.Curso;
import br.edu.nassau.apicursos.repository.CursoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private static final Logger logger =
            LoggerFactory.getLogger(CursoService.class);

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        logger.info("Listando cursos cadastrados.");
        return cursoRepository.findAll();
    }

    public Curso cadastrarCurso(Curso curso) {

        validarCurso(curso);

        curso.setId(null);

        Curso salvo = cursoRepository.save(curso);

        logger.info("Curso cadastrado com ID: {}", salvo.getId());

        return salvo;
    }

    public Curso buscarCursoPorId(Long id) {

        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            logger.warn("Curso não encontrado. ID: {}", id);
        }

        return curso;
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {

        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            logger.warn("Curso não encontrado. ID: {}", id);
            return null;
        }

        validarCurso(cursoAtualizado);

        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
        curso.setDescricao(cursoAtualizado.getDescricao());
        curso.setCategoria(cursoAtualizado.getCategoria());

        Curso salvo = cursoRepository.save(curso);

        logger.info("Curso atualizado. ID: {}", id);

        return salvo;
    }

    public boolean excluirCurso(Long id) {

        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            logger.warn("Curso não encontrado. ID: {}", id);
            return false;
        }

        cursoRepository.delete(curso);

        logger.info("Curso excluído. ID: {}", id);

        return true;
    }

    private void validarCurso(Curso curso) {

        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do curso é obrigatório.");
        }

        if (curso.getCargaHoraria() == null
                || curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException(
                    "A carga horária deve ser maior que zero.");
        }
    }
}
