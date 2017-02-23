package hashcode.videos;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IValidator;

public class Validator implements IValidator {

	@Override
	public boolean isValid(IProblem problem, ISolution solution) {
		int maxCacheSize = problem.getCacheSize();

		System.out.println("maxCacheSize=" + maxCacheSize);
		System.out.println("solution.getNumCacheServers()=" + solution.getNumCacheServers());

		for (int i = 0; i < solution.getNumCacheServers(); i++) {
			System.out.println("Current Server: " + i);

			int sizeUsed = 0;
			for (int vid : solution.getVideosForCacheServer(i)) {
				int videoSize = problem.getVideoSize(vid);
				System.out.println("Video Size for video " + vid + ": " + videoSize);

				sizeUsed += videoSize;

				System.out.println("sizeUsed=" + sizeUsed);
				if (sizeUsed > maxCacheSize) {
					return false;
				}
			}
		}
		return true;
	}

}
