package hashcode.videos;

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

}
