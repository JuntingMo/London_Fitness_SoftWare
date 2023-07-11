import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * The class which deals with the file progress
 * @author  Kehan Chen, Qilin Yang, Jingxuan Wang
 * @version 3.0
 */ 
public class ReadTxt {
    public static boolean check(String txtPath,String account,String password) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    String item[] = line.split(",");
                    if(item[0].equals(account)&&item[1].equals(password)){
                        MemberConfig.account=account;
                        MemberConfig.name=item[2];
                        MemberConfig.password=password;
                        MemberConfig.memberStatus=item[3];
                        MemberConfig.money= Integer.parseInt((item[4]));
                        bufferedReader.close();
                        return true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static boolean CheckAccount(String txtPath,String account) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    String item[] = line.split(",");
                    if(item[0].equals(account)) {
                        bufferedReader.close();
                        return false;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public static void writeTxt(String txtPath,String content){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if(file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeTxt1(String txtPath,String content){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if(file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modify(String txtPath,String account,String password,String name,String memberStatus,int money) {
        File file = new File(txtPath);
        String content="";
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    String item[] = line.split(",");
                    if(!item[0].equals(account)){
                        content+=line+"\n";
                    }

                }
                content=content+account+","+password+","+name+","+memberStatus+","+money+"\n";
                writeTxt1("Users.txt",content);
                MemberConfig.name=name;
                MemberConfig.memberStatus=memberStatus;
                MemberConfig.password=password;
                MemberConfig.money= (int) money;
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     }
    
    /**The method for the booking session to read and write.
	 * @param txtPath The path of txt file.
	 * @return boolean
	 * @author Jingxuan Wang
	 */
    public static boolean readtxtBooking (String txtPath) {
    	File file = new File(txtPath);
    	int i = 0;
    	if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    String item[] = line.split(",");
                    if(item[0].equals(MemberConfig.account)){
                    	i++;
                    	if (i > MemberConfig.a) {
                    		MemberConfig.str1 = item[1];
                            MemberConfig.str2 = item[2];
                            MemberConfig.str3 = item[3];
                            MemberConfig.str4 = item[4];
                            MemberConfig.str5 = item[5];
                            MemberConfig.a++;
                            bufferedReader.close();
                            return true;
                    	}
                    }
                }
                bufferedReader.close();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}