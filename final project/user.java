import javax.swing.JOptionPane;
import java.util.*;

public class user {
    ArrayList<member3> users = new ArrayList<member3>();
    
    public member3 runlogin() {
      int set = 1;
      member3 user = null;	
      while( set==1 ){  
	    String ID=JOptionPane.showInputDialog(null,"�п�J�b��(ID)", "�n�J�t��",3);
	    if (ID ==null) { set = 0; break;}
        String password=JOptionPane.showInputDialog(null,"�п�J�K�X", "�n�J�t��",3);
	    if (password ==null) { set = 0; break;}
	    set = 0;
      	
        
        for(int i=0;i<users.size();i++){
            if(users.get(i).getID().equals(ID)&&users.get(i).getPassword().equals(password)){
                user=users.get(i);
                String welcome=user.getName();
                JOptionPane.showMessageDialog(null,"�z�n"+welcome+"�w��i�J�Ϯ��]�t��","�n�J�t��",1);
                break;
            }
	    }

        if(user==null){
                JOptionPane.showMessageDialog(null,"�b���αK�X���~�A�Э��s��J","�n�J�t��",0);
        }
       } 
        return user;
       
    }

    public void Register(){
       int set = 1;
       while( set == 1){

		String name = null;
        	name = JOptionPane.showInputDialog(null,"�п�J�A���W�r:","���U�t��",3);
        	if (name ==null) { set = 0; break;}
	
		String[]  strArray = {"�ǥ�" , "�Ѯv" , "¾��" , "�޲z��" }; 
        	String identity =(String) JOptionPane.showInputDialog(null,"�п�J�A������:","���U�t��",3,null,strArray,strArray[0]);
		if (identity ==null) { set = 0; break;}
        
        	String ID =JOptionPane.showInputDialog(null,"�п�J�A��ID:","���U�t��",3);
        	if (ID ==null) { set = 0; break;}

        	String password =JOptionPane.showInputDialog(null,"�п�J�A���K�X:","���U�t��",3);
		if (password ==null) { set = 0; break;}
		
		set = 0;
	
        member3 m3=null;
        if (identity.compareTo("�ǥ�")==0){
            	m3 = new student(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"���U�����A���z�ϥδr��","���\",1);
        }     
        else if (identity.compareTo("�޲z��")==0){
            	m3 = new admin(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"���U�����A���z�ϥδr��","���\",1); 
        }           
        else if (identity.compareTo("¾��")==0){
            	m3 = new staff(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"���U�����A���z�ϥδr��","���\",1);
        }             
        else if (identity.compareTo("�Ѯv")==0){
            	m3 = new teacher(name,password,ID,identity);
            	users.add(m3);
            	JOptionPane.showMessageDialog(null,"���U�����A���z�ϥδr��","���\",1);
        }
                   
        else{
	    	JOptionPane.showMessageDialog(null,"��J���~!�ЦA�դ@��","����",2);	
            
        }
      }	
    }

    public static String profile(){
        String ID=JOptionPane.showInputDialog(null,"�w���_���A�ЦA��J�@��ID:","�ӤH���",1);
        return ID;
    }

}
