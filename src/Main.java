import org.mapdb.*;

import java.lang.reflect.Array;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        DB db = DBMaker.fileDB("data.db").checksumHeaderBypass().make();
        //System.out.println("Database names = " + db.getAllNames().toString());
        //System.out.println("Deleted map = " + db.get("DELETED_MAP"));
        HTreeMap deletedMap = db.get("infoMap");
        System.out.println(deletedMap.getKeys());
        Long fetchedItems = (Long)deletedMap.get("fetchedItems");
        

    }
}
