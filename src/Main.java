import Problem.EinsteinRiddle;
import Problem.MapColoring;
import Problem.Node;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<int[]> result= new ArrayList<>();


        //Methods
        IMethod backtracking = new Backtracking();
        IMethod constraintPropagation = new ConstraintPropagation();
        IMethod ac3 = new AC3();

        //problems
        EinsteinRiddle einsteinRiddle = new EinsteinRiddle();
        MapColoring mapProblem3 = new MapColoring(3,3,30,30);
        MapColoring mapProblem4 = new MapColoring(3,4,30,30);
        MapColoring mapProblem6 = new MapColoring(3,6,30,30);
        MapColoring mapProblem8 = new MapColoring(3,8,30,30);
        MapColoring mapProblem10 = new MapColoring(3,10,30,30);
        MapColoring mapProblem12 = new MapColoring(3,12,30,30);
        MapColoring mapProblem14 = new MapColoring(3,14,30,30);
        MapColoring mapProblem16 = new MapColoring(3,16,30,30);
        MapColoring mapProblem18 = new MapColoring(3,18,30,30);
        MapColoring mapProblem20 = new MapColoring(3,20,30,30);

        MapColoring[] mapProblems = new MapColoring[]{
                mapProblem3, mapProblem4, mapProblem6, mapProblem8,mapProblem10, mapProblem12,
                mapProblem14,mapProblem16,mapProblem18, mapProblem20
        };

        //heuristic
        IOrderHeuristic neighborOrderHeuristic = new NeighborOrderHeuristic();
        IValueHeuristic neighborValueHeuristic = new NeighborValueHeuristic();
        IOrderHeuristic randOrderHeuristic = new RandOrderHeuristic();
        IValueHeuristic randValueHeuristic = new RandValueHeuristic();

        //Results
        System.out.println("=======Neighbor Heuristic=======");
        System.out.println("Prolem1 -------------------");
        System.out.println("         Problem.EinsteinRiddle");

        //einsteinAnalysis();
        //mapAnalysisMethods(mapProblems,neighborOrderHeuristic,neighborValueHeuristic, "NN");
        //mapAnalysisMethods(mapProblems,neighborOrderHeuristic,randValueHeuristic, "NR");
        //mapAnalysisMethods(mapProblems,randOrderHeuristic,neighborValueHeuristic, "RN");
        //mapAnalysisMethods(mapProblems,randOrderHeuristic,randValueHeuristic, "RR");

    }



    public static void mapAnalysisMethods(MapColoring[] mapProblems, IOrderHeuristic neighborOrderHeuristic, IValueHeuristic neighborValueHeuristic, String fileName){
        ArrayList<int[]> result= new ArrayList<>();

        //Methods
        IMethod backtracking = new Backtracking();
        IMethod constraintPropagation = new ConstraintPropagation();
        IMethod ac3 = new AC3();


        for(MapColoring mapProblem: mapProblems) {
            saveToFile(mapProblem.getNumberofPoints(),"MB"+fileName+".txt");
            //System.out.println("backtracking");
            result = backtracking.solvePoblem(mapProblem.getAllNodes(), neighborOrderHeuristic, neighborValueHeuristic, "MB"+fileName+".txt");
            //printResult(result);
            result.clear();
        }

        //System.out.println("constraintPropagation");
        for(MapColoring mapProblem: mapProblems) {
            saveToFile(mapProblem.getNumberofPoints(),"MP"+fileName+".txt");
            result = constraintPropagation.solvePoblem(mapProblem.getAllNodes(), neighborOrderHeuristic, neighborValueHeuristic, "MP"+fileName+".txt");
            //printResult(result);
            result.clear();
        }

        //System.out.println("ac3");
        for(MapColoring mapProblem: mapProblems) {
            saveToFile(mapProblem.getNumberofPoints(),"MA"+fileName+".txt");
            result = ac3.solvePoblem(mapProblem.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic,"MA"+fileName+".txt");
            //printResult(result);
            result.clear();
        }

    }
    public static void einsteinAnalysis(){
        ArrayList<int[]> result= new ArrayList<>();

        //Methods
        IMethod backtracking = new Backtracking();
        IMethod constraintPropagation = new ConstraintPropagation();
        IMethod ac3 = new AC3();

        //problems
        EinsteinRiddle problem1 = new EinsteinRiddle();
        MapColoring problem2 = new MapColoring(3,6,10,10);

        //heuristic
        IOrderHeuristic neighborOrderHeuristic = new NeighborOrderHeuristic();
        IValueHeuristic neighborValueHeuristic = new NeighborValueHeuristic();
        IOrderHeuristic randOrderHeuristic = new RandOrderHeuristic();
        IValueHeuristic randValueHeuristic = new RandValueHeuristic();

        //Results
        //System.out.println("=======Neighbor Heuristic=======");
        //System.out.println("Prolem1 -------------------");
        //System.out.println("         Problem.EinsteinRiddle");

        for(int i=0; i<10;i++) {
            //System.out.println("backtracking");
            result = backtracking.solvePoblem(problem1.getAllNodes(), neighborOrderHeuristic, neighborValueHeuristic, "EBNN.txt");
            //printResult(result);
            result.clear();
        }

        //System.out.println("constraintPropagation");
        for(int i=0; i<10;i++) {
            result = constraintPropagation.solvePoblem(problem1.getAllNodes(), neighborOrderHeuristic, neighborValueHeuristic, "EPNN.txt");
            //printResult(result);
            result.clear();
        }

        //System.out.println("ac3");
        for(int i=0; i<10;i++){
            result = ac3.solvePoblem(problem1.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic,"EANN.txt");
            //printResult(result);
            result.clear();
        }

    }

    public static void Lab2Presentation(){
/*
        ArrayList<int[]> result= new ArrayList<>();


        //Methods
        IMethod backtracking = new Backtracking();
        IMethod constraintPropagation = new ConstraintPropagation();
        IMethod ac3 = new AC3();

        //problems
        EinsteinRiddle problem1 = new EinsteinRiddle();
        MapColoring problem2 = new MapColoring(3,6,10,10);

        //heuristic
        IOrderHeuristic neighborOrderHeuristic = new NeighborOrderHeuristic();
        IValueHeuristic neighborValueHeuristic = new NeighborValueHeuristic();
        IOrderHeuristic randOrderHeuristic = new RandOrderHeuristic();
        IValueHeuristic randValueHeuristic = new RandValueHeuristic();

        //Results
        System.out.println("=======Neighbor Heuristic=======");
        System.out.println("Prolem1 -------------------");
        System.out.println("         Problem.EinsteinRiddle");

        System.out.println("backtracking");
        result=backtracking.solvePoblem(problem1.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();

        System.out.println("constraintPropagation");
        result = constraintPropagation.solvePoblem(problem1.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();
        System.out.println("ac3");
        result = ac3.solvePoblem(problem1.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();

        System.out.println("Prolem2 -------------------");
        System.out.println("         Problem.MapColoring");

        System.out.println("backtracking");
        result=backtracking.solvePoblem(problem2.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();

        System.out.println("constraintPropagation");
        result = constraintPropagation.solvePoblem(problem2.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();
        System.out.println("ac3");
        result = ac3.solvePoblem(problem2.getAllNodes(),neighborOrderHeuristic,neighborValueHeuristic);
        //printResult(result);
        result.clear();

        System.out.println("=======Rand Heuristic=======");
        System.out.println("Prolem1 -------------------");
        System.out.println("         Problem.EinsteinRiddle");

        System.out.println("backtracking");
        result=backtracking.solvePoblem(problem1.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();

        System.out.println("constraintPropagation");
        result = constraintPropagation.solvePoblem(problem1.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();
        System.out.println("ac3");
        result = ac3.solvePoblem(problem1.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();



        System.out.println("Prolem2 -------------------");
        System.out.println("         Problem.MapColoring");

        System.out.println("backtracking");
        result=backtracking.solvePoblem(problem2.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();
        System.out.println("constraintPropagation");
        result = constraintPropagation.solvePoblem(problem2.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();
        System.out.println("ac3");
        result = ac3.solvePoblem(problem2.getAllNodes(), randOrderHeuristic,randValueHeuristic);
        //printResult(result);
        result.clear();
*/
    }

    public static void printSolution(ArrayList<Node[]> solusion){
        System.out.println("Wynik");
        for (int i = 0; i< solusion.size();i++){
            System.out.print("\n"+"S"+i+"   ");
            for (int j = 0; j< solusion.get(i).length;j++){
                System.out.print(solusion.get(i)[j].getValue()+", ");
            }
        }
        System.out.println("\n");
    }

    public static void printResult(ArrayList<int[]> result){
        System.out.println("Wynik");
        for (int i = 0; i< result.size();i++){
            System.out.print("\n"+"S"+i+"   ");
            for (int j = 0; j< result.get(i).length;j++){
                System.out.print(result.get(i)[j]+", ");
            }
        }
        System.out.println("\n");
    }

    public static void saveToFile(int message, String fileName){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(message+" ; ");

            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
