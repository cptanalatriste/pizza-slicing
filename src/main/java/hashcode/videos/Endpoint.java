package hashcode.videos;

public class Endpoint {

	private int id;
	private int datacenterLatency;
	private int cacheConnections;
	private int[] cacheLatency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDatacenterLatency() {
		return datacenterLatency;
	}

	public void setDatacenterLatency(int datacenterLatency) {
		this.datacenterLatency = datacenterLatency;
	}

	public int getCacheConnections() {
		return cacheConnections;
	}

	public void setCacheConnections(int cacheConnections) {
		this.cacheConnections = cacheConnections;
	}

	public int[] getCacheLatency() {
		return cacheLatency;
	}

	public void setCacheLatency(int[] cacheLatency) {
		this.cacheLatency = cacheLatency;
	}

}
