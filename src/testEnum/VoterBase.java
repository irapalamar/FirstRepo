package testEnum;

public abstract class VoterBase implements Voter {
    private final AgeCategory ageCategory;
    private final Gender gender;

    VoterBase(int age, Gender gender) {
        this.ageCategory = AgeCategory.valueOf(age);
        this.gender = gender;
    }

    @Override
    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
