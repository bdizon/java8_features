package com.company;
import java.io.File;
import java.io.FileFilter;
import java.net.URLEncoder;

// class implementation of interface
//public class JavaFileFilter implements FileFilter {
//    public boolean accept(File file) {
//        return file.getName().endsWith(".java");
//    }
//}

public class FirstLambda {


    public static void main(String[] args) {
	// write your code here
        // Anonymous class implementation of interface
//        FileFilter filter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//
//                return pathname.getName().endsWith(".java");
//            }
//        };

        // lambda expression implementation of interface
        FileFilter filterLambda = (File pathname) ->
                pathname.getName().endsWith(".java");

        String path = "C:\\Users\\bdizon\\IdeaProjects\\LambdaExpressions\\src\\com\\company";
//        path = URLEncoder.encode(path, "UTF-8");

//        create file dir to use the filefilter on
        File dir = new File(path);
        // get content of directory
//        File[] files = dir.listFiles(filter);
        File[] files = dir.listFiles(filterLambda);
        //check if files have been correctly read
        System.out.println("Number of files in directory: " + files.length);
        for (File f: files) {
            System.out.println(f);
        }
    }
}
