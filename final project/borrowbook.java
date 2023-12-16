import java.util.*; 
public class borrowbook {
    private String name;
    private Calendar borrowtime;
    private Calendar due;

    public borrowbook(String name,Calendar borrowtime,Calendar due,member3 m3){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        Calendar c1= Calendar.getInstance();
        c.setTime(dt); 
        c1.add(Calendar.DATE,m3.getDuetime() );
        this.borrowtime=c;
        this.due=c1;
        setName(name);                
    }


    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public Calendar getBorrowtime(){return borrowtime;}
    public Calendar getDue(){return due;}
    public String getBorrowtimeString(){return borrowtime.get(Calendar.YEAR)+"-"+borrowtime.get(Calendar.MONTH)+"-"+borrowtime.get(Calendar.DATE);}
    public String getDueString(){return due.get(Calendar.YEAR)+"-"+due.get(Calendar.MONTH)+"-"+due.get(Calendar.DATE);}

    public String toString(){
        String temp =  String.format("書名:%5s   借閱日期:%10s   須歸還日期:%10s ",getName(),getBorrowtimeString(),getDueString());
        return temp;
    }
}
