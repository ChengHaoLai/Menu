package com.example.menu;

public class Food {
    private boolean cheese, tomato, vegetables;

    Food(boolean cheese, boolean tomato, boolean vegetables) {
        setCheese(cheese);
        setTomato(tomato);
        setVegetables(vegetables);
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isTomato() {
        return tomato;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

}
