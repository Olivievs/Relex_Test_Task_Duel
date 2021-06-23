package com.company;

public class Player {
    private boolean[] unused_cards = {true, true, true, true, true, true, true,
    true, true, true, true, true};
    private double penalty_points=0;

    public void setPenalty_points(double penalty_points) {
        this.penalty_points = penalty_points;
    }

    public void setUnused_cards(boolean[] unused_cards) {
        this.unused_cards = unused_cards;
    }

    public double getPenalty_points() {
        return this.penalty_points;
    }

    public boolean[] getUnused_cards() {
        return this.unused_cards;
    }
}
