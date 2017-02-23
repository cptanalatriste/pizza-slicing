package hashcode.videos;

import java.util.Arrays;

public class Endpoint {

	private int id;
	private int datacenterLatency;
	private int cacheConnections;
	private int[] cacheLatency;

	public Endpoint(int numberOfCaches) {
		this.cacheLatency = new int[numberOfCaches];
	}

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

	@Override
	public String toString() {
		return "Endpoint [id=" + id + ", datacenterLatency=" + datacenterLatency + ", cacheConnections="
				+ cacheConnections + ", cacheLatency=" + Arrays.toString(cacheLatency) + "]";
	}

}
