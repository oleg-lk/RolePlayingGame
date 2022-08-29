package world;

public class Consts {
    /*tick in mellisec for turn*/
    static public int Tick_millis = 1000;

    static public class Hero {

        public static float KffByLevel_Health = 1.2f;
        public static float KffByLevel_Agility = 1.1f;
        public static float KffByLevel_Strength = 1.4f;
        public static int HeroDefHealth = 100;
        public static int HeroDefAgility = 15;
        public static int HeroDefStrength = 10;
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
            KffByLevel_Exp = KffByLevel_Exp;
        }
    }
    /**/
    static public Monsters SkeletMonster = new Monsters(30, 10, 8,
            100, 50,
            1.3f, 1.2f, 1.4f,
            1.4f, 1.5f);
    static public Monsters GoblinMonster = new Monsters(40, 15, 9,
            90, 40,
            1.4f, 1.3f, 1.3f,
            1.4f, 1.5f);
}

