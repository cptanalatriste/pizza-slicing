package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import hashcode.videos.Endpoint;
import hashcode.videos.Video;
import hashcode.videos.VideoRequest;

public interface IProblem {
	public void readFile(File f) throws FileNotFoundException, IOException;

	public int getCacheSize();

	public int getVideoSize(int videoId);

	public List<Endpoint> getEndpoints();

	public int getNumberOfVideos();

	public List<Video> getVideos();

	public List<VideoRequest> getRequestDescriptions();

	public int getNumberOfCaches();

	public int getTotalNumberRequest(int endpointId);
}
