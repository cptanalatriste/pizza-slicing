package hashcode.videos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hashcode.mainevent.IProblem;

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

	public List<VideoRequest> getVideoRequests(IProblem problem) {
		List<VideoRequest> thisEndpointRequests = new ArrayList<VideoRequest>();
		List<VideoRequest> vidRequests = problem.getRequestDescriptions();

		for (VideoRequest videoRequest : vidRequests) {
			if (videoRequest.getEndpoint().getId() == this.getId()) {
				thisEndpointRequests.add(videoRequest);
			}
		}

		return thisEndpointRequests;
	}

	public int potentialSavings(IProblem problem) {
		int dataCenterLatency = this.getDatacenterLatency();
		int currentBest = dataCenterLatency;
		for (int i = 0; i < getCacheLatency().length; i++) {
			if (getCacheLatency()[i] != 0) {
				if (currentBest > getCacheLatency()[i]) {
					currentBest = getCacheLatency()[i];
				}
			}
		}
		return problem.getTotalNumberRequest(this.id) * (dataCenterLatency - currentBest);
	}

	@Override
	public String toString() {
		return "Endpoint [id=" + id + ", datacenterLatency=" + datacenterLatency + ", cacheConnections="
				+ cacheConnections + ", cacheLatency=" + Arrays.toString(cacheLatency) + "]";
	}

}
