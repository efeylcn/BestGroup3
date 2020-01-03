
package Pages.ServerPress.API.postRequests;

public class Tags {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
//    @Override
//    public String toString(){
//        return  "name from tags: "+ getName()+"\nid from tags :  "+getId();
//    }

}
