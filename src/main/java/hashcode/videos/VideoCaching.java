package hashcode.videos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hashcode.mainevent.IProblem;

public class VideoCaching implements IProblem {

	private int numberOfVideos;
	private int numberOfEndpoints;
	private int numberOfRequests;
	private int numberOfCaches;
	private int cacheSize;

	private List<Endpoint> endpoints = new ArrayList<>();
	private List<Video> videos = new ArrayList<>();
	private List<VideoRequest> requestDescriptions = new ArrayList<>();

	public int getNumberOfVideos() {
		return numberOfVideos;
	}

	public void setNumberOfVideos(int numberOfVideos) {
		this.numberOfVideos = numberOfVideos;
	}

	public int getNumberOfEndpoints() {
		return numberOfEndpoints;
	}

	public void setNumberOfEndpoints(int numberOfEndpoints) {
		this.numberOfEndpoints = numberOfEndpoints;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}

	public int getNumberOfCaches() {
		return numberOfCaches;
	}

	public void setNumberOfCaches(int numberOfCaches) {
		this.numberOfCaches = numberOfCaches;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<VideoRequest> getRequestDescriptions() {
		return requestDescriptions;
	}

	public void setRequestDescriptions(List<VideoRequest> requestDescriptions) {
		this.requestDescriptions = requestDescriptions;
	}

	@Override
	public void readFile(File inputFile) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			int lineCounter = 0;

			int endpointSectionStart = 2;
			int endpointIdentifier = 0;
			int currentCacheLatency = -1;
			int cacheCounter = 0;
			Endpoint currentEndpoint = null;

			int requestSectionStart = -1;
			int requestIdentifier = 0;

			while ((line = reader.readLine()) != null) {
				if (lineCounter == 0) {
					String[] characters = line.split("\\s+");

					this.setNumberOfVideos(Integer.parseInt(characters[0]));
					this.setNumberOfEndpoints(Integer.parseInt(characters[1]));
					this.setNumberOfRequests(Integer.parseInt(characters[2]));
					this.setNumberOfCaches(Integer.parseInt(characters[3]));
					this.setCacheSize(Integer.parseInt(characters[4]));
				} else if (lineCounter == 1) {
					String[] videoSizes = line.split("\\s+");

					for (int videoId = 0; videoId < videoSizes.length; videoId += 1) {
						Video video = new Video();
						video.setId(videoId);
						video.setSize(Integer.parseInt(videoSizes[videoId]));

						this.videos.add(video);
					}
				} else if (lineCounter == endpointSectionStart) {
					String[] endpointInfo = line.split("\\s+");
					currentEndpoint = new Endpoint(this.getNumberOfCaches());
					currentEndpoint.setId(endpointIdentifier);
					currentEndpoint.setDatacenterLatency(Integer.parseInt(endpointInfo[0]));
					currentEndpoint.setCacheConnections(Integer.parseInt(endpointInfo[1]));

					endpoints.add(currentEndpoint);

					if (endpoints.size() < this.getNumberOfEndpoints()) {
						endpointIdentifier += 1;
						endpointSectionStart += currentEndpoint.getCacheConnections() + 1;
						currentCacheLatency = lineCounter + 1;
					} else {
						requestSectionStart = endpointSectionStart + currentEndpoint.getCacheConnections() + 1;
					}
				} else if (currentCacheLatency > 0 && lineCounter == currentCacheLatency) {
					String[] cacheInfo = line.split("\\s+");
					int cacheId = Integer.parseInt(cacheInfo[0]);
					int cacheLatency = Integer.parseInt(cacheInfo[1]);

					currentEndpoint.getCacheLatency()[cacheId] = cacheLatency;
					cacheCounter += 1;

					if (currentEndpoint.getCacheConnections() == cacheCounter) {
						currentCacheLatency = -1;
						cacheCounter = 0;
					} else {
						currentCacheLatency += 1;
					}

				} else if (requestSectionStart >= 0 && lineCounter >= requestSectionStart) {

					String[] requestInfo = line.split("\\s+");

					VideoRequest request = new VideoRequest();
					request.setId(requestIdentifier);
					request.setVideo(this.getVideos().get(Integer.parseInt(requestInfo[0])));
					request.setEndpoint(this.getEndpoints().get(Integer.parseInt(requestInfo[1])));
					request.setQuantity(Integer.parseInt(requestInfo[2]));

					this.requestDescriptions.add(request);
					requestIdentifier += 1;
				}

				lineCounter += 1;
			}

		}
	}

	@Override
	public String toString() {
		return "VideoCaching [numberOfVideos=" + numberOfVideos + ", numberOfEndpoints=" + numberOfEndpoints
				+ ", numberOfRequests=" + numberOfRequests + ", numberOfCaches=" + numberOfCaches + ", cacheSize="
				+ cacheSize + ", endpoints=" + endpoints + ", videos=" + videos + ", requestDescriptions="
				+ requestDescriptions + "]";
	}

	@Override
	public int getVideoSize(int videoId) {
		for (Video video : this.videos) {
			if (video.getId() == videoId) {
				return video.getSize();
			}
		}

		return -1;
	}

	@Override
	public int getTotalNumberRequest(int endpointId) {

		int numberOfRequests = 0;

		for (VideoRequest request : this.requestDescriptions) {
			if (request.getEndpoint().getId() == endpointId) {
				numberOfRequests += request.getQuantity();
			}
		}

		return numberOfRequests;
	}

}
