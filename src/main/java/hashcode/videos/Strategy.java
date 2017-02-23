package hashcode.videos;

import java.util.Collections;
import java.util.Comparator;
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
		Collections.sort(vidList, new Comparator<Video>() {

			@Override
			public int compare(Video o1, Video o2) {
				return Integer.compare(o2.getRequests(), o1.getRequests());
			}
		});

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
