package hashcode.videos;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IStrategy;

public class DummyStrategy implements IStrategy {

	@Override
	public ISolution getSolution(IProblem problem) {
		VideoSolution solution = new VideoSolution();
		solution.addVideoToCacheServer(0, 2);
		solution.addVideoToCacheServer(1, 3);
		solution.addVideoToCacheServer(1, 1);

		solution.addVideoToCacheServer(2, 0);
		solution.addVideoToCacheServer(2, 1);

		return solution;
	}

}
