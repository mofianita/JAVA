import javax.swing.JOptionPane;

public class run {
    public static void main(String [] args){ 
       // library library = new library();
        memberchoice memberchoice = new memberchoice();
        member3 a = null;
        user user = new user();
        String [ ] options={"1.���U","2.�n�J","3.���}"};
        int choice=0;
        do{
           choice=JOptionPane.showOptionDialog(null,"�Ϯ��]�t�ΡG","�Ϯ��]",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
           switch (choice) {
                case 0:
                    user.Register();
                    break;
                case 1:
                    a =user.runlogin();
                    if(a==null){
                        //System.out.println("�b���αK�X���~!�Э��s��J");
                      //  JOptionPane.showMessageDialog(null,"�b���αK�X���~!�Э��s��J","�Ϯ��]",0);                        
                    }
                    else{
                        //System.out.println("�w��"+a.getName()+"�i�J�Ϯ��]�t��");
                       // JOptionPane.showMessageDialog(null,"�w��"+a.getName()+"�i�J�Ϯ��]�t��","�Ϯ��]",1);
                        memberchoice.choice(a);
                       
                    }
                    break;     
                case 2:
                    JOptionPane.showMessageDialog(null,"�w��U���A��","�Ϯ��]",1);    
                default:
                    break;
            }
        }while(choice!=2);
    }

}
