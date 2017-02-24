package hashcode.videos;

import java.util.List;

import hashcode.mainevent.AFitnessFunction;
import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IValidator;

public class FitnessFunction extends AFitnessFunction {

	public FitnessFunction(IValidator v) {
		super(v);
	}

	@Override
	protected Double getValidFitness(IProblem problem, ISolution solution) {
		// TODO: Use this
		Double totalSavings = 0.0;

		List<Endpoint> endpoints = problem.getEndpoints();
		int totalRequests = 0;

		for (Endpoint endpoint : endpoints) {
			int serverLatency = endpoint.getDatacenterLatency();
			int[] cacheLatencies = endpoint.getCacheLatency();
			int cacheConnections = endpoint.getCacheConnections();

			for (VideoRequest videoRequest : endpoint.getVideoRequests(problem)) {

				int minLatency = serverLatency;
				for (int cacheId = 0; cacheId < cacheConnections; cacheId++) {
					int cacheLatency = cacheLatencies[cacheId];

					if (cacheLatency != 0
							&& solution.getVideosForCacheServer(cacheId).contains(videoRequest.getVideo().getId())) {
						if (cacheLatency < minLatency) {
							minLatency = cacheLatency;
						}
					}
				}

				totalSavings += videoRequest.getQuantity() * (serverLatency - minLatency);
				totalRequests += videoRequest.getQuantity();
			}

		}

		return Math.floor(totalSavings * 1000 / totalRequests);
	}

}
