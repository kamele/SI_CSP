import Constrains.IConstrain;
import Problem.Node;

import java.util.ArrayList;

public class AC3 implements IMethod{

    ArrayList<int[]> result;
    Node[] nodes;
    ArrayList<Integer> indexToSearch;
    IOrderHeuristic orderHeuristic;
    IValueHeuristic valueHeuristic;
    ResultAnalysis resultAnalysis;//Analysis

    public ArrayList<int[]> solvePoblem(Node[] AllNodes, IOrderHeuristic orderHeuristic,IValueHeuristic valueHeuristic, String fileName){

        resultAnalysis = new ResultAnalysis();//Analysis
        resultAnalysis.setStartTime(System.nanoTime());//Analysis
        resultAnalysis.setMethodName("AC3");//Analysis

        result = new ArrayList<>();
        indexToSearch = new ArrayList<>();
        this.orderHeuristic = orderHeuristic;
        this.valueHeuristic = valueHeuristic;

        for(int i = 0; i<AllNodes.length; i++){
            indexToSearch.add(i);
        }
        nodes = AllNodes;
        search(0,nodes,result,indexToSearch);
        System.out.println(" Prolem return "+result.size()+"  solutions \n");

        resultAnalysis.setEndTime(System.nanoTime());//Analysis
        resultAnalysis.setResult(result);//Analysis
        resultAnalysis.printResultAnalysis();//Analysis
        resultAnalysis.saveToFile(fileName);//Analysis

        return result;

    }

    public boolean AC3(){
        ArrayList<IConstrain> constrains = new ArrayList<>();
        for(Node node : nodes){
            for(IConstrain c:node.getConstrains()){
                constrains.add(c);
            }
        }

        while(!constrains.isEmpty()){
            IConstrain constrain = constrains.get(0);
            constrains.remove(0);
            if(cleanDomain(constrain)){
                if(constrain.getFirstNode().getDomain().length==0)return false;
                for(IConstrain firstConstrain:constrain.getFirstNode().getConstrains()){
                    for(IConstrain neightborConstrain:firstConstrain.getSecondNode().getConstrains()){
                        if(neightborConstrain.getSecondNode()==constrain.getFirstNode()){
                            constrains.add(neightborConstrain);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean cleanDomain(IConstrain constrain){
        boolean cleaned = false;
        ArrayList<Integer> newDomain = new ArrayList<>();

        for (int v: constrain.getFirstNode().getDomain()){
            boolean existSatify = false;
            constrain.getFirstNode().setValue(v);

            for (int sv: constrain.getSecondNode().getDomain()){
                constrain.getSecondNode().setValue(sv);
                if(constrain.isFulFilled()){
                    existSatify=true;
                }
            }

            if(existSatify){
                newDomain.add(v);
            }
        }

        constrain.getSecondNode().setValue(-1);
        constrain.getFirstNode().setValue(-1);


        if(newDomain.size()==constrain.getFirstNode().getDomain().length){
            return false;
        }

        int [] newTable = new int[newDomain.size()];
        for(int i=0;i<newDomain.size();i++){
            newTable[i]=newDomain.get(i);
        }

        constrain.getFirstNode().setDomain(newTable);

        return true;
    }

    public void search(int index, Node[]current,ArrayList<int[]> result, ArrayList<Integer> indexToSearch){
            resultAnalysis.increasOneAllNodeNumbers();//Analysis

            int[] chosedValuesOrder = valueHeuristic.sortedDomein(current[index].getDomain());
            for (int v : chosedValuesOrder) {
                indexToSearch.remove(new Integer(index));
                current[index].setValue(v);

                if(current[index].areConstrainsFulfill()){
                    if (indexToSearch.isEmpty()) {
                        extractSolution();

                        if(result.size()==1){//Analysis
                            resultAnalysis.setFirstResultTime(System.nanoTime());//Analysis
                        }//Analysis
                    }else{
                        int nextIndex = orderHeuristic.nextIndex(indexToSearch);
                        search(nextIndex, current, result,indexToSearch);
                    }
                }
                current[index].setValue(-1);
                indexToSearch.add(index);
            }

    }


    private void extractSolution(){
        int[] solution = new int[nodes.length];
        for(int i=0; i< nodes.length; i++){
            solution[i]= nodes[i].getValue();
        }
        result.add(solution);
    }

}
