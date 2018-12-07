package org.academiadecodigo.hashtronauts.battle;

public enum PlayerAction {
    ATTACK("[A] -> Attack!", 0, 0),
    DEFEND("[D] -> Defend!", 0, 0),
    YOUR_SKILL("[1] -> Your Skill!", 0, 0),
    BRIAN_SKILL("[2] -> !", 0, 0),
    JOHN_SKILL("[3] -> !", 0, 0),
    ROGER_SKILL("[4] -> !", 0, 0);

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
