/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu.scheduling2;

/**
 *
 * @author elmnshawy
 */
public class Process {
    
    public static int numOfprocess = 0 ;
    private String processID;
    private int cpuTime;
    private int priority;
    private int turnaroundTime = 0;
    private int waitingTime = 0;

    public Process() {

    }

    public Process(String processID, int cpuTime) {
        this.processID = processID;
        this.cpuTime = cpuTime;
        numOfprocess++;
    }
    
    

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    
    

}
