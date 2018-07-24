package testEnum;

public enum AgeCategory {
    YOUNG(18, 29),
    MIDDLE(30, 49),
    SENIOR(50, 64),
    ELDERLY(65, 150);

    private final int from;
    private final int to;

    AgeCategory(int from, int to) {
        this.from = from;
        this.to = to;
    }

    static public AgeCategory valueOf(int age) {
        for (AgeCategory ageCategory : values()) {
            if (ageCategory.from <= age && age <= ageCategory.to) {
                return ageCategory;
            }
        }
        throw new IllegalArgumentException();
    }
}
