import Problem.Node;

import java.util.ArrayList;

public class Backtracking implements IMethod{

    ArrayList<Integer> indexToSearch;

    public ArrayList<int[]> solvePoblem(Node[] AllNodes){

        ArrayList<Node[]> solusion = new ArrayList<>();
        indexToSearch = new ArrayList<>();
        for(int i = 0; i<AllNodes.length; i++){
            indexToSearch.add(i);
        }
        indexToSearch.remove(new Integer(0));

        solusion= search(0,AllNodes, solusion);
        System.out.println(" Prolem return "+solusion.size()+"  solutions \n");
        ArrayList<int[]> result = new ArrayList<>();
        return result;

    }


    public static ArrayList<Node[]> search(int index, Node[]current,ArrayList<Node[]> result){

        //System.out.println("search ("+index );//+"--------->"+current[index].getDomain().length);
        if (index == current.length) {
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
            for (int v : current[index].getDomain()) {
                //System.out.println("search (" + index + ")_domain_v = " + v);

                current[index].setValue(v);
                if(current[index].areConstrainsFulfill()){
                    //System.out.println("return search" + result.size());
                    search(index + 1, current, result);
                }
                current[index].setValue(-1);
            }
        }
        return result;
    }

    private static Node[] copyNodeTab(Node[] oryginal){
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
