package cn.macrotea.showcase.demo1;

import cn.macrotea.showcase.config.ServerConfig;
import lotus.domino.*;

public class DatabaseInfoDemo extends NotesThread {

    public static final String DB_NAME = "demo1.nsf";

    public void runNotes() {
        try {
            //64位的JRE可能不行
            //Exception in thread "Thread-0" java.lang.UnsatisfiedLinkError:C:\Windows\System32\nlsxbe.dll:Can 't load IA 32-bit .dll on a AMD 64-bit platform

            Session ss = NotesFactory.createSession(ServerConfig.host, ServerConfig.user, ServerConfig.password);

            Database db = ss.getDatabase(null, DB_NAME);

            // 获得所有表单,视图等
            System.out.println("All forms : " + db.getForms());
            System.out.println("All views : " + db.getViews());
            System.out.println("All documents : " + db.getAllDocuments());

            // 获得DocumentCollection
            DocumentCollection dc = db.getAllDocuments();
            System.out.println("All documents count : " + dc.getCount());

            // 遍历DocumentCollection
            for (int i = 1; i <= dc.getCount(); i++) {
                Document doc = dc.getNthDocument(i);
                System.out.println("document " + i + " : " + doc);
                System.out.println("document " + i + " XML : " + doc.generateXML());
                System.out.println("document " + i + " HttpURL : " + doc.getHttpURL());
                System.out.println("document " + i + " NotesURL : " + doc.getNotesURL());
            }
            System.out.println("Categories : " + db.getCategories());

            //获得特定的表单
            System.out.println("form : " + db.getForm("fieldForm"));

            //获得特定的View
            System.out.println("view : " + db.getView("nav"));

            ss.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String argv[]) {
        new DatabaseInfoDemo().start();
    }
}
