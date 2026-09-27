package stacks;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path){
        Stack<String> stack = new Stack<>();

        StringBuilder output = new StringBuilder();

        String[] dirList = path.split("/");

        for(String dir: dirList){
            if(dir.isEmpty()){
                continue;
            }

            // current directory
            if(dir.equals(".")){
                continue;
            }

            // previous directory
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }

            stack.push(dir);
        }

        // creating the canonical path
        while(!stack.isEmpty()){
            output.insert(0, "/" + stack.pop());
        }

        return output.length() == 0 ? "/" : output.toString();
    }

    public static void main(String[] args){
        String path = "/home//foo/";

        System.out.println(simplifyPath(path));
    }
}
