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
		
		Collections.sort(endpoints, new Comparator<Endpoint>(){

			@Override
			public int compare(Endpoint o1, Endpoint o2) {
				return Integer.compare(o1.potentialSavings(problem), o2.potentialSavings(problem));
			}
		});
		
		VideoSolution solution = new VideoSolution();
		
		List<Integer> videosToAdd = new ArrayList<Integer>();
		for(Endpoint e: endpoints){
			List<VideoRequest> vidRequests = problem.getRequestDescriptions();
			List<VideoRequest> vidRequestsEndpoints = new ArrayList<VideoRequest>();
			for(VideoRequest v : vidRequests){
				if(v.getEndpoint().getId()==e.getId()){
					vidRequestsEndpoints.add(v);
				}
			}
			
			Collections.sort(vidRequestsEndpoints, new Comparator<VideoRequest>(){

				@Override
				public int compare(VideoRequest o1, VideoRequest o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.getQuantity(), o2.getQuantity());
				}
				
			});
			
			Validator validator = new Validator();
			
			
			for(VideoRequest v : vidRequestsEndpoints){
				solution.addVideoToCacheServer(0,v.getId());
				if(!validator.isValid(problem, solution)){
					break;
				} else {
					videosToAdd.add(v.getId());
				}
			}
			
		}
		
		VideoSolution toReturn = new VideoSolution();
		
		for(int i=0; i<problem.getNumberOfCaches();i++){
			for(Integer v: videosToAdd){
				toReturn.addVideoToCacheServer(i, v);
			}
		}
		
		return toReturn;
		
	}

}
