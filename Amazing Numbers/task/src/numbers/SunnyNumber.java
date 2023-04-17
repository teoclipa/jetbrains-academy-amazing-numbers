package numbers;

public class SunnyNumber {

    public static void checkSunny(long number) {
        double sqrt = Math.sqrt(number + 1);
        Properties.SUNNY.setProperty((sqrt - Math.floor(sqrt)) == 0);
    }
}
