package br.com.vulpicula.Projeto.Ekan.repositories;

import br.com.vulpicula.Projeto.Ekan.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

}
