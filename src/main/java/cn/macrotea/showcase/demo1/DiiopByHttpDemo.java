package cn.macrotea.showcase.demo1;

import cn.macrotea.showcase.config.ServerConfig;
import lotus.domino.NotesFactory;
import lotus.domino.Session;

/**
 * This example demonstrates an application that makes remote (IIOP) calls. The
 * example requires the user to enter the name of the host Domino server and
 * optionally a user name and password. If a user name and password are not
 * supplied, the server must allow anonymous access
 * <p/>
 * 使用这种方式的前提是Domino 已经 load 了 HTTP, DIIOP 服务
 * <p/>
 * 如果未开启 HTTP 服务可以采用 IOR 的方式创建 session
 *
 * @author
 */
public class DiiopByHttpDemo implements Runnable {

    public static void main(String argv[]) {
        DiiopByHttpDemo t = new DiiopByHttpDemo();
        Thread nt = new Thread(t);
        nt.start();
    }

    public void run() {
        try {
            Session s = NotesFactory.createSession(ServerConfig.host, ServerConfig.user, ServerConfig.password);
            String p = s.getPlatform();
            System.out.println("Platform = " + p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
