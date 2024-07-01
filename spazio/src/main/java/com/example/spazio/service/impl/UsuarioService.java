package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.UsuarioEntradaDTO;
import com.example.spazio.dto.salidaDTO.UsuarioSalidaDTO;
import com.example.spazio.entity.Lugar;
import com.example.spazio.entity.Usuario;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.repository.UsuarioRepository;
import com.example.spazio.service.iUsuarioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements iUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(LugarService.class);


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, LugarRepository lugarRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioSalidaDTO agregarUsuario(UsuarioEntradaDTO usuarioEntradaDTO) {
        Usuario usuario = modelMapper.map(usuarioEntradaDTO, Usuario.class);
        LOGGER.info("Registrando usuario...");
        usuario.setTipoUsuario("usuario");
        LOGGER.info("Encriptando Contraseña...");
//        usuario.setPassword(bCryptPasswordEncoder.encode(usuarioEntradaDTO.getPassword()));

        Usuario UsuarioGuardado = usuarioRepository.save(usuario);
        LOGGER.info("Usuario guardado correctamente");

        return modelMapper.map(UsuarioGuardado, UsuarioSalidaDTO.class);
    }

    @Override
    public List<UsuarioSalidaDTO> listarUsuarios() {
        LOGGER.info("Listando todos los usuarios");
        List<UsuarioSalidaDTO> usuarios = usuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} usuarios", usuarios.size());
        return usuarios;
    }

    @Override
    public UsuarioSalidaDTO buscarUsuarioPorId(Long id) {
        LOGGER.info("Buscando usuario por ID: {}", id);
        Usuario usuarioBuscado = usuarioRepository.findById(id).orElse(null);
        UsuarioSalidaDTO usuarioSalidaDTO = usuarioBuscado != null ? modelMapper.map(usuarioBuscado, UsuarioSalidaDTO.class) : null;
        LOGGER.info("Usuario encontrado: {}", usuarioSalidaDTO);
        return usuarioSalidaDTO;
    }

    @Override
    public void eliminarUsuario(Long id) {
        LOGGER.info("Eliminando usuario con ID: {}", id);
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuarioRepository.delete(usuario);
            LOGGER.info("Usuario eliminado exitosamente");
        });
    }


    public UsuarioSalidaDTO buscarUsuarioPorEmail(String email) {
        LOGGER.info("Buscando usuario por EMAIL: {}", email);
        Usuario usuarioBuscado = usuarioRepository.findByEmail(email);
        UsuarioSalidaDTO usuarioSalidaDTO = usuarioBuscado != null ? modelMapper.map(usuarioBuscado, UsuarioSalidaDTO.class) : null;
        LOGGER.info("Usuario encontrado: {}", usuarioSalidaDTO);
        return usuarioSalidaDTO;
    }

    @Override
    public UsuarioSalidaDTO agregarLugarFavorito(Long usuarioId, Long lugarId) {
        // Buscar el usuario por ID
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscar el lugar por ID
        Lugar lugar = lugarRepository.findById(lugarId)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        // Verificar si el lugar ya está en la lista de favoritos
        if (usuario.getLugaresFavoritos().contains(lugar)) {
            // Si está en la lista, eliminarlo
            usuario.getLugaresFavoritos().remove(lugar);
            LOGGER.info("Lugar eliminado de favoritos");
        } else {
            // Si no está en la lista, agregarlo
            usuario.getLugaresFavoritos().add(lugar);
            LOGGER.info("Lugar añadido a favoritos");
        }

        // Guardar los cambios en el repositorio
        usuarioRepository.save(usuario);

        // Devolver la representación del usuario con la lista actualizada de favoritos
        return modelMapper.map(usuario, UsuarioSalidaDTO.class);
    }


}
