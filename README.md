Usage:

Currently there is only one output available, which reports all data I'm collecting at the moment:

`-c <PATH_TO_FILE>` - Point to the crawldb data file you would like to inspect

Example:

`java -jar readCrawlDb.jar <PATH_TO_CRAWLDB_DATA_FILE>`

To build jar from source (if making changes):

Build the JAR file and then manually unzip and remove the META-INF/ECLIPSE_.RSA and META-INF/ECLIPSE_.SF files to avoid issues with signed jar dependencies. Once this is done, re-zip the files into a .jar file.
