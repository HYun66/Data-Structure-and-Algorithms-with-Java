import java.util.Arrays; 
import java.util.Scanner;
import java.util.Comparator; 
import java.text.DecimalFormat;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        
        ItemValue[] iVal = new ItemValue[values.length]; 
       
        for (int i = 0; i < values.length; i++) {
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        // Sorting items by unitValue
        Arrays.sort(iVal, new Comparator<ItemValue>() 
		{ 
			@Override
			public int compare(ItemValue item1, ItemValue item2) 
			{ 
				return item2.unitValue.compareTo(item1.unitValue); 
			} 
		}); 
        
        // Knapsack after sorting
        // double[] amount = new double[values.length];
        double totalValue = 0, remainedCapacity = capacity;
        for (ItemValue i : iVal){
            int currentWeight = (int)i.weight;
            int currentValue = (int)i.value;
            
            if (remainedCapacity == 0) {
                return Double.valueOf(df4.format(totalValue));
            }

            if (remainedCapacity >= currentWeight) {
                totalValue += currentValue;
                remainedCapacity -= currentWeight;
                currentWeight = 0;
                // amount[i] += currentWeight;
                

            } else {
                totalValue += remainedCapacity * currentValue / currentWeight;
                remainedCapacity = 0;
                currentWeight -= remainedCapacity;
                // amount[i] += remainedCapacity;
                

            }
        }

        return Double.valueOf(df4.format(totalValue));
    }

    // item value class 
	static class ItemValue 
	{ 
		Double unitValue; 
		double weight, value, index; 
		
		// item value function 
		public ItemValue(int weight, int value, int index) 
		{ 
			this.weight = (double)weight; 
			this.value = (double)value; 
			this.index = index; 
			this.unitValue = (this.value/this.weight); 
		} 
	} 

    private static DecimalFormat df4 = new DecimalFormat("#.####");

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
