package astroPack;

import java.util.HashMap;
import java.util.Map;


public class NatalChart {
    public static String ascendant = "Ascendant";
    public static String sun = "Sun";
    public static String moon = "Moon";
    public static String mercury = "Mercury";
    public static String venus = "Venus";
    public static String mars = "Mars";
    public static String jupiter = "Jupiter";
    public static String saturn = "Saturn";
    public static String uranus = "Uranus";
    public static String neptune = "Neptune";
    public static String pluto = "Pluto";

    public NatalChart(){
        String ascendantZodiac = getZodiacSign();
        System.out.println(ascendant + " in " + ascendantZodiac);
        System.out.println(sun + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(moon + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(mercury + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(venus + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(mars + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(jupiter + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(saturn + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(uranus + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(neptune + " in " + getZodiacSign() + " in " + getHouse());
        System.out.println(pluto + " in " + getZodiacSign() + " in " + getHouse());
    }

    public static void main(String [] args) {
        NatalChart natalChart = new NatalChart();

    }

    public static String getZodiacSign() {
        Map<Integer, String> zodiac = new HashMap<Integer, String>();
        zodiac.put(1, "Aries");
        zodiac.put(2, "Taurus");
        zodiac.put(3, "Gemini");
        zodiac.put(4, "Cancer");
        zodiac.put(5, "Leo");
        zodiac.put(6, "Virgo");
        zodiac.put(7, "Libra");
        zodiac.put(8, "Scorpio");
        zodiac.put(9, "Sagittarius");
        zodiac.put(10, "Capricorn");
        zodiac.put(11, "Aquarius");
        zodiac.put(12, "Pisces");
        return zodiac.get(getRandomInteger(12, 1));
    }


    public static String getHouse() {
        Map<Integer, String> zodiac = new HashMap<Integer, String>();
        zodiac.put(1, "I house");
        zodiac.put(2, "II house");
        zodiac.put(3, "III house");
        zodiac.put(4, "IV house");
        zodiac.put(5, "V house");
        zodiac.put(6, "VI house");
        zodiac.put(7, "VI house");
        zodiac.put(8, "VIII house");
        zodiac.put(9, "IX house");
        zodiac.put(10, "X house");
        zodiac.put(11, "XI house");
        zodiac.put(12, "XII house");
        return zodiac.get(getRandomInteger(12, 1));
    }

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum; }


}
