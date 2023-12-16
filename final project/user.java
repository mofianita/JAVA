import javax.swing.JOptionPane;
import java.util.*;

public class user {
    ArrayList<member3> users = new ArrayList<member3>();
    
    public member3 runlogin() {
      int set = 1;
      member3 user = null;	
      while( set==1 ){  
	    String ID=JOptionPane.showInputDialog(null,"請輸入帳號(ID)", "登入系統",3);
	    if (ID ==null) { set = 0; break;}
        String password=JOptionPane.showInputDialog(null,"請輸入密碼", "登入系統",3);
	    if (password ==null) { set = 0; break;}
	    set = 0;
      	
        
        for(int i=0;i<users.size();i++){
            if(users.get(i).getID().equals(ID)&&users.get(i).getPassword().equals(password)){
                user=users.get(i);
                String welcome=user.getName();
                JOptionPane.showMessageDialog(null,"您好"+welcome+"歡迎進入圖書館系統","登入系統",1);
                break;
            }
	    }

        if(user==null){
                JOptionPane.showMessageDialog(null,"帳號或密碼錯誤，請重新輸入","登入系統",0);
        }
       } 
        return user;
       
    }

    public void Register(){
       int set = 1;
       while( set == 1){

		String name = null;
        	name = JOptionPane.showInputDialog(null,"請輸入你的名字:","註冊系統",3);
        	if (name ==null) { set = 0; break;}
	
		String[]  strArray = {"學生" , "老師" , "職員" , "管理員" }; 
        	String identity =(String) JOptionPane.showInputDialog(null,"請輸入你的身分:","註冊系統",3,null,strArray,strArray[0]);
		if (identity ==null) { set = 0; break;}
        
        	String ID =JOptionPane.showInputDialog(null,"請輸入你的ID:","註冊系統",3);
        	if (ID ==null) { set = 0; break;}

        	String password =JOptionPane.showInputDialog(null,"請輸入你的密碼:","註冊系統",3);
		if (password ==null) { set = 0; break;}
		
		set = 0;
	
        member3 m3=null;
        if (identity.compareTo("學生")==0){
            	m3 = new student(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"註冊完成，祝您使用愉快","成功",1);
        }     
        else if (identity.compareTo("管理員")==0){
            	m3 = new admin(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"註冊完成，祝您使用愉快","成功",1); 
        }           
        else if (identity.compareTo("職員")==0){
            	m3 = new staff(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"註冊完成，祝您使用愉快","成功",1);
        }             
        else if (identity.compareTo("老師")==0){
            	m3 = new teacher(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"註冊完成，祝您使用愉快","成功",1);
        }
                   
        else{
	    	JOptionPane.showMessageDialog(null,"輸入錯誤!請再試一次","失敗",2);	
            
        }
      }	
    }

    public static String profile(){
        String ID=JOptionPane.showInputDialog(null,"安全起見，請再輸入一次ID:","個人資料",1);
        return ID;
    }

}
