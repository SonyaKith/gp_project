package gp_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;
import java.util.List;

public class GPDriver {

	public static void main(String[] Args) {
		
	
		Population pop = new Population();
		pop.generateFirstPopulation();
		
		FunctionEvaluator fEval = new FunctionEvaluator();
		FunctionModifier modifier = new FunctionModifier();
		
		int numGenerations = 0;
		
		boolean keepGoing = fEval.evaluatePop(pop);
		while(keepGoing && numGenerations < 500)
		{
			modifier.mutatePop(pop);
			modifier.crossoverPop(pop);
			pop.regenerate();
			numGenerations ++;
			keepGoing = fEval.evaluatePop(pop);
			pop.pruneLowFitnessTrees();
		}
	
		//Print out the winning tree
		
		System.out.println("Winning tree fitness value:" + fEval.getBestFitness());
		Tree best = fEval.getBestTree();		
		TreePrinter printer = new TreePrinter();
		printer.printNode(best.getRootNode());
		
		
	}

}
