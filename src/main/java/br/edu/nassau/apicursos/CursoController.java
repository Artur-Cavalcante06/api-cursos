package br.edu.nassau.apicursos;

import br.edu.nassau.apicursos.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id) {

        Curso curso = cursoService.buscarCursoPorId(id);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(curso);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {

        Curso novoCurso = cursoService.cadastrarCurso(curso);

        return ResponseEntity.status(201).body(novoCurso);
    }
    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> atualizarCurso(
            @PathVariable Long id,
            @RequestBody Curso cursoAtualizado) {

        Curso curso = cursoService.atualizarCurso(id, cursoAtualizado);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(curso);
    }
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable Long id) {

        boolean excluido = cursoService.excluirCurso(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}