package main;

import io.Read;

public class Main {
    
    public static void main(String[] args){
        Read lecture = new Read();
        lecture.readFile("C:\\Users\\Caedes\\Dropbox\\Quentin&Martial&Romain&Etienne\\Genie Logiciel\\graph.txt");
        for(int i = 0 ; i < lecture.getLines().size() ; i++){
            System.out.println(lecture.getLines().get(i));
        }
    }
    
    
}
