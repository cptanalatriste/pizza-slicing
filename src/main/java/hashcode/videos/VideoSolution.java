package hashcode.videos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import hashcode.mainevent.ISolution;

public class VideoSolution implements ISolution {
	final private Map<Integer, Set<Integer>> cacheServerData = new HashMap<Integer, Set<Integer>>();

	public VideoSolution(){
		//Starts off empty.
	}
	
	public void addVideoToCacheServer(int serverId, int videoId){
		assert(serverId>=0);
		assert(videoId>=0);
		if(!cacheServerData.containsKey(serverId)){
			cacheServerData.put(serverId, new HashSet<Integer>());
		}
		
		cacheServerData.get(serverId).add(videoId);
	}
	
	@Override
	public void toFile(File toWrite) throws FileNotFoundException {
		String toBeWritten = Integer.toString(this.getNumCacheServers());
		for(int i=0; i<this.getNumCacheServers(); i++){
			toBeWritten += System.lineSeparator();
			toBeWritten += i;
			for(int vid : this.cacheServerData.get(i)){
				toBeWritten += " "+vid;
			}
		}
		
		try (PrintWriter writer = new PrintWriter(toWrite)) {
			writer.print(toBeWritten);
			writer.close();
		}
	}

	@Override
	public Set<Integer> getVideosForCacheServer(int id) {
		return this.cacheServerData.get(id);
	}

	@Override
	public int getNumCacheServers() {
		return this.cacheServerData.size();
	}

}
