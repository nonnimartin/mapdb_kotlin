import org.mapdb.*;

public class Main {

    public static void main(String[] args) {
        DB db                          = DBMaker.fileDB("data.db").checksumHeaderBypass().make();
        Iterable<String> tableNames    = db.getAllNames();
        System.out.println("Table names = " + tableNames.toString());

        HTreeMap infoMap              = db.get("infoMap");
        HTreeMap finishedMap          = db.get("FINISHED_MAP");
        Iterable<String> finishedUrls = finishedMap.getKeys();

        for (String thisKey : finishedUrls){
            System.out.println("this key = " + thisKey);
        }

        System.out.println("Finished map = " + finishedUrls.toString());

        //System.out.println("Table names = " + db.getAllNames().toString());

        //These all appear to be empty in my own db
        /*
        HTreeMap justMap    = db.get("map");
        HTreeMap errorsMap  = db.get("ERRORS_MAP");
        HTreeMap deletedMap = db.get("DELETED_MAP");
         */

        //Info (mostly stats about the scan
        Long fetchedItems   = (Long)infoMap.get("fetchedItems");
        Long failedItems    = (Long)infoMap.get("failedItems");
        Long newItems       = (Long)infoMap.get("newItems");
        Long emittedItems   = (Long)infoMap.get("emittedItems");
        String startLinks   = infoMap.get("startLinks").toString();
        Long discardedItems = (Long)infoMap.get("discardedItems");



    }
}
