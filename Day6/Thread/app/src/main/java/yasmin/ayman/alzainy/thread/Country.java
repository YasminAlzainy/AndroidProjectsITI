package yasmin.ayman.alzainy.thread;

import android.graphics.Bitmap;

public class Country {
    private String country,population,rank;
    private Bitmap flag;

    public Country(String country, String population, String rank, Bitmap flag) {
        this.country = country;
        this.population = population;
        this.rank = rank;
        this.flag = flag;
    }

    public Country(String country, String population, String rank) {
        this.country = country;
        this.population = population;
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Bitmap getFlag() {
        return flag;
    }

    public void setFlag(Bitmap flag) {
        this.flag = flag;
    }
}
