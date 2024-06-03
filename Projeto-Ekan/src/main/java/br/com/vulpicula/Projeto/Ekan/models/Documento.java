package br.com.vulpicula.Projeto.Ekan.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DOCUMENTO")
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDocumento;

    @ManyToOne
    @JoinColumn(name="beneficiario_id", nullable=false)
    private Beneficiario beneficiario;

    private String tipoDocumento;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;



    public Documento() {
    }

    public Documento(Long idDocumento, Beneficiario beneficiario, String tipoDocumento, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
        this.idDocumento = idDocumento;
        this.beneficiario = beneficiario;
        this.tipoDocumento = tipoDocumento;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
    }


    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
