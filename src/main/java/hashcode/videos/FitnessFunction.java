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
		return 0.0;
	}
	
	private Double score(IProblem problem, ISolution solution){
		Double toReturn = 0.0;
		
		List<Endpoint> endpoints = problem.getEndpoints();
		for(VideoRequest vidReq: problem.getRequestDescriptions()){
			int serverLatency = vidReq.getEndpoint().getDatacenterLatency();
			int minLatency = serverLatency;;
			int cacheConnections = vidReq.getEndpoint().getCacheConnections();
			for(int i=0; i<cacheConnections; i++){
				if(solution.getVideosForCacheServer(i).contains(vidReq.getVideo().getId())){
					if(vidReq.getEndpoint().getCacheLatency()[i] < minLatency){
						minLatency = vidReq.getEndpoint().getCacheLatency()[i];
					}
				}
			}
			
		}
		
		for(Endpoint point: endpoints){
			int serverLatency = point.getDatacenterLatency();
			int[] endpointLatency = point.getCacheLatency();
			
		}
		
		
		return 0.0; //Placeholder
	}

}
