public class Song {
	private String name;
	private int time;
	private String artist;
	private double price;

	public Song(String name, int time, String artist, double price) {
		this.name = name;
		this.time = time;
		this.artist = artist;
		this.price = price;
	}

	public String formatTime() {
		int min = time / 60;
		int sec = time % 60;
		if (sec==0)
			return min + ":" + "00";
		else
			return min + ":" + sec;
	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public String toString() {
		// you don't need to know the static method format() of the String class for this course
		// however, it's a good way to create fixed-width strings when doing columns of data
		String s = String.format("%1$-20.20s | %2$5s | %3$-30.30s | $%4$3.2f", name, formatTime(), artist, price );

		return s;
	}
}
