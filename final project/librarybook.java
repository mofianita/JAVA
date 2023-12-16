import java.util.*;
public class librarybook {
    private String name;
    private String author;
    private String ID;
    private boolean inlibrary;
    private Calendar borrowtime;
    private Calendar due;
    private Calendar returnday;
    private int punish;
    Date dt = new Date();
    
     

    public librarybook(String name, String author, String ID,boolean inlibrary,Calendar borrowtime,Calendar due,Calendar returnday,int punish){
        setName(name);
        setAuthor(author);
        setID(ID);
        setInlibrary(inlibrary);
        setReturnday(returnday);
        setPunish(punish);
        setBorrowtime(null);
        setDue(null);
    }

    public void setAuthor(String author){this.author= author;}
    public void setID(String ID){this.ID = ID;}
    public void setName(String name){this.name = name;}
    public void setInlibrary(boolean inlibrary){this.inlibrary = inlibrary;}
    public void setReturnday(Calendar returnday){this.returnday = returnday;}
    public void setPunish(int punish){this.punish=punish;}
    public void setBorrowtime(Calendar borrowtime){this.borrowtime=borrowtime;}
    public void setDue(Calendar due){this.due=due;}
    public String getName(){return name;}
    public String getID(){return ID;}
    public String getAuthor(){return author;}
    public boolean getInlibrary(){return inlibrary;}
    public Calendar getBorrowtime(){return borrowtime;}
    public Calendar getDue(){return due;}
    public Calendar getReturnday(){return returnday;}
    public int getPunish(){return punish;}

    public String toString(){
        String temp =  String.format("書名:%5s   作者:%5s   ID:%5s   是否在架上:%5s",getName(),getAuthor(),getID(),getInlibrary());
        return temp;
    }

}    
