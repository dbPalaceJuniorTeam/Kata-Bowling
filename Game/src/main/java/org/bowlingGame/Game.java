package org.bowlingGame;

public class Game {

    int[] rolls = new int[21];
    int actualScore=0;
    int actualRoll=0;
    public Game() {
        for(int i=0;i<rolls.length;i++){
            rolls[i]=0;
        }

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
        //[10,0 ,10,0 ,10,0 , 2,3 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0,0]
        //[10 ,10 ,10 , 2,3 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0,0]
        //30     20    15     5


        //13 7 1

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
