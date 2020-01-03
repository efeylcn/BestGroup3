package Pages.ServerPress.API.Serialization;

public class pojoStatics {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(String currentClub) {
        this.currentClub = currentClub;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    private int age;
    private String nationality;
    private String position;
    private int cost;
    private String currentClub;
    private int avg;



    public pojoStatics(String name, String nationality, int age, String position, int cost,String currentClub, int avg){
        this.name=name;
        this.age=age;
        this.nationality=nationality;
        this.cost=cost;
        this.currentClub=currentClub;
        this.avg=avg;
        this.position=position;
    }
}
