import javax.swing.JOptionPane;

public class run {
    public static void main(String [] args){ 
       // library library = new library();
        memberchoice memberchoice = new memberchoice();
        member3 a = null;
        user user = new user();
        String [ ] options={"1.註冊","2.登入","3.離開"};
        int choice=0;
        do{
           choice=JOptionPane.showOptionDialog(null,"圖書館系統：","圖書館",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
           switch (choice) {
                case 0:
                    user.Register();
                    break;
                case 1:
                    a =user.runlogin();
                    if(a==null){
                        //System.out.println("帳號或密碼錯誤!請重新輸入");
                      //  JOptionPane.showMessageDialog(null,"帳號或密碼錯誤!請重新輸入","圖書館",0);                        
                    }
                    else{
                        //System.out.println("歡迎"+a.getName()+"進入圖書館系統");
                       // JOptionPane.showMessageDialog(null,"歡迎"+a.getName()+"進入圖書館系統","圖書館",1);
                        memberchoice.choice(a);
                       
                    }
                    break;     
                case 2:
                    JOptionPane.showMessageDialog(null,"歡迎下次再來","圖書館",1);    
                default:
                    break;
            }
        }while(choice!=2);
    }

}
