import java.util.ArrayList;

import javax.swing.JOptionPane;

public class memberchoice {
    public void choice(member3 a){
        library library = new library();
        int helper=0;
        int helper2 =0;
        String [ ] options={"1.增加書籍","2.移除書籍","3.更換書籍","4.查詢書籍","5.離開"};
        String [ ] options2={"1.查詢書籍","2.還書","3.個人資料","4.借閱紀錄","5.離開"};
        String [ ] options3={"是的","不是"};
        if(a.getIdentity().compareTo("管理員")==0){
            do{
                int ans=JOptionPane.showOptionDialog(null,"管理員你好，工作加油\n請選擇：","圖書館",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
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
                            JOptionPane.showMessageDialog(null,"查無此書","查詢書籍系統",0);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"查詢結果:\n"+lib,"查詢書籍系統",1);
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
                int ans2=JOptionPane.showOptionDialog(null,"您好，歡迎您登入圖書館\n請選擇：","圖書館",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);             
                helper2=ans2;
                switch (ans2) {
                    case 0:
                        librarybook lib=library.checkbook(); 
                        if(lib==null){
                            JOptionPane.showMessageDialog(null,"查無此書","查詢系統",0);
                           // System.out.println("是否查其他書籍");  //not finish
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"查詢結果:\n"+lib,"查詢書籍系統",1);
                            int ans3=JOptionPane.showOptionDialog(null,"是否借閱該書籍","借閱系統",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options3,options3[0]);
                            if(ans3==0){                                    
                                librarybook lb2= a.borrow(lib,a);
                                if(lb2==null){
                                    JOptionPane.showMessageDialog(null,a.getErrorReason());
                                }
                                else{
                                    String Borrowbook = lb2.getName();
                                    JOptionPane.showMessageDialog(null,Borrowbook+"已成功被借閱","借閱系統",1);
                                }
                            }  
                        }
                        break;
                    case 1:
                            String bookname=JOptionPane.showInputDialog(null,"請輸入要歸還的書名:","還書系統",3);
                            boolean found =a.returnbook(bookname);
                            if(found==true){
                                JOptionPane.showMessageDialog(null,"成功還書","還書系統",1);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"查無借閱紀錄","還書系統",0);
                            }
                        break;
                    case 2: // ????
                        if(a.getID().equals(user.profile())){
                            String findname=a.getName();
                            String findidentity=a.getIdentity();
                            String findID=a.getID();
                            String findpassword=a.getPassword();
                            JOptionPane.showMessageDialog(null,"名字:"+findname+"\n身分:"+findidentity+"\nID:"+findID+"\n密碼:"+findpassword,"個人資料",1);
                        }
                        else{ JOptionPane.showMessageDialog(null,"偷看別人的個人資料是不好的喔!","個人資料",0); }
                        break;
                    case 3:
                        ArrayList<borrowbook> borrowlist = a.list();
                        String temp="";
                        if (borrowlist.size()>0){
                            for(int i=0;i<borrowlist.size();i++){
                                temp = temp + borrowlist.get(i) +'\n';
                            }
                          //  System.out.println(borrowlist.get(i));
                            JOptionPane.showMessageDialog(null,temp,"借閱紀錄",1); 
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"你的借閱紀錄竟然是空的?!\n快來開始借書吧!","借閱紀錄",1); 
                        }
                
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"歡迎下次再來","圖書館",1);
                    default:
                        break;
                }
            }  while(helper2!=4);            
        }
    }  
}
