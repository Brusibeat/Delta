package org.academiadecodigo.hashtronauts.characters.enemies;

public class EnemyHAIDES extends Enemy{

    private int health = 50;


    public int getHealth() {
        return health;
    }

    @Override
    public void enemyAction() {
        double action = Math.random();

        if (action <= 0.75) {
            attack();
            return;
        }

        if (action <= 0.8) {
            defend();
            return;
        }

        useSkill();
    }

    @Override
    public boolean isDefending() {
        return super.isDefending();
    }

    @Override
    public void setDefending() {
        super.setDefending();
    }

    @Override
    public void defend() {
        super.defend();
    }

    @Override
    public void attack() {
        setDamageDealt(2);
    }

    @Override
    public void useSkill() {
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    public void receiveDamage(int dmg) {
        this.health -= dmg;
    }
}
