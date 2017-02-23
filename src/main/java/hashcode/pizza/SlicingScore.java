package hashcode.pizza;

import hashcode.mainevent.AFitnessFunction;
import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;

public class SlicingScore extends AFitnessFunction {

	public SlicingScore() {
		super(new SlicingValidator());
	}

	@Override
	protected Double getValidFitness(IProblem problem, ISolution solution) {
		// TODO(cgavidia): Implement later
		return 0.0;
	}

}
