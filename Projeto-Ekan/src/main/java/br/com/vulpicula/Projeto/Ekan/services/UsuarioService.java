package br.com.vulpicula.Projeto.Ekan.services;

import br.com.vulpicula.Projeto.Ekan.models.Usuario;
import br.com.vulpicula.Projeto.Ekan.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    // outros métodos conforme necessário
}
