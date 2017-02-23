package hashcode.mainevent;

import java.util.Optional;

public abstract class AFitnessFunction {
	private final IValidator validator;

	public AFitnessFunction(IValidator v) {
		this.validator = v;
	}

	// If invalid Optional is empty, otherwise, run getValidFitness(IProblem,
	// ISolution)
	public Optional<Double> getFitness(IProblem problem, ISolution solution) {
		if (!this.validator.isValid(problem, solution)) {
			return Optional.empty();
		}

		return Optional.of(this.getValidFitness(problem, solution));
	}

	abstract protected Double getValidFitness(IProblem problem, ISolution solution);
}
