import domain.Account;
import domain.MyMfStream;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;
import org.junit.Test;

import java.util.Arrays;


public class MainTest {
    @Test
    @SneakyThrows
    public void testlombok(){
//       val  account = new Account("杨亚",100f);
//       account.setMoney(1000f);
//        System.out.println(account.toString());
//        Account account1 = new Account("杨亚",100f);
//        account1.setMoney(1000f);
//        if(account.equals(account1)){
//            @Cleanup MyMfStream myMfStream = new MyMfStream();
//            System.out.println("my stream is open!");
//            System.out.println(account1);
//        }
//        System.out.println(account.equals(account1));

        int[] i =new int[]{1,2,3};

        String[] s= new String[]{"1","2","3"};
        Account xx = new Account("陈凯琪", 522f);
        Account xx1 = new Account("陈凯琪", 522f);


        Account[]  a= new Account[]{xx,new Account("xxx",555f)};
        boolean b = xx == xx1;
        System.out.println("string".equals(new String("string")));
//        System.out.println(Arrays.toString(a));
    }
}
