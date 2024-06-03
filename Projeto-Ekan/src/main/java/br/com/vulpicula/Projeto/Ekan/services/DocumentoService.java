package br.com.vulpicula.Projeto.Ekan.services;

import br.com.vulpicula.Projeto.Ekan.models.Beneficiario;
import br.com.vulpicula.Projeto.Ekan.models.Documento;
import br.com.vulpicula.Projeto.Ekan.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> listarTodosDocumentos(){
        return documentoRepository.findAll();
    }
    public Documento listarDocumentoPorId(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    public Documento criarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    // UPDATE
    public Documento atualizarDocumento(Long id, Documento documentoDetails) {
        Documento documento = listarDocumentoPorId(id);
        if (documento != null) {
            documento.setIdDocumento(documentoDetails.getIdDocumento());
            documento.setTipoDocumento(documentoDetails.getTipoDocumento());
            documento.setDataAtualizacao(documentoDetails.getDataAtualizacao());
            documento.setDataInclusao(documentoDetails.getDataInclusao());
            documento.setBeneficiario(documentoDetails.getBeneficiario());
            return documentoRepository.save(documento);
        }
        return null;
    }


    public void deletarDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}