package world.consts;

public class Consts {
    /*tick in mellisec for turn*/
    static public int Tick_millis = 1000;

    static public class Hero {

        public static float KffByLevel_Health = 0.2f;
        public static float KffByLevel_Agility = 0.2f;
        public static float KffByLevel_Strength = 0.3f;
        public static int HeroDefHealth = 100;
        public static int HeroDefAgility = 19;
        public static int HeroDefStrength = 21;
    }
    /**/
    static public class Monsters {
        /*min/max level for monsters*/
        public static int MinLevel = 1;
        public static int MaxLevel = 10;
        public static int PackHealth = 35;
        public static float KffByLevel_PackHealth = 0.9f;
        /**/
        public int DefHealth;
        public int DefAgility;
        public int DefStrength;
        public int DefExp;
        public int DefGold;
        /**/
        public float KffByLevel_Health;
        public float KffByLevel_Agility ;
        public float KffByLevel_Strength;
        /**/
        public float KffByLevel_Gold;
        public float KffByLevel_Exp;

        public Monsters(int defHealth, int defAgility, int defStrength,
                        int defExp, int defGold,
                        float kffByLevel_Health, float kffByLevel_Agility, float kffByLevel_Strength,
                        float kffByLevel_Gold, float kffByLevel_Exp)
        {
            DefHealth = defHealth;
            DefAgility = defAgility;
            DefStrength = defStrength;
            DefExp = defExp;
            DefGold = defGold;
            KffByLevel_Health = kffByLevel_Health;
            KffByLevel_Agility = kffByLevel_Agility;
            KffByLevel_Strength = kffByLevel_Strength;
            KffByLevel_Gold = kffByLevel_Gold;
            KffByLevel_Exp = kffByLevel_Exp;
        }
    }
    /**/
    static public Monsters SkeletMonster = new Monsters(30, 16, 9,
            100, 50,
            0.9f, 0.7f, 0.9f,
            0.9f, 0.8f);
    static public Monsters GoblinMonster = new Monsters(40, 16, 10,
            90, 40,
            0.7f, 0.85f, 0.9f,
            0.8f, 0.8f);
}

