package Models;

import java.util.List;

public class Video {

	private int id;
	private String url;
	private String descricao;
	private int dia;
	private int mes;
	private int ano;
	private List<Tag> tags;

	public Video( int id, String url, String descricao, int dia, int mes, int ano ) {
		this.id = id;
		this.url = url;
		this.descricao = descricao;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Video() {}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public int getDia() {
		return dia;
	}

	public void setDia( int dia ) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes( int mes ) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno( int ano ) {
		this.ano = ano;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags( List<Tag> tags ) {
		this.tags = tags;
	}

	public String getDate() {
		return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
	}
}
