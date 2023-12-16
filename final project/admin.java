public class admin extends member3{
    library library = new library();
    public admin(String name, String password, String ID, String identity) {
        super(name, password, ID, identity);
    }

    public void addbook(){
        library.addbook();
    }
    public void removebook(){
        library.removebook();
    }
    public void changebook(){
        library.changebook();
    }
    public librarybook checkbook(){
        librarybook lib=library.checkbook();
        return lib;
    }
    public int getDuetime(){
        return 0;
    }
    public int getMaxborrow(){
        return 0;
    }
}
