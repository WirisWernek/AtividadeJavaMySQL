package Models;

public class TagPorVideo {

	private int id;
	private Video video;
	private Tag tag;

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
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
