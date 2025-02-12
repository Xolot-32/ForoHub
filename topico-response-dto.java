package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record TopicoResponseDTO(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaCreacion,
    StatusTopico status,
    String autor,
    String curso
) {
    public TopicoResponseDTO(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getStatus(),
            topico.getAutor().getNombre(),
            topico.getCurso().getNombre()
        );
    }
}
