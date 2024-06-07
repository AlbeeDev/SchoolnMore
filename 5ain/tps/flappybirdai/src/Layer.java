
import java.util.Random;

public class Layer {

	final int nNeuron, nInput;
	double[][] mat;

	public Layer(int nNeuron, int nInput) {
		this.nNeuron = nNeuron;
		this.nInput = nInput;
		mat = new double[nNeuron][nInput];
		randomize();
	}

	void randomize() {
		for (int i = 0; i < nNeuron; i++) {
			for (int j = 0; j < nInput; j++) {
				mat[i][j] = Math.random();
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < nNeuron; i++) {
			build.append("\t");
			for (int j = 0; j < nInput; j++) {
				build.append(mat[i][j] + " - ");
			}
			build.append("\n" + (i > 1 ? "" : "\t"));
		}
		return build.toString();
	}

	double[] output(double[] inputprecedente) {
		// la lunghezza di inputprec è nInput
		// e il risultato della funzione è un array di lunghezza nNeuron
		double[] result = new double[nNeuron];
		for (int i = 0; i < nNeuron; i++) {
			result[i] = 0;
			for (int j = 0; j < nInput; j++) {
				result[i] += mat[i][j] * inputprecedente[j];
			}
		}
		return result;
	}
}

class Brain {

	Layer[] gangli;
	double[] datain;

	public Brain(int[] elenconeuroni, int ninputiniziali) {
		int nstrati = 0;
		while (nstrati < elenconeuroni.length && elenconeuroni[nstrati] != 0) {
			nstrati++;
		}
		if (nstrati == 0)
			System.err.println("nStrati=0, passato un elenco neuroni nullo o vuoto");
		gangli = new Layer[nstrati];
		gangli[0] = new Layer(elenconeuroni[0], ninputiniziali);
		for (int i = 1; i < nstrati - 1; i++)
			gangli[i] = new Layer(elenconeuroni[i], elenconeuroni[i - 1]);
		gangli[nstrati - 1] = new Layer(1, elenconeuroni[nstrati - 1]);
		rebirth();
//		System.out.println("bro:" + think());
	}

	double think() {
		Random randy = new Random();
		double[] result = new double[gangli[0].nNeuron];
		double[] firstThought = new double[gangli[0].nInput];

		for (int i = 0; i < firstThought.length; i++) {
			firstThought[i] = randy.nextDouble() * 30 + 50;
		}
		result = gangli[0].output(firstThought); // faccio il primo così da iterarci sopra

		for (int i = 1; i < gangli.length; i++) {
			result = gangli[i].output(result);
		}
		return result[result.length - 1];
	}

	double think(double[] initialThougth) {
		double[] result = new double[gangli[0].nNeuron];
		result = gangli[0].output(initialThougth); // faccio il primo così da iterarci sopra

		for (int i = 1; i < gangli.length; i++) {
			result = gangli[i].output(result);
		}
		return result[result.length - 1];
	}

	// bestRes è la matrice con i risultati migliori della layer numero nLayer
	void evolve(double[][] bestRes, int nLayer) {
		Random randy = new Random();
		for (int i = 0; i < bestRes.length; i++) {
			for (int j = 0; j < bestRes[i].length; j++) {
				bestRes[i][j] += randy.nextDouble() * 0.16 - 0.08;
				Math.abs(bestRes[i][j]);
			}
		}
		gangli[nLayer].mat = bestRes;
	}

	void rebirth() { // genera dei nuovi gangli
		for (int i = 0; i < gangli.length; i++)
			gangli[i].randomize();
	}

	@Override
	public String toString() {
		StringBuilder bob = new StringBuilder();
		bob.append("cervello stampato:\n");
		for (int i = 0; i < gangli.length; i++) {
			bob.append("gangli[" + i + "]:\t");
			for (int j = 0; j < gangli[i].mat.length; j++) {
				for (int k = 0; k < gangli[i].mat[j].length; k++)
					bob.append(gangli[i].mat[j][k] + (k == gangli[i].mat[j].length - 1 ? "\n" : " - "));
				bob.append(j == gangli[i].mat.length - 1 ? "" : "\t\t");
			}
		}
		return bob.toString();
	}
}