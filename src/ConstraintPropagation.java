import Constrains.IConstrain;
import Problem.Node;

import java.util.ArrayList;

public class ConstraintPropagation implements IMethod{

    ArrayList<int[]> result;
    Node[] nodes;
    ArrayList<ArrayList<int[]>> domainStacks;
    ArrayList<Integer> indexToSearch;
    IOrderHeuristic orderHeuristic;
    IValueHeuristic valueHeuristic;

    ResultAnalysis resultAnalysis;//Analysis

    public ArrayList<int[]> solvePoblem(Node[] AllNodes, IOrderHeuristic orderHeuristic,IValueHeuristic valueHeuristic, String fileName){

        resultAnalysis = new ResultAnalysis();//Analysis
        resultAnalysis.setStartTime(System.nanoTime());//Analysis
        resultAnalysis.setMethodName("ConstraintPropagation");//Analysis

        result = new ArrayList<>();
        indexToSearch = new ArrayList<>();
        domainStacks= new ArrayList<>();
        this.orderHeuristic = orderHeuristic;
        this.valueHeuristic = valueHeuristic;

        for(int i = 0; i<AllNodes.length; i++){
            indexToSearch.add(i);
            domainStacks.add(new ArrayList<>());
            domainStacks.get(i).add(AllNodes[i].getDomain().clone());
        }
        nodes = AllNodes;
        search(0);
        System.out.println(" Prolem return "+result.size()+"  solutions \n");

        resultAnalysis.setEndTime(System.nanoTime());//Analysis
        resultAnalysis.setResult(result);//Analysis
        resultAnalysis.printResultAnalysis();//Analysis
        resultAnalysis.saveToFile(fileName);//Analysis

        return result;
    }

    public void search(int index){
            resultAnalysis.increasOneAllNodeNumbers();//Analysis

            int[] chosedValuesOrder = valueHeuristic.sortedDomein(domainStacks.get(index).get(0));//heuristic
            for (int v : chosedValuesOrder) {//zerowa dziedzina ma najnowsze

                nodes[index].setValue(v);
                indexToSearch.remove(new Integer(index));

                //adding new domain
                for(int i:indexToSearch){
                    domainStacks.get(i).add(0,domainStacks.get(i).get(0).clone());
                }

                boolean isGoingBack = false;

                for(IConstrain constrain :nodes[index].getConstrains()){
                       Node secondNode = constrain.getSecondNode();
                        int secondIndex = indexOfNode(secondNode);

                        if(nodes[secondIndex].getValue()==-1){
                            ArrayList<Integer> newDomain = new ArrayList<>();

                            chosedValuesOrder = valueHeuristic.sortedDomein(domainStacks.get(secondIndex).get(0));//heuristic
                            for(int sd : chosedValuesOrder){
                                nodes[secondIndex].setValue(sd);
                                if(constrain.isFulFilled()){
                                    newDomain.add(sd);
                                }
                            }
                            nodes[secondIndex].setValue(-1);
                            if(newDomain.isEmpty()){
                                isGoingBack = true;
                                break;
                            }
                            int [] newTable = new int[newDomain.size()];
                            for(int i=0;i<newDomain.size();i++){
                                newTable[i]=newDomain.get(i);
                            }
                            domainStacks.get(secondIndex).set(0,newTable);
                        }
                }

                if(!isGoingBack ){
                    if (indexToSearch.isEmpty()) {
                        extractSolution();
                        if(result.size()==1){//Analysis
                            resultAnalysis.setFirstResultTime(System.nanoTime());//Analysis
                        }//Analysis
                    }else {
                        int nextIndex = orderHeuristic.nextIndex(indexToSearch);
                        //search(nextIndex);
                        search(indexToSearch.get(0));
                    }
                }

                //przywracanie przy powrocie
                for(int i:indexToSearch){
                    domainStacks.get(i).remove(0);
                }
                nodes[index].setValue(-1);
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
    private int indexOfNode(Node node){
        for (int i=0;i< nodes.length;i++){
            if(node == nodes[i]){
                return i;
            }
        }
        return -1;
    }

}
