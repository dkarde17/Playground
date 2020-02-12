import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicConnectivityClient {
    private static final Logger logger = LoggerFactory.getLogger(DynamicConnectivityClient.class);
    public static void main(String[] args) {
        URL filePath = DynamicConnectivityClient.class.getClassLoader().getResource("UF.txt");
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(new File(filePath.toURI())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            int numberOfNodes = Integer.parseInt((fileReader.readLine()));
            UnionFInd quickFindUF = new QuickFindUF(numberOfNodes);
            AtomicIntegerArray arguments = new AtomicIntegerArray(2);
            fileReader.lines().forEach( x ->{
                if (x.startsWith("#"))
                    return;
                else if (x.startsWith("union")){
                    getValidArguments(x, arguments, numberOfNodes);
                    System.out.println(x + " : " + arguments.get(0) + " and " + arguments.get(1) + " joined!");
                    quickFindUF.union(arguments.get(0), arguments.get(1));
                } else if (x.startsWith("find")) {
                    getValidArguments(x, arguments, numberOfNodes);
                    if (quickFindUF.find(arguments.get(0), arguments.get(1)))
                        System.out.println(x + " : " + arguments.get(0) + " and " +  arguments.get(1) + " are connected!");
                    else System.out.println(x + " : " + arguments.get(0) + " and " +  arguments.get(1) + " are not connected!");
                } else {
                    throw new IllegalStateException("Line beginning not supported for line: " + x);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void getValidArguments(String line, AtomicIntegerArray arguments, int numberOfNodes) {
        assert(line.matches("((union)|(find))\\(\\d+,\\d+\\)"));
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        for (int i = 0; i < 2; i++) {
            matcher.find();
            int argument = Integer.parseInt(matcher.group());
            if (argument < numberOfNodes)
                arguments.set(i, argument);
            else throw new IllegalStateException("argument cannot be greater than then number of nodes! The index starts from 0. Line:["+line+"] Argument:["+argument+"]");
        }
    }
}
