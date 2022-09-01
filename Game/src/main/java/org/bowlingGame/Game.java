package org.bowlingGame;

import java.util.Arrays;

public class Game {

    int[] rolls = new int[21];
    int actualScore=0;
    int actualRoll=0;
    public Game() {
        Arrays.fill(rolls, 0);

    }

    public void roll(int pinsDown){

        rolls[actualRoll]=pinsDown;
        actualRoll++;
        if(actualRoll>=21){
            actualRoll=rolls.length-1;
        }

    }

    public int score(){

        int pointer=0;

        for (int frame = 0; frame < 10; frame++) {

            if(isStrike(pointer)){
                actualScore+=10+rolls[pointer+1]+rolls[pointer+2];
                pointer+=1;
            }
            else if(isSpareRoll(pointer)){
                actualScore+=10+rolls[pointer+2];
                pointer+=2;
            }else{
                actualScore+=rolls[pointer]+rolls[pointer+1];
                pointer+=2;
            }
        }

        return actualScore;
    }

    private boolean isStrike(int frame) {
        return rolls[frame] == 10;
    }

    private boolean isSpareRoll(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }


}
