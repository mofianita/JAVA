import javax.swing.JOptionPane;
import java.util.*;

public class library{
    public static librarybook[] booklist = new librarybook[1000];
    librarybook librarybook =new librarybook(null,null,null,true,null,null,null,0);
    static int booknum=0;
      
    public void addbook(){ //新增圖書

      int set=1;
      while (set ==1){
        String newname=JOptionPane.showInputDialog(null,"書名", "新增圖書",3);
        if (newname ==null) { set = 0; break;}
        librarybook.setName(newname);

        String newauthor=JOptionPane.showInputDialog(null,"作者", "新增圖書",3);
	if (newauthor ==null) { set = 0; break;}
        librarybook.setAuthor(newauthor);

        String newID=JOptionPane.showInputDialog(null,"ID", "新增圖書",3);
	if (newID ==null) { set = 0; break;}
        librarybook.setID(newID);

        librarybook boo=new librarybook(librarybook.getName(),librarybook.getAuthor(),librarybook.getID(),librarybook.getInlibrary(),librarybook.getBorrowtime(),librarybook.getDue(),librarybook.getReturnday(),librarybook.getPunish());
        for(int i=0;i<booklist.length;i++){
           if(booklist[i]==null){ 
              booklist[i]=boo;
              booknum++; 
              JOptionPane.showMessageDialog(null,"新增圖書成功!\n"+booklist[i],"新增圖書",1);
              break; }
          // if(i==booklist.length){ System.out.println("圖書館藏書已滿，我們盡快通知管理員做處哩，很抱歉造成你們的困擾"); }//當圖書館已滿時
        }
        set=0;
       }
     }
    public void removebook(){
      int set=1;
      while(set==1){
        String name=JOptionPane.showInputDialog(null,"書名","刪除圖書",3);
        if (name ==null) { set = 0; break;}
        librarybook.setName(name);
        String author=JOptionPane.showInputDialog(null,"作者","刪除圖書",3);
        if (author ==null) { set = 0; break;}
        librarybook.setAuthor(author);
        String ID=JOptionPane.showInputDialog(null,"ID","刪除圖書",3);
	if (ID ==null) { set = 0; break;}
        librarybook.setID(ID);
        int index=-1;
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(librarybook.getName())&&booklist[i].getAuthor().equals(librarybook.getAuthor())&&booklist[i].getID().equals(librarybook.getID())){
                index=i;
                JOptionPane.showMessageDialog(null,"刪除成功","刪除圖書",1);
                break;
            }
        }
        if(index<0){
            JOptionPane.showMessageDialog(null,"找不到此書","刪除圖書",0);
        }
        for(int i=0;i<booklist.length-1;i++){
            if(index<=i){
                booklist[i]=booklist[i+1];
            }
        }
        booknum--;
        set=0;
      }
    }     
    
    public void changebook(){
        boolean found=false;
        int set=1;
        while(set==1){
        String name=JOptionPane.showInputDialog(null,"舊的名字","修改圖書",3);
        if(name==null){ set=0; break; }
        librarybook.setName(name);
        String author=JOptionPane.showInputDialog(null,"舊的作者","修改圖書",3);
        if(author==null){ set=0; break; }
        librarybook.setAuthor(author);
        librarybook boo=new librarybook(librarybook.getName(),librarybook.getAuthor(),librarybook.getID(),librarybook.getInlibrary(),librarybook.getBorrowtime(),librarybook.getDue(),librarybook.getReturnday(),librarybook.getPunish());
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(boo.getName())&&booklist[i].getAuthor().equals(boo.getAuthor())){
                String newName=JOptionPane.showInputDialog(null,"新的名字","修改圖書",3);
                if(newName==null){ set=0; break; }
                librarybook.setName(newName);
                String newAuthor=JOptionPane.showInputDialog(null,"新的作者","修改圖書",3);
                if(newAuthor==null){ set=0; break; }
                librarybook.setAuthor(newAuthor);
                librarybook newboo=new librarybook(librarybook.getName(),librarybook.getAuthor(),librarybook.getID(),librarybook.getInlibrary(),librarybook.getBorrowtime(),librarybook.getDue(),librarybook.getReturnday(),librarybook.getPunish());
                booklist[i].setName(newboo.getName());
                booklist[i].setAuthor(newboo.getAuthor());
                found=true;
                break;
            }
        }
        if(found==true){
            JOptionPane.showMessageDialog(null,"更改完成","修改圖書",1);
        }
        else{
            JOptionPane.showMessageDialog(null,"找不到此書","修改圖書",0);
        }
        set=0;
        }
    }

    public librarybook checkbook(){
      librarybook lbr=null;
      int set = 1;
      while(set==1){  
	String bookname = JOptionPane.showInputDialog(null,"請輸入書名:","查詢書籍系統",3);
	if (bookname ==null) { set = 0; break;}
        String author = JOptionPane.showInputDialog(null,"請輸入作者:","查詢書籍系統",3);
        if (author ==null) { set = 0; break;}
     //   int count=0;
      
      for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(bookname)&&booklist[i].getAuthor().equals(author)){
                lbr=  booklist[i];
                break;
            }
         //   count++;
        }
       set=0;
       }
        return lbr;
       
    }

    public librarybook borrow(librarybook bookname2,member3 mem){
        librarybook lb=null;
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        Calendar c1= Calendar.getInstance();
        c.setTime(dt); 
        c1.add(Calendar.DATE,mem.getDuetime() );
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(bookname2.getName())){
                if(booklist[i].getInlibrary()==true){
                    booklist[i].setInlibrary(false);
                    booklist[i].setBorrowtime(c);
                    booklist[i].setDue(c1);
                    lb=booklist[i];                    
                }
                else{
                    lb=null;
                }
            }
        }
        return lb;
    }

    public librarybook returnbook(String bookname){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt);
        librarybook lb=null; 
      //  boolean a = false;
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(bookname)){
                booklist[i].setInlibrary(true);
                booklist[i].setReturnday(c);
                lb=booklist[i];
                break;
            }
        }
        if(lb!=null){
            long seconds = (c.getTimeInMillis() - lb.getReturnday().getTimeInMillis()) / 1000;
            int hours = (int) (seconds / 3600);
            int days = hours/24;
            if(days<0){
                lb.setPunish(days*5);
            }
            else{
                lb.setPunish(0);
            }
        }
        return lb;
    } 
}