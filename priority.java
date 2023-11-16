import java.util.*;
public class priority
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int i,j,temp;
		float awt=0,ata=0;
		System.out.println("Enter the number of processes: ");
		int n=sc.nextInt();
		int pid[]=new int[10];
		int pp[]=new int[10];
		int bt[]=new int[10];
		int wt[]=new int[10];
		int ta[]=new int[10];
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter burst time of process: "+(i+1));
			bt[i]=sc.nextInt();
			System.out.println("Enter the priority: ");
			pp[i]=sc.nextInt();
			pid[i]=i+1;
		}
		for(i=0;i<n-1;i++)
		{
			for(j=0;j<n;j++)
			{
				if(pp[i]>pp[j])
				{
					temp=pp[i];
					pp[i]=pp[j];
					pp[j]=temp;

					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;

					temp=pid[i];
					pid[i]=pid[j];
					pid[j]=temp;
				}
			}
		}
		wt[0]=0;
		ta[0]=bt[0];
		ata +=ta[0];
		for(i=1;i<n;i++)
		{
			wt[i]=ta[i-1];
			awt +=wt[i];
			ta[i]=wt[i]+bt[i];
			ata +=ta[i];
		}
		System.out.println("\nProcessId\tPriority\tBurstTime\tWaitTime\tTurnaroundTime  ");
		for(i=0;i<n;i++)
		{
			System.out.println(" "+pid[i]+"\t\t"+pp[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+ta[i]);
		}
		awt/=n;
		ata/=n;
		System.out.println("Average wait time is: "+awt);
		System.out.println("Average turnaround time is: "+ata);
	}
}