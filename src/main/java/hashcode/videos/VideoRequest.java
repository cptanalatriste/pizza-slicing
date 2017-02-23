package hashcode.videos;

public class VideoRequest {
	private int id;
	private Video instance;
	private Endpoint endpoint;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Video getInstance() {
		return instance;
	}

	public void setInstance(Video instance) {
		this.instance = instance;
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

}
