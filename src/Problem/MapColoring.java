package Problem;

import Constrains.DifferendValueConstrain;
import Constrains.IConstrain;
import Problem.Node;

import java.util.ArrayList;
import java.util.Random;

public class MapColoring {

    private Node[] AllNodes;
    private int numberofPoints;

    public MapColoring(int numberOfColors, int numberofPoints,int maxX, int maxY) {
        this.numberofPoints=numberofPoints;
        //color domain for nodes
        int[] domain=new int[numberOfColors];
        for(int i=0;i<numberOfColors;i++){
            domain[i]=i;
        }
        //points
        ArrayList<int[]> Points = generatePoints(numberofPoints,maxX,maxY);

        //conections
        double[][][] Conections = generateAllConections(Points);
        //selection of Connections
        ArrayList<int[]> SelectedConnections = selectConnections(Conections,Points);

        //System.out.println("Wybor");
       // for(int i=0; i<SelectedConnections.size();i++){
            //System.out.println(SelectedConnections.get(i)[0]+" ; "+SelectedConnections.get(i)[1]);
        //}

        this.AllNodes= createAllNodes(Points,SelectedConnections,domain);
    }

    //points
    private ArrayList<int[]> generatePoints(int numberofPoints, int maxX, int maxY){
        ArrayList<int[]> Points = new ArrayList<int[]>();
        Random r = new Random();
        while(Points.size()<numberofPoints){
            int [] newPoint;
            int x = r.nextInt(maxX);//0
            int y = r.nextInt(maxY);//0
            newPoint = new int[]{x,y};

            if(!isPointInArray(newPoint, Points)){
                Points.add(newPoint);
            }
        }
        return Points;
    }
    public static boolean isPointInArray(int [] newPoint,ArrayList<int[]> Points){
        for(int i=0 ; i<Points.size();i++){
            if(Points.get(i)[0]==newPoint[0]){      // && Points.get(i)[1]==newPoint[1]){
                return true;
            }
        }
        return false;
    }

    //connect points
    private static double[][][] generateAllConections(ArrayList<int[]> Points){
        double[][][] Conections = new double[Points.size()][Points.size()][3];
        for(int a=0 ; a<Points.size();a++){
            Conections[a][a][0] = -1;
            Conections[a][a][1] = 0;
            Conections[a][a][2] = 0;

            for(int b=a+1 ; b<Points.size();b++){
                Conections[a][b][0]=Math.sqrt(Math.pow((Points.get(a)[0]-Points.get(b)[0]),2)+Math.pow((Points.get(a)[1]-Points.get(b)[1]),2));//distance |AB|
                Conections[a][b][1]=((double)(Points.get(a)[1]-Points.get(b)[1]))/(Points.get(a)[0]-Points.get(b)[0]);
                Conections[a][b][2]= Points.get(a)[1]-(((double)(Points.get(a)[1]-Points.get(b)[1]))/(Points.get(a)[0]-Points.get(b)[0]))*Points.get(a)[0];

                Conections[b][a][0] = Conections[a][b][0];
                Conections[b][a][1] = Conections[a][b][1];
                Conections[b][a][2] = Conections[a][b][2];

                //System.out.print(" a("+a+") , b("+b+") ;");
                //System.out.print(" Pa("+Points.get(a)[0]+" , "+Points.get(a)[1]+") ;");
                //System.out.print(" Pb("+Points.get(b)[0]+" , "+Points.get(b)[1]+") ; ");
                //System.out.println(Conections[a][b][0]+" ; "+Conections[a][b][1]+" ; "+Conections[a][b][2]);

            }
        }

        return Conections;
    }

    //select connections
    private static ArrayList<int[]> selectConnections( double[][][] Conections, ArrayList<int[]> Points){
        ArrayList<int[]> SelectedConnections = new ArrayList<int[]>();

        while (!isEveryChecked(Conections)){
            //System.out.print("while "+Left(Conections));
            ArrayList<Integer>indexLeft = indexLeft(Conections);
            Random r = new Random();
            int indexSpot = r.nextInt(indexLeft.size());
            int index = indexLeft.get(indexSpot);
            //System.out.print(";  index "+index);

            indexLeft.remove(indexSpot);
            /*System.out.println();
            for(int i=0;i<indexLeft.size();i++){
                System.out.print(" ("+indexLeft.get(i)+"), ");
            }
            System.out.println();
             */
            indexSpot = r.nextInt(indexLeft.size());
            int minDistansIndeks = indexLeft.get(indexSpot);
            //System.out.print(";  minDistansIndeks "+minDistansIndeks);
            for(int i=0 ; i< Conections.length;i++){

                if(i!=index){
                    if(Conections[index][i][0]!=-1 ){
                        //System.out.println("\n min "+Conections[index][i][0]+" < "+Conections[index][minDistansIndeks][0]+" ? ");
                        if( Conections[index][i][0]<Conections[index][minDistansIndeks][0]){
                            minDistansIndeks = i;
                            //System.out.print(";  minDistansIndeks "+minDistansIndeks);
                        }
                    }
                }


            }
            //System.out.println(";  minDistansIndeks "+minDistansIndeks+" pol "+Conections[index][minDistansIndeks][0]);
            if(Conections[index][minDistansIndeks][0]!=-1){
                int[]Conection;
                if(index<minDistansIndeks){
                    Conection = new int[]{index,minDistansIndeks};
                }else{
                    Conection = new int[]{minDistansIndeks, index};
                }
                SelectedConnections.add(Conection);
                Conections[index][minDistansIndeks][0]=-1;
                Conections[minDistansIndeks][index][0]=-1;

                Conections = deleteCrossingConections(Conections,index,minDistansIndeks,Points);
            }
        }
        /*
        System.out.println("Wybor");
        for(int i=0; i<SelectedConnections.size();i++){
            System.out.println(SelectedConnections.get(i)[0]+" ; "+SelectedConnections.get(i)[1]);
        }
        */
        return SelectedConnections;
    }

    private static boolean isEveryChecked( double[][][] Conections ){
        for(int i=0;i<Conections.length;i++){
            for(int j=0;j<Conections[i].length;j++){
                if(Conections[i][j][0] != -1){
                    return false;
                }
            }
        }
        return true;
    }
    private static int Left( double[][][] Conections ){
        int count = 0;
        for(int i=0;i<Conections.length;i++){
            for(int j=0;j<Conections[i].length;j++){
                if(Conections[i][j][0] != -1){
                    count++;
                }
            }
        }
        return count;
    }

    private static ArrayList<Integer> indexLeft( double[][][] Conections ){
        ArrayList<Integer> indexLeft=new ArrayList<>();

        for(int i=0;i<Conections.length;i++){
            for(int j=0;j<Conections[i].length;j++){

                if(Conections[i][j][0] != -1){
                    //System.out.print(" ("+i+","+j+")="+Conections[i][j][0]+", ");
                    Integer newIndex = new Integer(i);
                    if(!indexLeft.contains(newIndex)){indexLeft.add(newIndex);}
                }
            }
        }
        /*
        System.out.println();
        for(int i=0;i<indexLeft.size();i++){
            System.out.print(" ("+indexLeft.get(i)+"), ");
        }
        System.out.println();
        */
        return indexLeft;
    }

    private static double[][][] deleteCrossingConections(double[][][] Conections, int indexA, int indexB, ArrayList<int[]> Points){
        //System.out.println("Delete");
        for(int i=0;i<Conections.length;i++){
            for(int j=0;j<Conections[i].length;j++){
                if(Conections[i][j][0] != -1 ){
                    int [] firstRange=calculateRange(Points.get(i)[0],Points.get(j)[0]);
                    int [] secondRange=calculateRange(Points.get(indexA)[0],Points.get(indexB)[0]);
                    if(areCrossing(Conections[i][j], Conections[indexA][indexB],firstRange,secondRange)){
                        Conections[i][j][0] = -1;
                    }
                }
            }
        }
        return Conections;
    }
    private static boolean areCrossing(double[] firstLine, double[] secondLine,int [] firstRange,int [] secondRange){
        //równolegle
        if(firstLine[1]==secondLine[1]){
            if(firstLine[2]==secondLine[2]){
                if(calculateRangeCrossing(firstRange,secondRange)!=null){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }

        int[] randeCrossing = calculateRangeCrossing(firstRange,secondRange);
        if(randeCrossing==null){
            return false;
        }

        double crossingX=(firstLine[2]-secondLine[2])/(secondLine[1]-firstLine[1]);

        if(randeCrossing[0]<=crossingX && crossingX<=randeCrossing[1]){
            return true;
        }else{
            return false;
        }
    }
    private static int[] calculateRange(int x1, int x2){
        int [] range;
        if(x1<x2){
            range= new int[]{x1, x2};
        }else{
            range= new int[]{x2, x1};
        }
        return range;
    }
    private static int[] calculateRangeCrossing(int [] firstRange,int [] secondRange){
        if(firstRange[1]==secondRange[1]) {
            if(firstRange[0]<=secondRange[0]) {
                return new int[]{secondRange[0], secondRange[1]};
            }else {
                return new int[]{firstRange[0], secondRange[1]};
            }
        }

        if(firstRange[1]<secondRange[1]){   //second konczy sie dalej
            if(firstRange[1]<secondRange[0]){
                return null;
            }
            if(secondRange[0]<firstRange[1] && firstRange[0]<secondRange[0]){
                return new int[]{secondRange[0], firstRange[1]};
            }
            if(secondRange[0]<firstRange[0]){
                return  new int[]{firstRange[0], firstRange[1]};
            }
        }else{
            if(secondRange[1]<firstRange[0]){
                return null;
            }
            if(firstRange[0]<secondRange[1] && secondRange[0]<firstRange[0]){
                return new int[]{firstRange[0], secondRange[1]};
            }
            if(firstRange[0]<secondRange[0]){
                return  new int[]{secondRange[0], secondRange[1]};
            }
        }
        return null;
    }

    //create Nodes
    private static Node[] createAllNodes(ArrayList<int[]> Points, ArrayList<int[]> SelectedConnections, int [] domain){
        //System.out.println("AllNodes");
        Node[]AllNodes = new Node[Points.size()];
        for(int p = 0; p<Points.size();p++) {
            Node newNode = new Node(domain);
            AllNodes[p]=newNode;
        }

        for(int p = 0; p<Points.size();p++){
            //System.out.println("Constrains "+p);
            ArrayList<IConstrain> nodesConstrains = new ArrayList<>();
            for(int c = 0; c<SelectedConnections.size();c++){
                int neighborIndex = getNeighborIndex(p,SelectedConnections.get(c));
                if(neighborIndex!=-1 && isRelevantConnection(p,SelectedConnections.get(c))){
                    IConstrain constrain = new DifferendValueConstrain(AllNodes[p],AllNodes[neighborIndex]);
                    nodesConstrains.add(constrain);
                }
            }
            IConstrain[] nodesConstrainsTab = new IConstrain[nodesConstrains.size()];
            for(int c = 0; c<nodesConstrains.size();c++){
                nodesConstrainsTab[c]=nodesConstrains.get(c);
            }
            AllNodes[p].setConstrains(nodesConstrainsTab);
        }
        //System.out.println("end Nodes");


        return AllNodes;
    }
    private static boolean isRelevantConnection(int pointIndex, int[] conection){
        if(conection[0]==pointIndex||conection[1]==pointIndex){
            return true;
        }else{
            return false;
        }
    }
    private static int getNeighborIndex(int pointIndex, int[] conection){
        if(conection[0]==pointIndex){
            return conection[1];
        }
        if(conection[1]==pointIndex){
            return conection[0];
        }else{
            return -1;
        }
    }

    //getters
    public Node[] getAllNodes() {
        return AllNodes;
    }

    public int getNumberofPoints() {
        return numberofPoints;
    }

    public void setNumberofPoints(int numberofPoints) {
        this.numberofPoints = numberofPoints;
    }
}
