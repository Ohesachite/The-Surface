package games.liu.thesurface;

public class Jimmy {

    //Skills
    public static int engineering;
    public static int medicine;
    public static int speech;
    public static int business;

    //Physical Traits
    public static int radiationResistance;
    public static int speed;
    public static int strength;
    public static int resilience;

    //Personality Traits
    public static int zeal;
    public static int trustworthiness;
    public static int influence;

    public Jimmy(){
        engineering = 3;
        medicine = 1;
        speech = 6;
        business = 2;
        radiationResistance = 3;
        speed = 3;
        strength = 3;
        resilience = 3;
        zeal = 5;
        trustworthiness = 5;
        influence = 1;
    }

    public Jimmy(int n){}

    //Allows access of class without recreating
    public static Jimmy getJimmy(){
        return new Jimmy(1);
    }

    public static boolean engineeringCheck(int n){
        return engineering >= n;
    }

    public static boolean medicineCheck(int n){
        return medicine >= n;
    }

    public static boolean speechCheck(int n){
        return speech >= n;
    }

    public static boolean businessCheck(int n){
        return business >= n;
    }

    public static boolean radiationResistanceCheck(int n){
        return radiationResistance >= n;
    }

    public static boolean speedCheck(int n){
        return speed >= n;
    }

    public static boolean strengthCheck(int n){
        return strength >= n;
    }

    public static boolean resilienceCheck(int n){
        return resilience >= n;
    }

    public static boolean zealCheck(int n){
        return zeal >= n;
    }

    public static boolean trustworthyCheck(int n){
        return trustworthiness >= n;
    }

    public static boolean influenceCheck(int n){
        return influence >= n;
    }

}
