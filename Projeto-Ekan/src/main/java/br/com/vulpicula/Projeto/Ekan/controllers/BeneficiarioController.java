package br.com.vulpicula.Projeto.Ekan.controllers;

import br.com.vulpicula.Projeto.Ekan.models.Beneficiario;
import br.com.vulpicula.Projeto.Ekan.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    // CREATE
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Beneficiario> criarBeneficiario(@RequestBody Beneficiario beneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.criarBeneficiario(beneficiario);
        return new ResponseEntity<>(savedBeneficiario, HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/")
    public ResponseEntity<List<Beneficiario>> listarTodosBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioService.listarTodosBeneficiarios();
        return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> listarBeneficiarioPorId(@PathVariable Long id) {
        Beneficiario beneficiario = beneficiarioService.listarBeneficiarioPorId(id);
        return new ResponseEntity<>(beneficiario, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiarioDetails) {
        Beneficiario updatedBeneficiario = beneficiarioService.atualizarBeneficiario(id, beneficiarioDetails);
        return new ResponseEntity<>(updatedBeneficiario, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
