package GET_RARITY;

public class Odds {

    public static int getRarity(){
        int random = (int) (Math.random() * 100) + 1;

        //1% chance
        if (random == 100){
            return 1;
        }
        //5% chance
        if (random >= 94 && random <= 99){
            return 2;
        }
        //10% chance
        if (random >= 83 && random <= 93){
            return 3;
        }
        //20% chance
        if (random >= 62 && random <= 82){
            return 4;
        }
        //27% chance
        if (random >= 34 && random <= 61){
            return 5;
        }

        //37% chance
        return 6;
    }
}
