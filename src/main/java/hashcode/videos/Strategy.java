package hashcode.videos;

import java.util.List;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IStrategy;

public class Strategy implements IStrategy {

	@Override
	public ISolution getSolution(final IProblem problem) {
		VideoSolution toReturn = new VideoSolution();

		for (Video vid : problem.getVideos()) {
			int sum = 0;
			for (VideoRequest req : problem.getRequestDescriptions()) {
				if (req.getVideo().getId() == vid.getId()) {
					sum += req.getQuantity();
				}
			}
			vid.setRequest(sum);
		}

		List<Video> vidList = problem.getVideos();

		for (int cacheID = 0; cacheID < problem.getNumberOfCaches(); cacheID++) {
			int capacity = problem.getCacheSize();
			for (Video vid : vidList) {
				if (vid.getSize() <= capacity) {
					toReturn.addVideoToCacheServer(cacheID, vid.getId());
					capacity -= vid.getSize();
				} else {
					break;
				}
			}
		}

		return toReturn;
	}

}
