package com.bino.flappy_bird;

import java.util.Random;

class Neuron extends InputNeuron {
	
	private InputNeuron[] neurons;
	float[] coeffs;
	float biasCoeff;
	
	Neuron(InputNeuron[] neurons, Random rand) {
		this.neurons = neurons;
		coeffs = new float[neurons.length];
		for (int i = 0; i < neurons.length; i++) {
			coeffs[i] = 2 * rand.nextFloat() - 1; 
		}
	}

	void update() {
		int sum = 0;
		for (int i = 0; i < neurons.length; i++) {
			if (neurons[i].value) {
				sum += coeffs[i];	
			}
			sum += biasCoeff;
		}
		
		if (sum > 0) {
			value = true;
		} else {
			value = false;
		}
	}
}
