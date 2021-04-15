import Problem.Node;

import java.util.ArrayList;

public class Backtracking implements IMethod{

    ArrayList<Integer> indexToSearch;
    IHeuristic heuristic;

    public ArrayList<int[]> solvePoblem(Node[] AllNodes,IHeuristic heuristic){

        ArrayList<Node[]> solusion = new ArrayList<>();
        this.heuristic = heuristic;

        indexToSearch = new ArrayList<>();
        for(int i = 0; i<AllNodes.length; i++){
            indexToSearch.add(i);
        }
        //indexToSearch.remove(new Integer(0));

        solusion= search(0,AllNodes, solusion);
        System.out.println(" Prolem return "+solusion.size()+"  solutions \n");
        ArrayList<int[]> result = new ArrayList<>();
        return result;

    }


    public ArrayList<Node[]> search(int index, Node[]current,ArrayList<Node[]> result){


        //System.out.println("search ("+index );//+"--------->"+current[index].getDomain().length);
        if (indexToSearch.isEmpty()) {//(index == current.length) {
            Node[] newCurrent = copyNodeTab(current);
            result.add(newCurrent);
            //System.out.println("return curent" + result.size()+"----------------------------------------------------");
            /*for (int i = 0; i< result.size();i++){
                System.out.print("\n"+"S"+i+"   ");
                for (int j = 0; j< result.get(i).length;j++){
                    System.out.print(result.get(i)[j].getValue()+", ");
                }
            }
             */
        } else {
            int[] chosedValuesOrder = heuristic.sortedDomein(current[index].getDomain());
            for (int v : chosedValuesOrder) {
                indexToSearch.remove(new Integer(index));
                //System.out.println("search (" + index + ")_domain_v = " + v);

                current[index].setValue(v);
                if(current[index].areConstrainsFulfill()){
                    //System.out.println("return search" + result.size());
                    //int nextIndex = heuristic.nextIndex(indexToSearch);
                    //search(nextIndex, current, result);
                    search(index + 1, current, result);
                }
                current[index].setValue(-1);
                indexToSearch.add(new Integer(index));
            }
        }
        return result;
    }

    private Node[] copyNodeTab(Node[] oryginal){
        Node[] copy = new Node[oryginal.length];
        for(int i=0; i< oryginal.length;i++){
            //System.out.println(copy[i]);
            //System.out.println(oryginal[i]);
            copy[i]= oryginal[i].cloneNode();
        }
        return copy;
    }

    private ArrayList<int[]> convertToIntArray(ArrayList<Node[]> solusion){
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<solusion.size();i++){
            int[] tab = new int[solusion.get(i).length];
            for(int n=0;n<solusion.get(i).length;n++){
                tab[n]=solusion.get(i)[n].getValue();
            }
            result.add(tab);
        }

        return result;
    }

}
