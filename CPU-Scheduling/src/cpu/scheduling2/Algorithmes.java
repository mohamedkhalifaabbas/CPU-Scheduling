/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu.scheduling2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algorithmes{
    
    
    
    public static List<Process> FCSA(List<Process> prosess ){
        
       
        int list_size = prosess.size();
        
        int currentTime = 0 ;
        for (int i = 0 ; i < list_size ; i++){
        
            int cpuTime =  prosess.get(i).getCpuTime(); 
            prosess.get(i).setWaitingTime(currentTime );
            prosess.get(i).setTurnaroundTime(prosess.get(i).getWaitingTime() + cpuTime );
            currentTime += cpuTime;
        }
         return prosess;
        
      
    }
    
    public static List<Process> SJF(List<Process> prosess ){
        
    List<Process> sortedProcesses = new ArrayList<>(prosess);
    sortedProcesses.sort(Comparator.comparingInt(Process::getCpuTime));

    int currentTime = 0;
    for (int i = 0; i < sortedProcesses.size(); i++) {
        Process process = sortedProcesses.get(i);
        process.setWaitingTime(currentTime);
        process.setTurnaroundTime(currentTime + process.getCpuTime());
        currentTime += process.getCpuTime();
    }
    return prosess;
    }
    
 
    
    public static List<Process> Priority(List<Process>prosess){
        
        List<Process> sortedProcesses = new ArrayList<>(prosess);
        sortedProcesses.sort(Comparator.comparingInt(Process::getPriority));

        int currentTime = 0;
        for (int i = 0; i < sortedProcesses.size(); i++) {
            Process process = sortedProcesses.get(i);
            process.setWaitingTime(currentTime);
            process.setTurnaroundTime(currentTime + process.getCpuTime());
            currentTime += process.getCpuTime();
        }


            return prosess;
        }

    public static List<Process> RoundRobin(List<Process>processes , int quantum){
   List<Process> processQueue = new ArrayList<>(processes); // Copy of the input list for manipulation
    int[] remainingTime = new int[processes.size()]; // Array to track remaining CPU time for each process
    int currentTime = 0; // Tracks the current time

    // Initialize remaining CPU time
    for (int i = 0; i < processes.size(); i++) {
        remainingTime[i] = processes.get(i).getCpuTime();
    }

    // Process execution loop
    boolean processesRemaining;
    do {
        processesRemaining = false;

        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);

            // If the process still has CPU time to execute
            if (remainingTime[i] > 0) {
                processesRemaining = true; // At least one process is still running

                // If the process can finish in this quantum
                if (remainingTime[i] <= quantum) {
                    currentTime += remainingTime[i]; // Add the remaining time to the current time
                    process.setWaitingTime(currentTime - process.getCpuTime()); // Calculate waiting time
                    process.setTurnaroundTime(currentTime); // Calculate turnaround time
                    remainingTime[i] = 0; // Mark as complete
                } else {
                    // If the process requires more than one quantum
                    currentTime += quantum; // Increase time by quantum
                    remainingTime[i] -= quantum; // Reduce remaining CPU time
                }
            }
        }
    } while (processesRemaining);

    return processes; // Return the updated list in the original order
    }
    
}
