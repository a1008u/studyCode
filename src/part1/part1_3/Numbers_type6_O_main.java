package part1.part1_3;

/**
 * Created by AU on 2017/06/30.
 */
public class Numbers_type6_O_main {

    public static void main(String[] args) {

        //ゲーム開始------------------------------------------------------
        Numbers_type6_O_Game Game = new Numbers_type6_O_Game();
        Numbers_type6_O_Number Number = new Numbers_type6_O_Number();
        Numbers_type6_O_player Player = new Numbers_type6_O_player();

        Game.numbers(Player, Number);

    }
}
