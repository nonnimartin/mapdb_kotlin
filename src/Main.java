import org.mapdb.*;

import java.lang.reflect.Array;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        DB db                          = DBMaker.fileDB("data.db").checksumHeaderBypass().make();
        Iterable<String> databaseNames = db.getAllNames();
        System.out.println("Database names = " + db.getAllNames().toString());
        HTreeMap infoMap = db.get("infoMap");


        System.out.println(infoMap.getKeys());

        //Info (mostly stats about the scan
        Long fetchedItems   = (Long)infoMap.get("fetchedItems");
        Long failedItems    = (Long)infoMap.get("failedItems");
        Long newItems       = (Long)infoMap.get("newItems");
        Long emittedItems   = (Long)infoMap.get("emittedItems");
        String startLinks   = infoMap.get("startLinks").toString();
        Long discardedItems = (Long)infoMap.get("discardedItems");



    }
}
