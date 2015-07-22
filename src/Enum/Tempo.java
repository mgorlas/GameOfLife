package Enum;

public enum Tempo {

	Fast(50), Medium(150), Slow(300);

	private int tempo;

	Tempo(int tempo) {
		this.tempo = tempo;
	}

	public int getTempo() {
		return this.tempo;
	}
}
