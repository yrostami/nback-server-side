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
    private String state;
    private int age;

    private int answersCount = 0;
    private int correctAnswersCount = 0;
    private int wrongAnswersCount = 0;
    private int noAnswersCount = 0;
    private int timeAverage = 0;
    private int timeStandardDeviation = 0;
    private float correctAnswersPercent = 0;

    private int t1N = 0;
    private int t1E = 0;
    private int t1O = 0;
    private int t1A = 0;
    private int t1C = 0;

    private int t2p1 = 0;
    private int t2p2 = 0;
    private int t2p3 = 0;
    private int t2p4 = 0;
    private int t2p5 = 0;

    private int t3f1 = 0;
    private int t3f2 = 0;
    private int t3f3 = 0;
    private int t3f4 = 0;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getT1N() {
        return t1N;
    }

    public void setT1N(int t1N) {
        this.t1N = t1N;
    }

    public int getT1E() {
        return t1E;
    }

    public void setT1E(int t1E) {
        this.t1E = t1E;
    }

    public int getT1O() {
        return t1O;
    }

    public void setT1O(int t1O) {
        this.t1O = t1O;
    }

    public int getT1A() {
        return t1A;
    }

    public void setT1A(int t1A) {
        this.t1A = t1A;
    }

    public int getT1C() {
        return t1C;
    }

    public void setT1C(int t1C) {
        this.t1C = t1C;
    }

    public int getT2p1() {
        return t2p1;
    }

    public void setT2p1(int t2p1) {
        this.t2p1 = t2p1;
    }

    public int getT2p2() {
        return t2p2;
    }

    public void setT2p2(int t2p2) {
        this.t2p2 = t2p2;
    }

    public int getT2p3() {
        return t2p3;
    }

    public void setT2p3(int t2p3) {
        this.t2p3 = t2p3;
    }

    public int getT2p4() {
        return t2p4;
    }

    public void setT2p4(int t2p4) {
        this.t2p4 = t2p4;
    }

    public int getT2p5() {
        return t2p5;
    }

    public void setT2p5(int t2p5) {
        this.t2p5 = t2p5;
    }

    public int getT3f1() {
        return t3f1;
    }

    public void setT3f1(int t3f1) {
        this.t3f1 = t3f1;
    }

    public int getT3f2() {
        return t3f2;
    }

    public void setT3f2(int t3f2) {
        this.t3f2 = t3f2;
    }

    public int getT3f3() {
        return t3f3;
    }

    public void setT3f3(int t3f3) {
        this.t3f3 = t3f3;
    }

    public int getT3f4() {
        return t3f4;
    }

    public void setT3f4(int t3f4) {
        this.t3f4 = t3f4;
    }

    @Override
    public String toString() {
        return "Result{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sexuality='" + sexuality + '\'' +
                ", married='" + married + '\'' +
                ", education='" + education + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", answersCount=" + answersCount +
                ", correctAnswersCount=" + correctAnswersCount +
                ", wrongAnswersCount=" + wrongAnswersCount +
                ", noAnswersCount=" + noAnswersCount +
                ", timeAverage=" + timeAverage +
                ", timeStandardDeviation=" + timeStandardDeviation +
                ", correctAnswersPercent=" + correctAnswersPercent +
                ", t1N=" + t1N +
                ", t1E=" + t1E +
                ", t1O=" + t1O +
                ", t1A=" + t1A +
                ", t1C=" + t1C +
                ", t2p1=" + t2p1 +
                ", t2p2=" + t2p2 +
                ", t2p3=" + t2p3 +
                ", t2p4=" + t2p4 +
                ", t2p5=" + t2p5 +
                ", t3f1=" + t3f1 +
                ", t3f2=" + t3f2 +
                ", t3f3=" + t3f3 +
                ", t3f4=" + t3f4 +
                '}';
    }
}
