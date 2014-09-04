/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 3, Problem 4.15
Input: User inputs a set of floating-point data values
Process: Calculates the count, the average, and the standard deviation
Output: Prints the count, average, and standard deviation of the data set
*/
import java.util.Scanner; //Scanner for input
import java.util.ArrayList; //ArrayList for storing the data
public class A3P415 {
    static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Float> dataSet = getInputDataSet();
        float sum = Summation(dataSet,1);
        float average = GetAverage(dataSet);
        float standardDeviation = GetStandardDeviation(dataSet);
        Display(dataSet,sum,average,standardDeviation);
    }
    /**
     * Method asks user for input on a dataSet which consists of floating point values
     * @return the array list that contains the data set
     */
    static ArrayList<Float> getInputDataSet(){
        boolean endInput = false;
        ArrayList<Float> dataSet = new ArrayList<>();
        System.out.println("Enter floating-point values below. Mark the end with a \'/\'");
        while(!endInput){ //master loop to control when to end input
            if(In.hasNextFloat()) //If the input is a float
                dataSet.add(In.nextFloat()); //Add the float to the set
            else if(In.hasNext()){ //If the input is a string
                if(In.next().charAt(0) == '/') //If the string's first char is /
                    endInput = true; //endInput is true, thus the input ends
            }
        }
        return dataSet;
    }
    /**
     * Method computes the average of the data set
     * @param dataSet the array list of data
     * @return the average of the data set
     */
    static float GetAverage(ArrayList<Float> dataSet){
        return Summation(dataSet,1) / dataSet.size();
    }
    /**
     * Method computes the sum of the data set to whatever power
     * @param dataSet the data array list
     * @param power whatever power each data will be before summation
     * @return the summation of the data set
     */
    static float Summation(ArrayList<Float> dataSet, double power){
        float sum = 0;
        for(float data : dataSet){
            sum += Math.pow(data, power);
        }
        return sum;
    }
    /**
     * Method computes the standard deviation of the data set
     * @param dataSet the data set in an array list
     * @return the standard deviation as a float
     */
    static float GetStandardDeviation(ArrayList<Float> dataSet){
        int size = dataSet.size();
        float sumOfDataSquared = Summation(dataSet,2);
        float sumSquaredOfData = (float)Math.pow(Summation(dataSet,1),2);
        float deviationTop = sumOfDataSquared - (sumSquaredOfData / size);
        return (float)Math.pow((deviationTop / (size - 1)),0.5);
    }
    /**
     * Method displays the data set, sum, average, and standard deviation
     * @param dataSet data set as an array list of floats
     * @param sum sum of the data as a float
     * @param average average of the data as a float
     * @param standardDeviation  standard deviation of the data as a float
     */
    static void Display(ArrayList<Float> dataSet, float sum, float average, float standardDeviation){
        int count = dataSet.size();
        System.out.println("Data Set: ");
        for(float data : dataSet){
            System.out.println(data);
        }
        System.out.println("Count: " + count);
        System.out.printf("Sum: %.4f",sum);
        System.out.printf("Average: $.4f",average);
        System.out.printf("Standard Deviation: %.4f\n",standardDeviation);
    }
}

/*
Enter floating-point values below. Mark the end with a '/'
1
2
3

4
a
s
dfe
;
5
-6
7.2
8.3339
asdf
45354bbbb
-9.1234
10.11
/
Data Set: 
1.0
2.0
3.0
4.0
5.0
-6.0
7.2
8.3339
-9.1234
10.11
Count: 10
Sum: 25.5205
Average: 2.55205
Standard Deviation: 6.0792
*/