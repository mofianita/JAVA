public class staff extends member3 {

    public staff(String name, String identity, String ID, String password) {
        super(name, identity, ID, password);
    }
    public  int getDuetime(){
        return 20;
    }
    public void addbook(){}
    public void removebook(){}
    public void changebook(){}
    public librarybook checkbook(){
        return null;
    }
    public int getMaxborrow(){
        return 4;
    }
}
