/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu.scheduling2;

import java.util.ArrayDeque;
import java.util.Arrays;
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
        return prosess;
    }
    
    public static List<Process> Priority(List<Process>prosess){
        return prosess;
    }
    
    public static List<Process> RoundRobin(List<Process>prosess , int quantum){
       return prosess;
    }
    
}
