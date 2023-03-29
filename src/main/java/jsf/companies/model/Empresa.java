package jsf.companies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import jsf.companies.types.TipoEmpresa;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;

    @NotBlank
    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;

    @NotBlank
    @Column(nullable = false, length = 30)
    private String cnpj;

    @NotBlank
    @Past
    @Column(name = "data_fundacao")
    @Temporal(TemporalType.DATE)
    private Date dataFundacao;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id", nullable = false)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoEmpresa tipo;

    @NotBlank
    @Column(precision = 10, scale = 2)
    private BigDecimal faturamento;

    public Long getId() {
	return id;
    }

    public BigDecimal getFaturamento() {
	return faturamento;
    }

    public void setFaturamento(BigDecimal faturamento) {
	this.faturamento = faturamento;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNomeFantasia() {
	return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
	this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
	return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
	this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
	return cnpj;
    }

    public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
    }

    public TipoEmpresa getTipo() {
	return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
	this.tipo = tipo;
    }

    public Date getDataFundacao() {
	return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
	this.dataFundacao = dataFundacao;
    }

    public RamoAtividade getRamoAtividade() {
	return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
	this.ramoAtividade = ramoAtividade;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Empresa other = (Empresa) obj;
	return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	return "Empresa [id=" + id + ", nomeFantasia=" + nomeFantasia
		+ ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
		+ ", dataFundacao=" + dataFundacao
		+ ", ramoAtividade=" + ramoAtividade + "]";
    }

}
