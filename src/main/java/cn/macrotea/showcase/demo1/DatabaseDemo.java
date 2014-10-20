package cn.macrotea.showcase.demo1;

import cn.macrotea.showcase.config.ServerConfig;
import lotus.domino.*;

public class DatabaseDemo extends NotesThread {

    public void runNotes() {
        try {

            Session ss = NotesFactory.createSession(ServerConfig.host, ServerConfig.user, ServerConfig.password);

            DbDirectory dir = ss.getDbDirectory(null);

            String server = dir.getName();
            if (server.equals("")) {
                server = "Local";
            }

            System.out.println("Database directory list on server " + server + "\n");

            Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
            while (db != null) {
                String fn = db.getFileName();
                String title = db.getTitle();
                String fp = db.getFilePath();
                System.out.println(fn + " - " + fp + " - " + title);
                db = dir.getNextDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String argv[]) {
        new DatabaseDemo().start();
    }
}
