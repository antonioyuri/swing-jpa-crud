package br.com.yaw.sjpac.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Classe de modelo que representa uma mercadoria. A mercadoria é um objeto persistido no banco de dados, por isso utilizamos a classificamos como <strong>Entidade</strong>.
 * 
 * <p>As funcionalidades desse sistema demonstração são concentradas no cadastro (CRUD) de mercadorias.</p>  
 * 
 * @author YaW Tecnologia
 */
@Entity
@Table(name="mercadoria")
public class Mercadoria implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	
	/** Atributo utilizado para controle <code>lock</code> (otimista) da <code>JPA</code> para cada registro (objeto) Mercadoria. */
	@Version
	private Integer version;
	
	private static final NumberFormat numberFmt = NumberFormat.getNumberInstance(new Locale("pt","BR"));
	
	public Mercadoria(){
	}
	
	public Mercadoria(Integer id, String nome, String descricao, Integer quantidade, Double preco, Integer version) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.version = version;
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getPrecoFormatado() {
		return convertPrecoToString(this.preco);
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public static String convertPrecoToString(double preco) {
		return numberFmt.format(preco);
	}
	
	public static double formatStringToPreco(String strPreco) throws ParseException {
		 return numberFmt.parse(strPreco).doubleValue();
	}
	
	@Override
	public String toString() {
		return "[ " + nome + " - " + descricao + " - " + quantidade + " - " + preco + " ]";
	}
	
}
