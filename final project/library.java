import javax.swing.JOptionPane;
import java.util.*;

public class library{
    public static librarybook[] booklist = new librarybook[1000];
    librarybook librarybook =new librarybook(null,null,null,true,null,null,null,0);
    static int booknum=0;
      
    public void addbook(){ //�s�W�Ϯ�

      int set=1;
      while (set ==1){
        String newname=JOptionPane.showInputDialog(null,"�ѦW", "�s�W�Ϯ�",3);
        if (newname ==null) { set = 0; break;}
        librarybook.setName(newname);

        String newauthor=JOptionPane.showInputDialog(null,"�@��", "�s�W�Ϯ�",3);
	if (newauthor ==null) { set = 0; break;}
        librarybook.setAuthor(newauthor);

        String newID=JOptionPane.showInputDialog(null,"ID", "�s�W�Ϯ�",3);
	if (newID ==null) { set = 0; break;}
        librarybook.setID(newID);

        librarybook boo=new librarybook(librarybook.getName(),librarybook.getAuthor(),librarybook.getID(),librarybook.getInlibrary(),librarybook.getBorrowtime(),librarybook.getDue(),librarybook.getReturnday(),librarybook.getPunish());
        for(int i=0;i<booklist.length;i++){
           if(booklist[i]==null){ 
              booklist[i]=boo;
              booknum++; 
              JOptionPane.showMessageDialog(null,"�s�W�ϮѦ��\!\n"+booklist[i],"�s�W�Ϯ�",1);
              break; }
          // if(i==booklist.length){ System.out.println("�Ϯ��]�îѤw���A�ڭ̺ɧֳq���޲z�����B���A�ܩ�p�y���A�̪��x�Z"); }//��Ϯ��]�w����
        }
        set=0;
       }
     }
    public void removebook(){
      int set=1;
      while(set==1){
        String name=JOptionPane.showInputDialog(null,"�ѦW","�R���Ϯ�",3);
        if (name ==null) { set = 0; break;}
        librarybook.setName(name);
        String author=JOptionPane.showInputDialog(null,"�@��","�R���Ϯ�",3);
        if (author ==null) { set = 0; break;}
        librarybook.setAuthor(author);
        String ID=JOptionPane.showInputDialog(null,"ID","�R���Ϯ�",3);
	if (ID ==null) { set = 0; break;}
        librarybook.setID(ID);
        int index=-1;
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(librarybook.getName())&&booklist[i].getAuthor().equals(librarybook.getAuthor())&&booklist[i].getID().equals(librarybook.getID())){
                index=i;
                JOptionPane.showMessageDialog(null,"�R�����\","�R���Ϯ�",1);
                break;
            }
        }
        if(index<0){
            JOptionPane.showMessageDialog(null,"�䤣�즹��","�R���Ϯ�",0);
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
        String name=JOptionPane.showInputDialog(null,"�ª��W�r","�ק�Ϯ�",3);
        if(name==null){ set=0; break; }
        librarybook.setName(name);
        String author=JOptionPane.showInputDialog(null,"�ª��@��","�ק�Ϯ�",3);
        if(author==null){ set=0; break; }
        librarybook.setAuthor(author);
        librarybook boo=new librarybook(librarybook.getName(),librarybook.getAuthor(),librarybook.getID(),librarybook.getInlibrary(),librarybook.getBorrowtime(),librarybook.getDue(),librarybook.getReturnday(),librarybook.getPunish());
        for(int i=0;i<booknum;i++){
            if(booklist[i].getName().equals(boo.getName())&&booklist[i].getAuthor().equals(boo.getAuthor())){
                String newName=JOptionPane.showInputDialog(null,"�s���W�r","�ק�Ϯ�",3);
                if(newName==null){ set=0; break; }
                librarybook.setName(newName);
                String newAuthor=JOptionPane.showInputDialog(null,"�s���@��","�ק�Ϯ�",3);
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
            JOptionPane.showMessageDialog(null,"��粒��","�ק�Ϯ�",1);
        }
        else{
            JOptionPane.showMessageDialog(null,"�䤣�즹��","�ק�Ϯ�",0);
        }
        set=0;
        }
    }

    public librarybook checkbook(){
      librarybook lbr=null;
      int set = 1;
      while(set==1){  
	String bookname = JOptionPane.showInputDialog(null,"�п�J�ѦW:","�d�߮��y�t��",3);
	if (bookname ==null) { set = 0; break;}
        String author = JOptionPane.showInputDialog(null,"�п�J�@��:","�d�߮��y�t��",3);
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