import java.util.Arrays;

public class FirstFitAlgorithm {

    public static void main(String[] args) {
        
        int[] blockSizes = {100, 500, 200, 300, 600, 150, 450}; 
        int[] processSizes = {212,417, 300, 426, 50, 300, 700}; 
        int totalBlocks = blockSizes.length;
        int totalProcesses = processSizes.length;

        
	for (int size : blockSizes) {
            if (size < 0) {
                System.out.println("Error: Block size cannot be negative.");
                return;
            }
        }
        for (int size : processSizes) {
            if (size < 0) {
                System.out.println("Error: Process size cannot be negative.");
                return; 
            }
        }
        
        int[] allocation = new int[totalProcesses];
        Arrays.fill(allocation, -1); 
        
        for (int processIndex = 0; processIndex < totalProcesses; processIndex++) {
            for (int blockIndex = 0; blockIndex < totalBlocks; blockIndex++) {
                if (blockSizes[blockIndex] >= processSizes[processIndex]) {
                    
                    allocation[processIndex] = blockIndex;

      
                    blockSizes[blockIndex] -= processSizes[processIndex];
                    break; 
                }
            }
        }

        
        System.out.println("Process No.\tProcess Size\tBlock Allocated");
        for (int processIndex = 0; processIndex < totalProcesses; processIndex++) {
            if (allocation[processIndex] != -1) {
                System.out.println((processIndex + 1) + "\t\t" + processSizes[processIndex] + "\t\tBlock " + (allocation[processIndex] + 1));
            } else {
                System.out.println((processIndex + 1) + "\t\t" + processSizes[processIndex] + "\t\tNot Allocated");
            }
        }
        
        System.out.println("\nRemaining Memory Blocks after Allocation:");
        for (int i = 0; i < totalBlocks; i++) {
            if (blockSizes[i] == 0) {
                System.out.println("Block " + (i + 1) + ": Fully Allocated");
            } else {
                System.out.println("Block " + (i + 1) + ": " + blockSizes[i] + " units left");
            }
        }
    }
}
