import Problem.EinsteinRiddle;
import Problem.MapColoring;
import Problem.Node;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

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

}
