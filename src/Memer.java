public class Memer {

    private String n;
    private String lowerN;
    private int memePoints;

    public Memer(String nick) {
        this.n = nick;
        this.lowerN = nick.toLowerCase();
        this.memePoints = 0;
        // TODO Auto-generated constructor stub
    }

    public String getNick() {
        return this.n;
    }

    public void addMeme(String meme) {
        if (meme.equalsIgnoreCase("same")) {
            this.memePoints += 5;
        }
        if (meme.equalsIgnoreCase("nice")) {
            this.memePoints += 1;
        }
        if (meme.equalsIgnoreCase("doot")) {
            this.memePoints += 10;
        }
        if (meme.equalsIgnoreCase("freakazoid")) {
            this.memePoints += 3;
        }
        if (meme.equals("GOAT")) {
            this.memePoints += 5;
        }
        if (meme.equals("VAC")) {
            this.memePoints += 1;
        }
    }

    public int numPoints() {
        return this.memePoints;
    }

    public int compareTo(Memer m) {
        if (m.numPoints() > this.numPoints()) {
            return -1;
        } else if (m.numPoints() < this.numPoints()) {
            return 1;
        } else {
            return 0;
        }
    }

}
