package com.example.fhceegovfsra.services;

import com.example.fhceegovfsra.daos.TipoDAO;
import com.example.fhceegovfsra.models.Tipo;
import com.example.fhceegovfsra.objects.TipoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoService {
    private final TipoDAO tipoDAO;

    public TipoService(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public TipoDTO agregarTipo(TipoDTO tipoDTO) {
        return convertirAObj(tipoDAO.save(convertirAModel(tipoDTO)));
    }

    public List<TipoDTO> listar() {
        return tipoDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
    }

    private TipoDTO convertirAObj(Tipo tipo) {
        return new TipoDTO(tipo.getId_tipo(), tipo.getTipo());
    }

    private Tipo convertirAModel(TipoDTO tipo) {
        return new Tipo(tipo.getId_tipo(), tipo.getTipo());
    }
}
