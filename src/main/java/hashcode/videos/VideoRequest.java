package hashcode.videos;

public class VideoRequest {
	private int id;
	private Video video;
	private Endpoint endpoint;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video instance) {
		this.video = instance;
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "VideoRequest [id=" + id + ", video=" + video + ", endpoint=" + endpoint + ", quantity=" + quantity
				+ "]";
	}

}
