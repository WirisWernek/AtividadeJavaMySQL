package Models;

public class TagPorVideo {

	private int id;
	private int idVideo;
	private int idTag;
	private Video video;
	private Tag tag;

	public TagPorVideo( int id, int idVideo, String urlVideo, String descricaoVideo, int diaVideo, int mesVideo, int anoVideo, int idTag, String descricaoTag ) {
		this.id = id;
		this.idVideo = idVideo;
		this.idTag = idTag;
		this.video.setId( idVideo );
		this.video.setUrl( urlVideo );
		this.video.setDescricao( descricaoVideo );
		this.video.setDia( diaVideo );
		this.video.setMes( mesVideo );
		this.video.setAno( anoVideo );
		this.tag.setId( idTag );
		this.tag.setDescricao( descricaoTag );
	}

	public TagPorVideo() {
		video = new Video();
		tag = new Tag();
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getIdVideo() {
		return idVideo;
	}

	public void setIdVideo( int idVideo ) {
		this.idVideo = idVideo;
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag( int idTag ) {
		this.idTag = idTag;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo( Video video ) {
		this.video = video;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag( Tag tag ) {
		this.tag = tag;
	}

}
