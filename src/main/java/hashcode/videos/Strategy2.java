package hashcode.videos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IStrategy;

public class Strategy2 implements IStrategy {

	@Override
	public ISolution getSolution(final IProblem problem) {
		List<Endpoint> endpoints = problem.getEndpoints();

		Collections.sort(endpoints, new Comparator<Endpoint>() {

			@Override
			public int compare(Endpoint o1, Endpoint o2) {
				return Integer.compare(o2.potentialSavings(problem), o1.potentialSavings(problem));
			}
		});

		VideoSolution solution = new VideoSolution();

		List<Integer> videosToAdd = new ArrayList<Integer>();
		for (Endpoint endpoint : endpoints) {
			List<VideoRequest> thisEndpointRequests = endpoint.getVideoRequests(problem);

			Collections.sort(thisEndpointRequests, new Comparator<VideoRequest>() {
				@Override
				public int compare(VideoRequest o1, VideoRequest o2) {
					return Integer.compare(o2.getQuantity(), o1.getQuantity());
				}

			});

			Validator validator = new Validator();

			for (VideoRequest videoRequest : thisEndpointRequests) {
				int videoId = videoRequest.getVideo().getId();
				solution.addVideoToCacheServer(0, videoId);
				if (!validator.isValid(problem, solution)) {
					break;
				} else {
					videosToAdd.add(videoId);
				}
				// break;
			}

		}

		VideoSolution toReturn = new VideoSolution();

		for (int cacheId = 0; cacheId < problem.getNumberOfCaches(); cacheId++) {
			for (Integer videoId : videosToAdd) {
				toReturn.addVideoToCacheServer(cacheId, videoId);
			}
		}

		return toReturn;

	}

}
