import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.jgrapht.*;
//import org.jgrapht.graph.*;
import java.util.*;

public class LongestOrderedPath
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Read first line for # of Ordered Graphs to create
		File file = new File("sample-input.txt");
		Scanner scan = new Scanner(file);
		int instances = scan.nextInt();
		
		System.out.println(instances);
		// Perform operations on all instances
		for (int i = 0; i < instances; i++)
		{
			// constructs a directed graph with the specified vertices and edges
			int numVertices = scan.nextInt();
			System.out.print(numVertices);
			int numEdges = scan.nextInt();
			System.out.println(numEdges);

			Vector<ArrayList<Integer>> edge = new Vector<ArrayList<Integer>>();
			// Initializes graph
			for (int j = 0; j < numEdges; j++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				temp.add(scan.nextInt());
				temp.add(scan.nextInt());
				edge.add(temp);
//				System.out.println(edge);
			}
			
			ArrayList<Integer> vertexArray = new ArrayList<Integer>(numVertices);
			for (int j = 0; j < numVertices; j++)
			{
				vertexArray.add(0);
//				System.out.print(vertixSize.get(j));
			}
			
//			for (Vector<ArrayList<Integer>> x : edge)
			for (int j = 0; j < edge.size(); j++)
			{
//				if (edge.get(j).get(1) < edge.get(j).get(0) + 1)
				boolean state = vertexArray.get(edge.get(j).get(1) - 1) < vertexArray.get(edge.get(j).get(0) - 1) + 1;
//				int temp1 = vertexArray.get(edge.get(j).get(1) - 1);
//				int temp2 = vertexArray.get(edge.get(j).get(0) - 1) + 1;
//				System.out.println("temp1: " + temp1 + "\ttemp2: " + temp2);
				if (vertexArray.get(edge.get(j).get(1) - 1) < vertexArray.get(edge.get(j).get(0) - 1) + 1)
				{
//					System.out.print("edge.get(j).get(1): " + (edge.get(j).get(1) - 1) + " ");
					vertexArray.set((edge.get(j).get(1)) - 1, (vertexArray.get(edge.get(j).get(0) - 1)) + 1);	//edge.get(j).get(0) - 1
				}
//				System.out.println();
			}
			
			System.out.println(vertexArray);
		}
		
		scan.close();
	}

}
