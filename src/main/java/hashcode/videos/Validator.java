package hashcode.videos;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IValidator;

public class Validator implements IValidator {

	@Override
	public boolean isValid(IProblem problem, ISolution solution) {
		int maxCacheSize = problem.getCacheSize();

		for (int i = 0; i < solution.getNumCacheServers(); i++) {

			int sizeUsed = 0;
			for (int vid : solution.getVideosForCacheServer(i)) {
				int videoSize = problem.getVideoSize(vid);

				sizeUsed += videoSize;

				if (sizeUsed > maxCacheSize) {
					return false;
				}
			}
		}
		return true;
	}

}
