import org.bowlingGame.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest
{
    Game game = new Game();

    @Test
    void rollPinsDown(){
        game.roll(1);
        game.roll(2);
        assertEquals(3,game.score());
    }

    @Test
    void rollSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        assertEquals(16,game.score());

    }

    @Test
    void rollStrike(){
        game.roll(10);//30
        game.roll(10);//23 -53
        game.roll(10);//17 -70
        game.roll(3);
        game.roll(4);//7

        assertEquals(77,game.score());
    }

    @Test
    void rollStrikeTenthFrame(){

        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(10);//18
        game.roll(5);
        game.roll(3);//+8

        assertEquals(18,game.score());

    }

    @Test
    void rollSpareTenthFrame(){

        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(5);//13
        game.roll(5);
        game.roll(3);//+8

        assertEquals(13,game.score());

    }

    @Test
    void rollAllStrikes(){

        for (int i = 0; i < 10; i++) {
            game.roll(10);
        }
        game.roll(10);
        game.roll(10);

        assertEquals(300,game.score());

    }

    @Test
    void rollRandom(){
        game.roll(0);
        game.roll(1);//1

        game.roll(3);
        game.roll(4);//8

        game.roll(7);//28
        game.roll(3);

        game.roll(10);//50
        //game.roll(10);

        game.roll(10);//65
        //game.roll(10);

        game.roll(2);
        game.roll(3);//70

        game.roll(10);//90
        //game.roll();

        game.roll(5);
        game.roll(5);//103

        game.roll(3);
        game.roll(2);//108

        game.roll(3);//114
        game.roll(3);
        //game.roll(10);

        assertEquals(114,game.score());

    }

}
