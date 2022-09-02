package org.bowlingGame;

public class Game {

    private int roll = 0;
    private int[] rolls = new int[21];

    public Game() {

    }

    public void roll(int...rolls) {

        for (int pinsDown : rolls) {
            roll(pinsDown);
        }
    }
    public void roll(int pinsDown) {

        rolls[roll] = pinsDown;
    }

    public int score() {

        int score = 0;
        int pointer = 0;

        for (int frame = 0; frame < 10; frame++) {

            if (isStrike(pointer)) {

                score += 10 + rolls[pointer + 1] + rolls[pointer + 2];
                pointer += 1;

            } else if (isSpare(pointer)) {

                score += 10 + rolls[pointer + 2];
                pointer += 2;

            } else {

                score += rolls[pointer] + rolls[pointer + 1];
                pointer += 2;

            }
        }

        return score;
    }

    private boolean isStrike(int frame) {

        return rolls[frame] == 10;
    }

    private boolean isSpare(int frame) {

        return rolls[frame] + rolls[frame + 1] == 10;
    }


}
