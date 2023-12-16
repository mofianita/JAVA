public class teacher extends member3 {

    public teacher(String name, String identity, String ID, String password) {
        super(name, identity, ID, password);
    }
    public  int getDuetime(){
        return 30;
    }
    public void addbook(){}
    public void removebook(){}
    public void changebook(){}
    public librarybook checkbook(){
        return null;
    }
    public int getMaxborrow(){
        return 5;
    }
}
