package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public interface ISolution {
	public void toFile(File toWrite) throws FileNotFoundException;
	public Set<Integer> getVideosForCacheServer(int id);
	public int getNumCacheServers();
	public void addVideoToCacheServer(int cacheServerId, int videoId);
}
