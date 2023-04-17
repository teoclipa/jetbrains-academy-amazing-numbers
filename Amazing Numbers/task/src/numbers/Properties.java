package numbers;

public enum Properties {
    EVEN(false), ODD(false), BUZZ(false), DUCK(false), PALINDROMIC(false),
    GAPFUL(false), SPY(false), SQUARE(false), SUNNY(false), JUMPING(false),
    HAPPY(false),SAD(false);

    public boolean hasProperty;

    Properties(boolean hasProperty) {
        this.hasProperty = hasProperty;
    }

    public void setProperty(boolean hasProperty) {
        this.hasProperty = hasProperty;
    }

    public static void resetProperties() {
        for (Properties properties : Properties.values()) {
            properties.setProperty(false);
        }
    }


}
