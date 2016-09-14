package ru.sbertech.homework.patterns_lesson19.state;


public class Year {
    Season season;

    public Year(Season season){
        this.season = season;
    }
    public void nextSeason(){
        this.season.next(this);
    }
    public void backSeason(){
        this.season.back(this);
    }


    @Override
    public String toString() {
        return this.season.toString();
    }
}
