import java.util.ArrayList;

import javax.swing.JOptionPane;

public class memberchoice {
    public void choice(member3 a){
        library library = new library();
        int helper=0;
        int helper2 =0;
        String [ ] options={"1.�W�[���y","2.�������y","3.�󴫮��y","4.�d�߮��y","5.���}"};
        String [ ] options2={"1.�d�߮��y","2.�ٮ�","3.�ӤH���","4.�ɾ\����","5.���}"};
        String [ ] options3={"�O��","���O"};
        if(a.getIdentity().compareTo("�޲z��")==0){
            do{
                int ans=JOptionPane.showOptionDialog(null,"�޲z���A�n�A�u�@�[�o\n�п�ܡG","�Ϯ��]",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                helper=ans;
                switch (ans) {
                    case 0:
                        a.addbook();
                        break;
                    case 1:
                        a.removebook();
                        break;
                    case 2:
                        a.changebook();
                        break;
                    case 3:
                        librarybook lib=a.checkbook();
                        if(lib==null){
                            JOptionPane.showMessageDialog(null,"�d�L����","�d�߮��y�t��",0);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"�d�ߵ��G:\n"+lib,"�d�߮��y�t��",1);
                        }
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
            }while(helper!=4);
        }
        else{
            do{
                int ans2=JOptionPane.showOptionDialog(null,"�z�n�A�w��z�n�J�Ϯ��]\n�п�ܡG","�Ϯ��]",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);             
                helper2=ans2;
                switch (ans2) {
                    case 0:
                        librarybook lib=library.checkbook(); 
                        if(lib==null){
                            JOptionPane.showMessageDialog(null,"�d�L����","�d�ߨt��",0);
                           // System.out.println("�O�_�d��L���y");  //not finish
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"�d�ߵ��G:\n"+lib,"�d�߮��y�t��",1);
                            int ans3=JOptionPane.showOptionDialog(null,"�O�_�ɾ\�Ӯ��y","�ɾ\�t��",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options3,options3[0]);
                            if(ans3==0){                                    
                                librarybook lb2= a.borrow(lib,a);
                                if(lb2==null){
                                    JOptionPane.showMessageDialog(null,a.getErrorReason());
                                }
                                else{
                                    String Borrowbook = lb2.getName();
                                    JOptionPane.showMessageDialog(null,Borrowbook+"�w���\�Q�ɾ\","�ɾ\�t��",1);
                                }
                            }  
                        }
                        break;
                    case 1:
                            String bookname=JOptionPane.showInputDialog(null,"�п�J�n�k�٪��ѦW:","�ٮѨt��",3);
                            boolean found =a.returnbook(bookname);
                            if(found==true){
                                JOptionPane.showMessageDialog(null,"���\�ٮ�","�ٮѨt��",1);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"�d�L�ɾ\����","�ٮѨt��",0);
                            }
                        break;
                    case 2: // ????
                        if(a.getID().equals(user.profile())){
                            String findname=a.getName();
                            String findidentity=a.getIdentity();
                            String findID=a.getID();
                            String findpassword=a.getPassword();
                            JOptionPane.showMessageDialog(null,"�W�r:"+findname+"\n����:"+findidentity+"\nID:"+findID+"\n�K�X:"+findpassword,"�ӤH���",1);
                        }
                        else{ JOptionPane.showMessageDialog(null,"���ݧO�H���ӤH��ƬO���n����!","�ӤH���",0); }
                        break;
                    case 3:
                        ArrayList<borrowbook> borrowlist = a.list();
                        String temp="";
                        if (borrowlist.size()>0){
                            for(int i=0;i<borrowlist.size();i++){
                                temp = temp + borrowlist.get(i) +'\n';
                            }
                          //  System.out.println(borrowlist.get(i));
                            JOptionPane.showMessageDialog(null,temp,"�ɾ\����",1); 
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"�A���ɾ\�������M�O�Ū�?!\n�֨Ӷ}�l�ɮѧa!","�ɾ\����",1); 
                        }
                
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"�w��U���A��","�Ϯ��]",1);
                    default:
                        break;
                }
            }  while(helper2!=4);            
        }
    }  
}
