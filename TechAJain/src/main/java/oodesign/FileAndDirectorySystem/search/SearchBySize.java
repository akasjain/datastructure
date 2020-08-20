package main.java.FileAndDirectorySystem.search;

import main.java.FileAndDirectorySystem.Directory;
import main.java.FileAndDirectorySystem.Entry;

public class SearchBySize implements SearchCriteria {

    // Assuming top level provided data is directory (not file)
    private Directory directory;

    public SearchBySize(Directory directory) {
        this.directory = directory;
    }

    @Override
    public SearchResponse search(String value) {
        return search(value, directory);
    }

    public SearchResponse search(String fileName, Directory path) {
        for (Entry e : path.getEntries()) {

            // add code stub here
        }
        return new SearchResponse(null, "404");
    }
}
