package br.com.vulpicula.Projeto.Ekan.controllers;

import br.com.vulpicula.Projeto.Ekan.models.Usuario;
import br.com.vulpicula.Projeto.Ekan.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findByEmail(usuario.getEmail());
        if (existingUsuario != null && existingUsuario.getSenha().equals(usuario.getSenha())) {
            return "Login bem sucedido!";
        } else {
            return "Falha no login!";
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    // outros endpoints conforme necessário
}
