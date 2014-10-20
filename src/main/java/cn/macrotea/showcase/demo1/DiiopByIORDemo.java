package cn.macrotea.showcase.demo1;

import cn.macrotea.showcase.config.ServerConfig;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.Session;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 使用IOR (Interoperable Object Reference) 连接Domino,可以不用load HTTP服务
 * <p/>
 * IOR的位置在d:\Lotus\Domino\Data\domino\html\diiop_ior.txt
 * <p/>
 * 将包含 "IOR" 的整句内容copy下来
 *
 * @author
 */
public class DiiopByIORDemo {

    public static final String DIIOP_IOR_PATH = "C:\\Domino\\Data\\domino\\html\\diiop_ior.txt";

    /**
     * 用分配一个IOR的方式来创建session
     */
    public void assignIOR() throws Exception {
        // 注意这个是我的本地Domino Server 上的IOR 内容，请不要照抄 :)
        String IOR = getIORText();
        //String IOR = "IOR:0101b1002900000049444c3a6c6f7475732f646f6d696e6f2f636f7262612f494f626a6563745365727665723a312e3000000000010000000000000070000000010101000e0000003139322e3136382e302e31363000acf6310000000438353235363531612d656336382d313036632d656565302d303037653264323233336235004c6f7475734e4f490100010000000100000001000000140000000101b10001000105000000000001010000000000";
        try {
            Session s = NotesFactory.createSessionWithIOR(IOR, ServerConfig.user, ServerConfig.password);
            String p = s.getPlatform();
            System.out.println("Platform = " + p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得ior的文本内容
     */
    public static String getIORText() throws Exception {
        FileInputStream fin = new FileInputStream(DIIOP_IOR_PATH);
        InputStreamReader fisr = new InputStreamReader(fin);
        BufferedReader br = new BufferedReader(fisr);
        String ior = br.readLine();
        fin.close();
        return ior;
    }

    /**
     * 用从Domino server 请求IOR的方式 来建立 session
     */
    public void requestIOR() {
        try {
            String IOR = NotesFactory.getIOR(ServerConfig.host);
            Session s = NotesFactory.createSessionWithIOR(IOR, ServerConfig.user, ServerConfig.password);
            String p = s.getPlatform();
            System.out.println("Platform = " + p);
        } catch (NotesException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        DiiopByIORDemo t = new DiiopByIORDemo();
        t.assignIOR();
        t.requestIOR();
    }

}
