package org.jcb.dojo.dominio;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Imovel")
public class Imovel {

	@Id
	@GeneratedValue(generator = "imovel_seq")
	@SequenceGenerator(name = "imovel_seq", sequenceName = "IMOVEL_SEQ")
	private Long id;

	@Column(name = "ImoLatitude", nullable = false, scale = 2, precision = 20)
	private Double lat;

	@Column(name = "ImoLongitude", nullable = false, scale = 2, precision = 20)
	private Double longi;

	@OneToOne
	private Endereco endereco;

	private BigDecimal valor;

	private String descricao;
	
	@OneToMany(mappedBy="imovel")
	List<Contrato> contratos;

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongi() {
		return longi;
	}

	public void setLongi(Double longi) {
		this.longi = longi;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", lat=" + lat + ", longi=" + longi + ", endereco=" + endereco + ", valor=" + valor
				+ ", descricao=" + descricao + "]\n";
	}

}
