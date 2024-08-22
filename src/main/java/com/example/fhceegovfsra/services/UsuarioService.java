package com.example.fhceegovfsra.services;

import com.example.fhceegovfsra.daos.UsuarioDAO;
import com.example.fhceegovfsra.models.Usuario;
import com.example.fhceegovfsra.objects.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        return convertirAObj(usuarioDAO.save(convertirAModel(usuarioDTO)));
    }

    public List<UsuarioDTO> listar() {
        return usuarioDAO.findAll().stream().map(this::convertirAObj).collect(Collectors.toList());
    }

    private UsuarioDTO convertirAObj(Usuario usuario) {
        return new UsuarioDTO(usuario.getId_usuario(), usuario.getCif());
    }

    private Usuario convertirAModel(UsuarioDTO usuario) {
        return new Usuario(usuario.getId_usuario(), usuario.getCif());
    }
}
