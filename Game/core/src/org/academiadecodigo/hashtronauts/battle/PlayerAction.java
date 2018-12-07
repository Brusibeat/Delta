package org.academiadecodigo.hashtronauts.battle;

public enum PlayerAction {
    ATTACK("[A] -> Attack!", 300, 600),
    DEFEND("[D] -> Defend!", 300, 550),
    YOUR_SKILL("[1] -> Your Skill!", 300, 500),
    BRIAN_SKILL("[2] -> !", 150, 800),
    JOHN_SKILL("[3] -> !", 100, 500),
    ROGER_SKILL("[4] -> !", 150, 200);

    private String message;
    private int X;
    private int Y;

    PlayerAction(String message, int X, int Y){
        this.message = message;
        this.X = X;
        this.Y = Y;

    }

    public String getMessage() {
        return message;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
