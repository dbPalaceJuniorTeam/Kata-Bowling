package org.bowlingGame;

public class Game {

    int[] rolls = new int[21];
    int actualScore=0;
    int actualRoll;
    public Game() {
        for(int i=0;i<rolls.length;i++){
            rolls[i]=0;
        }
        actualRoll=0;
    }

    public void roll(int pinsDown){
        //[5,5 ,3,4 ,1,0 , 0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0,0]

        rolls[actualRoll]=pinsDown;
        actualRoll++;
        if(actualRoll>=21){
            actualRoll=rolls.length-1;
        }

    }

    public int score(){

        //[5,5 ,3,4 ,1,0 , 0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0,0]

        //13 7 1

        int frame=0;
        for(int roll:rolls){

            if(isSpareRoll(frame)){
                //spare

                actualScore=10+rolls[frame+2];
                frame+=2;
            }else{
                actualScore+=roll;
                frame++;
            }

        }



        return actualScore;
    }

    private boolean isSpareRoll(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }


}
