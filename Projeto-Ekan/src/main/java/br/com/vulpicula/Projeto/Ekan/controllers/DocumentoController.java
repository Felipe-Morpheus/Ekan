package br.com.vulpicula.Projeto.Ekan.controllers;

import br.com.vulpicula.Projeto.Ekan.models.Documento;
import br.com.vulpicula.Projeto.Ekan.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    // CREATE
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Documento> criarDocumento(@RequestBody Documento documento) {
        Documento savedDocumento = documentoService.criarDocumento(documento);
        return new ResponseEntity<>(savedDocumento, HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/")
    public ResponseEntity<List<Documento>> listarTodosDocumentos() {
        List<Documento> documentos = documentoService.listarTodosDocumentos();
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> listarDocumentoPorId(@PathVariable Long id) {
        Documento documento = documentoService.listarDocumentoPorId(id);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Documento> atualizarDocumento(@PathVariable Long id, @RequestBody Documento documentoDetails) {
        Documento updatedDocumento = documentoService.atualizarDocumento(id, documentoDetails);
        return new ResponseEntity<>(updatedDocumento, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarDocumento(@PathVariable Long id) {
        documentoService.deletarDocumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
