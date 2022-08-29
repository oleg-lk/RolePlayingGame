package world;

public class Consts {
    /*tick in mellisec for turn*/
    static public int Tick_millis = 1000;

    static public class Hero {
        static int HeroDefHealth = 100;
        static int HeroDefAgility = 15;
        static int HeroDefStrength = 10;
    }
    /**/
    static public class Monsters {
        /*min/max level for monsters*/
        public static int MinLevel = 1;
        public static int MaxLevel = 10;
        public static int PackHealth = 30;
        public static float KffByLevel_PackHealth = 1.5f;
        /**/
        public int DefHealth;
        public int DefAgility;
        public int DefStrength;
        /**/
        public float KffByLevel_Health;
        public float KffByLevel_Agility ;
        public float KffByLevel_Strength;
        /**/

        public Monsters(int defHealth, int defAgility, int defStrength, float kffByLevel_Health, float kffByLevel_Agility, float kffByLevel_Strength) {
            DefHealth = defHealth;
            DefAgility = defAgility;
            DefStrength = defStrength;
            KffByLevel_Health = kffByLevel_Health;
            KffByLevel_Agility = kffByLevel_Agility;
            KffByLevel_Strength = kffByLevel_Strength;
        }
    }
    /**/
    static public Monsters SkeletMonster = new Monsters(30, 10, 8, 1.3f, 1.2f, 1.4f);
    static public Monsters GoblinMonster = new Monsters(40, 15, 9, 1.4f, 1.3f, 1.3f);
}

