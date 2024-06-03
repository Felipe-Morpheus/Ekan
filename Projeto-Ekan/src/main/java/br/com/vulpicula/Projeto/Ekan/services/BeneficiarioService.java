package br.com.vulpicula.Projeto.Ekan.services;

import br.com.vulpicula.Projeto.Ekan.models.Beneficiario;
import br.com.vulpicula.Projeto.Ekan.repositories.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    // CREATE
    public Beneficiario criarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    // READ
    public List<Beneficiario> listarTodosBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario listarBeneficiarioPorId(Long id) {
        return beneficiarioRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Beneficiario atualizarBeneficiario(Long id, Beneficiario beneficiarioDetails) {
        Beneficiario beneficiario = listarBeneficiarioPorId(id);
        if (beneficiario != null) {
            beneficiario.setNome(beneficiarioDetails.getNome());
            beneficiario.setTelefone(beneficiarioDetails.getTelefone());
            beneficiario.setDataNascimento(beneficiarioDetails.getDataNascimento());
            beneficiario.setDataAtualizacao(LocalDateTime.now());
            return beneficiarioRepository.save(beneficiario);
        }
        return null;
    }

    // DELETE
    public void deletarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
