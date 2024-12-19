/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu.scheduling2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
        return prosess;
    }
    
    public static List<Process> RoundRobin(List<Process>prosess , int quantum){
       return prosess;
    }
    
}
