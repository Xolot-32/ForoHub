package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponseDTO> registrar(@RequestBody @Valid TopicoDTO topicoDTO, UriComponentsBuilder uriBuilder) {
        if (topicoRepository.existsByTituloAndMensaje(topicoDTO.titulo(), topicoDTO.mensaje())) {
            return ResponseEntity.badRequest().build();
        }

        Topico topico = new Topico();
        // Aquí deberías mapear los datos del DTO a la entidad Topico
        // También deberías obtener el autor y el curso de sus respectivos repositorios

        Topico topicoGuardado = topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoGuardado.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoResponseDTO(topicoGuardado));
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> listar() {
        List<TopicoResponseDTO> topicos = topicoRepository.findAll().stream().map(TopicoResponseDTO::new).toList();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detallar(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TopicoResponseDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoResponseDTO> actualizar(@PathVariable Long id, @RequestBody @Valid TopicoDTO topicoDTO) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }

        // Aquí deberías actualizar los datos del tópico con los del DTO
        // También deberías verificar si el nuevo título y mensaje no están duplicados

        return ResponseEntity.ok(new TopicoResponseDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }

        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
