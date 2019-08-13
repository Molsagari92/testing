public class Darts {

    int points = 301;
    int counter = 0;
    int turnnumber = 1;

    public int getScore() {
        return points;
    }

    public int dart(int score) {
        this.points = points - score;
        return points;
    }

    public int dart(int score, String szorzotenyezo) {
        switch (szorzotenyezo) {
            case "DOUBLE":
                score = score * 2;
                break;
            case "TRIPLE":
                score = score * 3;
        }
        this.points = points - score;
        return points;
    }

    private int calculatePoints() {
        return points;
    }

    public int getDartsLeft() {
        if (counter == 3) {
            counter = 0;
        }
        counter++;
        return counter;
    }

    public int getTurn() {
        if (this.counter == 3) {
            turnnumber++;
        }
        return turnnumber;
    }

    public boolean isFinished(){
        if (points==0){
            return true;
        } else {
            return false;
        }
    }


}
