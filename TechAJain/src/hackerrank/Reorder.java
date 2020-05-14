package hackerrank;

import java.util.*;

class Log {
    String key;
    String words;

    public Log(String key, String words) {
        this.key = key;
        this.words = words;
    }
}

/**

 Time O(NlogN) => N is the number of logs

 For each log line, we split the log and split the identifier and the remainingWords. If remaining words are comprised of
 integers we store it in an auxillary List integerLogs. Logs with alphabets are stored in a List of custom class type Log.
 We apply sorting in each element of list with the comparator. After all alphabet logs are sorted we append the integer logs
 at the end.

 */
public class Reorder {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {

        if(logFileSize == 1)
            return logLines;

        List<Log> logs = new ArrayList<>();
        List<String> integerLogs = new ArrayList<>();
        List<String> result = new ArrayList<>(logFileSize);

        for(String logLine: logLines) {

            String identifier = logLine.split(" ")[0];
            if(!Character.isDigit(logLine.charAt(identifier.length() + 1))) {
                logs.add(new Log(identifier, logLine.substring(identifier.length())));
            } else {
                integerLogs.add(logLine);
            }

        }

        Collections.sort(logs, (o1, o2) -> {
            if(o1.words.equals(o2.words)) {
                return o1.key.compareTo(o2.key);
            } else {
                return o1.words.compareTo(o2.words);
            }
        });

        for(Log logLine: logs) {
            result.add(logLine.key + logLine.words);
        }
        result.addAll(integerLogs);
        return result;
    }


    public static void main(String[] args) {
        List<String> logLines = new ArrayList<>();
        logLines.add("a1 9 2 3 1");
        logLines.add("g1 act car");
        logLines.add("zo4 4 7");
        logLines.add("ab1 off key dog");
        logLines.add("a8 act zoo");

        Reorder reorder = new Reorder();
        System.out.println(reorder.reorderLines(5, logLines).toString());
    }
}
