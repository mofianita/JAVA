public class student extends member3{

    public student(String name, String identity, String ID, String password) {
        super(name, identity, ID, password);
    }
    public  int getDuetime(){
        return 10;
    }
    public void addbook(){}
    public void removebook(){}
    public void changebook(){}
    public librarybook checkbook(){
        return null;
    }
    public int getMaxborrow(){
        return 3;
    }
}
