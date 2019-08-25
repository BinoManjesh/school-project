package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

class Brain {
	
	private static final Random rand = new Random();
	
	private InputNeuron[] input;
	private Neuron[] hidden;
	private Neuron[] output;
	
	Brain(int inputNeurons, int outputNeurons) {
		input = new InputNeuron[inputNeurons];
		for (int i = 0; i < inputNeurons; i++) {
			input[i] = new InputNeuron();
		}
		
		hidden = new Neuron[outputNeurons];
		for (int i = 0; i < outputNeurons; i++) {
			hidden[i] = new Neuron(input, rand);
		}
		output = hidden;
	}
	
	Brain(Brain brain, float mutate) {
		input = brain.input;
		hidden = brain.hidden;
		output = brain.output;
		
		for (Neuron neuron : output) {
			if (!shouldMutate(mutate)) {
				continue;
			}
			for (int i = 0; i < neuron.coeffs.length; i++) {
				if (!shouldMutate(mutate)) {
					continue;
				}
				neuron.coeffs[i] += 2 * rand.nextFloat() * mutate - 1;
				if (neuron.coeffs[i] > 1) {
					neuron.coeffs[i] = 1;
				} else if (neuron.coeffs[i] < -1) {
					neuron.coeffs[i] = -1;
				}
			}
		}
	}
	
	private boolean shouldMutate(float mutate) {
		return rand.nextFloat() < mutate;
	}
		
	boolean[] get(boolean[] args) {
		set(args);
		for (Neuron neuron : hidden) {
			neuron.update();
		}
		
		boolean[] out = new boolean[output.length];
		for (int i = 0; i < output.length; i++) {
			out[i] = output[i].value;
		}
		return out;
	}
	
	private void set(boolean[] args) {
		for (int i = 0; i < input.length; i++) {
			input[i].value = args[i];
		}
	}
}