import org.mapdb.*;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {

        Options options = new Options();
        Option input    = new Option("c", "crawldb", true, "Points to the crawldb file you wish to inspect");
        input.setRequired(true);
        options.addOption(input);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter  = new HelpFormatter();
        // initializing the CommandLine obj
        CommandLine cmd    = null;
        String crawldbPath = new String();

        //handle command line arguments here
        if (args.length > 0) {
            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                System.out.println(e.getMessage());

                System.exit(1);
            }
            crawldbPath = cmd.getOptionValue("crawldb");
        }
        DB db                          = DBMaker.fileDB(crawldbPath).checksumHeaderBypass().make();
        Iterable<String> tableNames    = db.getAllNames();
        HTreeMap infoMap              = db.get("infoMap");
        HTreeMap finishedMap          = db.get("FINISHED_MAP");
        Iterable<String> finishedUrls = finishedMap.getKeys();

        System.out.println("Finished files:");
        for (String thisKey : finishedUrls){
            System.out.println(thisKey);
        }

        System.out.println("Table names = " + db.getAllNames().toString());

        //These all appear to be empty in my own db

//        HTreeMap justMap    = db.get("map");
//        HTreeMap errorsMap  = db.get("ERRORS_MAP");
//        HTreeMap deletedMap = db.get("DELETED_MAP");

        //Info (mostly stats about the scan
        Long fetchedItems   = (Long)infoMap.get("fetchedItems");
        Long failedItems    = (Long)infoMap.get("failedItems");
        Long newItems       = (Long)infoMap.get("newItems");
        Long emittedItems   = (Long)infoMap.get("emittedItems");
        String startLinks   = infoMap.get("startLinks").toString();
        Long discardedItems = (Long)infoMap.get("discardedItems");



    }
}
