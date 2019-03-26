package cn.ki.pojo;

public class Profession {
    private Long id;

    private String name;

    private String jobDescription;

    private Long salary01;

    private Long salary02;

    private Long salary03;

    private String threshold;

    private String difficulty;

    private String growthCycle;

    private Long need;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription == null ? null : jobDescription.trim();
    }

    public Long getSalary01() {
        return salary01;
    }

    public void setSalary01(Long salary01) {
        this.salary01 = salary01;
    }

    public Long getSalary02() {
        return salary02;
    }

    public void setSalary02(Long salary02) {
        this.salary02 = salary02;
    }

    public Long getSalary03() {
        return salary03;
    }

    public void setSalary03(Long salary03) {
        this.salary03 = salary03;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle == null ? null : growthCycle.trim();
    }

    public Long getNeed() {
        return need;
    }

    public void setNeed(Long need) {
        this.need = need;
    }
}