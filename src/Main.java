import org.mapdb.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        DB db = DBMaker.fileDB("data.db").make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();
        System.out.println(map.toString());
    }
}
