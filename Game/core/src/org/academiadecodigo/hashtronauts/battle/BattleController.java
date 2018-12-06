package org.academiadecodigo.hashtronauts.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.hashtronauts.levels.BattleLevel;

public class BattleController {
    BattleLevel battle;

    //Validation for battle over
    private boolean isOver;

    public BattleController(BattleLevel battle){
        this.battle = battle;
    }

    public void battleStart(){
        isOver = false;

        while(!isOver){

            battle.showPlayerActions();

            playerTurn();

            enemyTurn();

            if(battle.getEnemyModel().getHealth() <= 0){
                isOver = true;
            }
        }

    }

    public void playerTurn(){
        boolean choice = false;

        while(!choice){
            //Attack option
            switch(getPlayerInput()){
                case 'A': battle.getEnemyModel().getHit( battle.getPlayerModel().attack() );
                        choice = true;
                        break;
                case 'D': battle.getPlayerModel().defend();
                    choice = true;
                    break;
                case '1': if(battle.getPlayerModel().getSkillCooldown() == 0){
                                battle.getEnemyModel().getHit( battle.getPlayerModel().useSkill() );
                                choice = true;
                            }
                    break;
                case '2':
                    choice = true;
                    break;
                case '3':
                    choice = true;
                    break;
                case '4':
                    choice = true;
                    break;
            }
        }
    }

    public void enemyTurn(){
        double random = Math.random() * 3;

        if( random == 0 ){
            if(isSuccessful()){
                battle.getPlayerModel().getHit( battle.getEnemyModel().attack() );
            }
        }

        if( random == 1 ){
            battle.getEnemyModel().defend();
        }

        if( random == 2 ){
            if(isSuccessful() ){
                battle.getPlayerModel().getHit( battle.getEnemyModel().useSkill() );
            }
        }
        
    }


    public char getPlayerInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if( isSuccessful()){
                return 'A';
            }
        }
        //Defend option
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            return 'D';
        }

        //Skill options
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            if( isSuccessful() ){
                return '1';
            }
        }

           /* if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){

                choice = true;
            }

            if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){

                choice = true;
            }

            if(Gdx.input.isKeyPressed(Input.Keys.NUM_4)){

                choice = true;
            }*/

           return 'n';
    }


    public boolean isSuccessful(){
        double accuracy;
        accuracy = Math.random() * 100;
        if( accuracy >= 10){
            return true;
        }
        return false;
    }

}
