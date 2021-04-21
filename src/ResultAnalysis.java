import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResultAnalysis {

    private ArrayList<int[]> result = new ArrayList<>();

    private int resultSize;
    private int allNodesNumber;

    private double startTime; //in nanosecunds
    private double firstResultTime; //in nanosecunds
    private double endTime;

    private double firstFindngTimeLong; //how long it took to find first solution
    private double serchingAllTimeLong; //how long it took to find all solutions

    private String methodName;

    public ResultAnalysis(){
        resultSize = 0;
        allNodesNumber = 0;

        startTime = -1;
        firstResultTime = -1;
        endTime = -1;

        firstFindngTimeLong = -1;
        serchingAllTimeLong = -1;
    }

    public ArrayList<int[]> getResult() {
        return result;
    }
    public void setResult(ArrayList<int[]> result) {
        this.result = result;
        this.setResultSize(this.result.size());
    }

    public int getResultSize() {
        return resultSize;
    }
    public void setResultSize(int resultSize) {
        this.resultSize = resultSize;
    }

    public int getAllNodesNumber() {
        return allNodesNumber;
    }
    public void setAllNodesNumber(int allNodesNumber) {
        this.allNodesNumber = allNodesNumber;
    }
    public void increasOneAllNodeNumbers(){
        this.allNodesNumber = this.allNodesNumber+1;
    }

    public double getStartTime() {
        return startTime;
    }
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getFirstResultTime() {
        return firstResultTime;
    }
    public void setFirstResultTime(double firstResultTime) {
        this.firstResultTime = firstResultTime;
        this.setFirstFindngTimeLong(firstResultTime -startTime);
    }

    public double getEndTime() {
        return endTime;
    }
    public void setEndTime(double endTime) {
        this.endTime = endTime;
        this.setSerchingAllTimeLong(endTime-startTime);//Analysis
    }

    public double getFirstFindngTimeLong() {
        return firstFindngTimeLong;
    }
    public void setFirstFindngTimeLong(double firstFindngTimeLong) {
        this.firstFindngTimeLong = firstFindngTimeLong;
    }

    public double getSerchingAllTimeLong() {
        return serchingAllTimeLong;
    }
    public void setSerchingAllTimeLong(double serchingAllTimeLong) {
        this.serchingAllTimeLong = serchingAllTimeLong;
    }

    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }


    public void printResultAnalysis(){
        System.out.println("================================================");
        System.out.println("printResultAnalysis");

        System.out.println("Result size: "+this.resultSize);
        System.out.println("All nodes number: "+this.allNodesNumber);
        System.out.println("First finding: "+this.firstFindngTimeLong+" (*10^(-6) sekundy)");
        System.out.println("First all: "+this.serchingAllTimeLong+" (*10^(-6) sekundy)");
    }

    public void saveToFile(String fileName){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(this.resultSize+" ; "+this.allNodesNumber+" ; "+(long)this.firstFindngTimeLong+" ; "+(long)this.serchingAllTimeLong+"\n");

            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
