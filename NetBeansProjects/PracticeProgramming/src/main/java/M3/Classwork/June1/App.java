///*
//Created by: Margaret Donin
//Date created:
//Date revised:
//*/
//
//package M3.Classwork.June1;
//
//import static M3.Classwork.June1.LineNumber.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import static java.lang.Integer.parseInt;
//import java.util.Scanner;
//
//
//public class App {
//    private String mapName = "";
//    private int simulationsToRun = "";
//    
//    public static void main(String[] args) throws Exception{
//        int[][] map = getMap();
//    }
//    
//    public int[][] getMap(){
//
//        Scanner scanner;
//        scanner = new Scanner(new BufferedReader(new FileReader("MouseIslandTestMap.txt")));
//        
//        String currentLine;
//        int lineNumber = 0;
//        int width = 0;
//        int height = 0;
//
//        int[][] map;
//        int index = 0;
//        
//        while (scanner.hasNextLine()) {
//            currentLine = scanner.nextLine();
//            
//            switch(lineNumber){
//                case 0:
//                    mapName = currentLine;
//                    break;
//                    
//                case 1:
//                    simulationsToRun = currentLine;
//                    break;
//                    
//                case 2:
//                    width = parseInt(currentLine);
//                    break;
//                    
//                case 3:
//                    height = parseInt(currentLine);
//                    break;
//                    
//                default: 
//                    for(int i = 0; i < width; i += 2){
//                        map[index][i] = currentLine.charAt(i);
//                    }
//                
//            }
//            
//            if(width != 0 && height != 0){
//                map = new int[height][width];
//            }
//            
//            lineNumber ++;
//        }
//        // close scanner
//        scanner.close();
//        
//        return map;
//    }
//}
