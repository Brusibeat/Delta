package org.academiadecodigo.hashtronauts.battle;

public enum PlayerAction {
    ATTACK("[A] -> Attack!", 470, 590),
    DEFEND("[D] -> Defend!", 470, 560),
    YOUR_SKILL("[Q] -> Friends Will Be Friends!", 470, 530),
    BRIAN_SKILL("[W] -> Brighton Rock!", 220, 720),
    JOHN_SKILL("[E] -> Who Wants To Live Forever!", 170, 400),
    ROGER_SKILL("[R] -> Bohemian Rhapsody!", 220, 220);

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
