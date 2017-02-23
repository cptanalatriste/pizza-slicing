package hashcode.videos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import hashcode.mainevent.IProblem;

public class VideoCaching implements IProblem {

	private int numberOfVideos;
	private int numberOfEndpoints;
	private int numberOfRequests;
	private int numberOfCaches;
	private int cacheSize;

	private List<Endpoint> endpoints;

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

	@Override
	public void readFile(File inputFile) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			int lineCounter = 0;
			while ((line = reader.readLine()) != null) {
				if (lineCounter == 0) {
					String[] characters = line.split("\\s+");
					this.setNumberOfVideos(Integer.parseInt(characters[0]));
					this.setNumberOfEndpoints(Integer.parseInt(characters[1]));
					this.setNumberOfEndpoints(Integer.parseInt(characters[1]));

				}
			}

		}

	}

}
