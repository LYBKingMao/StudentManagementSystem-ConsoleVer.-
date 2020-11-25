package bean;

public class User {
    private int id;
    private String uname;
    private String upass;
    private int type;

    public User(){
    }

    public User(String uname, String upass){
        this.uname = uname;
        this.upass = upass;
    }


    public User(String uname, String upass, int type){
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    public User(int id, String uname, String upass, int type){
        this.id = id;
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUpass() {
        return upass;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", type=" + type +
                '}';
    }
}
