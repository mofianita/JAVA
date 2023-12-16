import java.util.ArrayList;
import java.util.Calendar;
public abstract class member3 {
    protected String name;
    protected String ID;
    protected String identity;
    protected String password;
    protected int usernum = 0;
    String errorReason="";
    library library = new library();
    ArrayList<borrowbook> borrowlist = new ArrayList<borrowbook>();
    public member3(String name, String password,String ID,String identity){
        setName(name);
        setPassword(password);
        setID(ID);
        setIdentity(identity);
    }

    public void setPassword(String password){this.password= password;}
    public void setID(String ID){this.ID = ID;}
    public void setName(String name){this.name = name;}
    public void setIdentity(String identity){this.identity = identity;}
    public String getName(){return name;}
    public String getID(){return ID;}
    public String getPassword(){return password;}
    public String getIdentity(){return identity;}

    public librarybook borrow(librarybook lb,member3 mem){
        librarybook a=null;
        if(borrowlist.size()>=mem.getMaxborrow()){
            //System.out.println("借閱書籍已達上限");
            errorReason="借閱書籍已達上限";
        }
        else{
            a =library.borrow(lb,mem);
            if(a!=null){
                addmem3(a.getName(),a.getBorrowtime(),a.getDue());
            } 
            else {
                errorReason="此書已被借閱";
            }
        }
        return a;
    }

    public void addmem3(String name,Calendar borrowtime,Calendar due){
        borrowlist.add(new borrowbook(name, borrowtime, due, this));
    }

    public ArrayList<borrowbook> list(){
        return (borrowlist);
    }

    public boolean returnbook(String lb){
        librarybook a= library.returnbook(lb);
        boolean found = false;
        if(a!=null){
            for(int i=0;i<borrowlist.size();i++){
                if(borrowlist.get(i).getName().equals(lb)){
                    borrowlist.remove(i);
                    //System.out.println("還書成功");
                    found = true;
                }
            }
        }    
        return found;
    }

    public String getErrorReason(){
        return errorReason;
    }

    public abstract void addbook();
    public abstract void removebook();
    public abstract void changebook();
    public abstract librarybook checkbook();
    public abstract int getDuetime();
    public abstract int getMaxborrow();
}
