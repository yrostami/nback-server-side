package yrostami.entity;

/**
 * Created by Yousef on 06/15/2017.
 */
public class Result {

    private String firstName;
    private String lastName;
    private String sexuality;
    private String married;
    private String education;
    private String Occupation;
    private int age;

    private int answersCount = 0;
    private int correctAnswersCount = 0;
    private int wrongAnswersCount = 0;
    private int noAnswersCount = 0;
    private int timeAverage = 0;
    private int timeStandardDeviation = 0;
    private float correctAnswersPercent = 0;

    public Result(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnswersCount() {
        return answersCount;
    }

    public void setAnswersCount(int answersCount) {
        this.answersCount = answersCount;
    }

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(int correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public int getWrongAnswersCount() {
        return wrongAnswersCount;
    }

    public void setWrongAnswersCount(int wrongAnswersCount) {
        this.wrongAnswersCount = wrongAnswersCount;
    }

    public int getTimeAverage() {
        return timeAverage;
    }

    public void setTimeAverage(int timeAverage) {
        this.timeAverage = timeAverage;
    }

    public int getTimeStandardDeviation() {
        return timeStandardDeviation;
    }

    public void setTimeStandardDeviation(int timeStandardDeviation) {
        this.timeStandardDeviation = timeStandardDeviation;
    }

    public float getCorrectAnswersPercent() {
        return correctAnswersPercent;
    }

    public void setCorrectAnswersPercent(float correctAnswersPercent) {
        this.correctAnswersPercent = correctAnswersPercent;
    }

    public int getNoAnswersCount() {
        return noAnswersCount;
    }

    public void setNoAnswersCount(int noAnswersCount) {
        this.noAnswersCount = noAnswersCount;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    @Override
    public String toString() {
        return "Result{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sexuality='" + sexuality + '\'' +
                ", married='" + married + '\'' +
                ", education='" + education + '\'' +
                ", Occupation='" + Occupation + '\'' +
                ", age=" + age +
                ", answersCount=" + answersCount +
                ", correctAnswersCount=" + correctAnswersCount +
                ", wrongAnswersCount=" + wrongAnswersCount +
                ", noAnswersCount=" + noAnswersCount +
                ", timeAverage=" + timeAverage +
                ", timeStandardDeviation=" + timeStandardDeviation +
                ", correctAnswersPercent=" + correctAnswersPercent +
                '}';
    }
}
