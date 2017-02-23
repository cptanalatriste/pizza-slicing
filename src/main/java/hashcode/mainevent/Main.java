package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import hashcode.pizza.domain.Pizza;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		for(String f : args){
			IProblem problem = null;
			problem.readFile(new File(f));
		
			
			IStrategy strategy = null;
			ISolution solution  = strategy.getSolution(problem);
			
			AFitnessFunction fitnessFunction = null;
			Optional<Double> fitness = fitnessFunction.getFitness(problem, solution);
			
			if(fitness.isPresent()){
				System.out.println("Fitness :" + fitness.get());
				solution.toFile(new File(f+"_result"));
			} else {
				//TODO
			}
		}
	}

}
