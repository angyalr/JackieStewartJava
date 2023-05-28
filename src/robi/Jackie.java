package robi;

public class Jackie {
    private int year;
    private int races;
    private int wins;
    private int podiums;
    private int poles;
    private int fastests;

    public Jackie(String csvLine) {
        String [] splitted = csvLine.split( "\t");
        this.year = Integer.parseInt( splitted[ 0]);
        this.races = Integer.parseInt( splitted[ 1]);
        this.wins = Integer.parseInt( splitted[ 2]);
        this.podiums = Integer.parseInt( splitted[ 3]);
        this.poles = Integer.parseInt( splitted[ 4]);
        this.fastests = Integer.parseInt( splitted[ 5]);
    }

    public Jackie(int year, int races, int wins, int podiums, int poles, int fastests) {
        this.year = year;
        this.races = races;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.fastests = fastests;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRaces() {
        return races;
    }

    public void setRaces(int races) {
        this.races = races;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public int getFastests() {
        return fastests;
    }

    public void setFastests(int fastests) {
        this.fastests = fastests;
    }
}


