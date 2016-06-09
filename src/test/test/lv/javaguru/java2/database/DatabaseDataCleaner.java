package lv.javaguru.java2.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NightStranger on 6/8/2016.
 */
public interface DatabaseDataCleaner {

    default List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("users");
        tableNames.add("tasks");
        tableNames.add("teams");
        tableNames.add("task_types");
        tableNames.add("task_comments");
        return tableNames;
    }

    void cleanDatabase() throws DBException;

}
