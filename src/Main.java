import org.mapdb.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {

        CommandLine commandLine;
        Option crawlDb           = Option.builder("crawldb").argName("crawldb").hasArg().desc("Please add the path to the crawldb data file").build();
        Options options          = new Options();
        CommandLineParser parser = new DefaultParser();
        options.addOption(crawlDb);
        System.out.println("options = " + options.toString());

        //handle command line arguments here
        if (args.length > 0) {

//            try {
//                //commandLine = parser.parse(options);
//
//                if (commandLine.hasOption("A")) {
//                    System.out.print("Option A is present.  The value is: ");
//                    System.out.println(commandLine.getOptionValue("A"));
//                }
//            }catch (ParseException exception) {
//                System.out.print("Parse error: ");
//                System.out.println(exception.getMessage());
//            }
        }

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
