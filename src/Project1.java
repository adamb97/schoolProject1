// Project: Project 1
// Author: Adam Benalayat
// Date: 6/30/20
// Description: A basic java program that reads an input from a file of weights and calculates the maximum, minimum, and average of the weights listed

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Project1 {

	public static void main(String[] args) throws FileNotFoundException {
	
		JFileChooser j = new JFileChooser();
		j.showSaveDialog(null);
		File f = j.getSelectedFile();
		Scanner sc = new Scanner(f);
		int numberOfLines = 0;
		while(sc.hasNext()) {
			numberOfLines++;
			sc.nextLine();
	
		}
		sc.close();
		if(numberOfLines > 25) {
			System.out.println("ERROR: number of weights in file exceeds 25");
		}
		
		Scanner weightScanner = new Scanner(f);
		Weight[] weightArray = new Weight[numberOfLines];
		for(int i = 0; i < weightArray.length; i++) {
			weightArray[i] = new Weight(weightScanner.nextInt(),weightScanner.nextDouble());
			
		}
		
		
		System.out.println("Maximum: " + findMaximum(weightArray, numberOfLines));
		System.out.println("Minimum: " + findMinimum(weightArray, numberOfLines));
		System.out.println("Average: " + findAverage(weightArray, numberOfLines));
		
		
		
	}
	
	private static String findMaximum(Weight[] weights, int numberOfValidWights) {
		Weight largest  = weights[0];
		for(int i = 0; i<numberOfValidWights; i++) {
			
			if (weights[i].lessThan(largest)) {
				largest = weights[i];
			}
		}
		return largest.toString();
		
	}
	
	private static String findMinimum(Weight[] weights, int numberOfValidWeights) {
		Weight smallest = weights[0];
		for(int i = 0; i<numberOfValidWeights; i++) {
			if(smallest.lessThan(weights[i])) {
				smallest = weights[i];
			}
		}
		return smallest.toString();
	}
	
	private static String findAverage(Weight[] weights, int numberOfValidWeights) {
		
		Weight total = new Weight(0,0);
		for(int i = 0; i <numberOfValidWeights; i++) {
			total.addTo(weights[i]);
		}
		
		total.divide(numberOfValidWeights);
		
		return total.toString();
	
	}

}
