import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import org.jgrapht.*;
//import org.jgrapht.graph.*;
import java.util.*;

public class TestIterative
{

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		// Read first line for # of Ordered Graphs to create
		File inFile = new File("sample-input.txt");
		PrintWriter outFile = new PrintWriter("sample-output.txt", "UTF-8");
		Scanner scan = new Scanner(inFile);
		int instances = scan.nextInt();
		
//		System.out.println(instances);
		// Perform operations on all instances
		for (int i = 0; i < instances; i++)
		{
			// constructs a directed graph with the specified vertices and edges
			int numVertices = scan.nextInt();
//			System.out.print(numVertices);
			int numEdges = scan.nextInt();
//			System.out.println(numEdges);

			Vector<ArrayList<Integer>> edgeGraph = new Vector<ArrayList<Integer>>();
			// Initializes graph
			for (int j = 0; j < numEdges; j++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				temp.add(scan.nextInt());
				temp.add(scan.nextInt());
				edgeGraph.add(temp);
				
			}
			
			ArrayList<Integer> edgeWeights = new ArrayList<Integer>(numEdges);	// Array
			for (int j = 0; j < numEdges; j++)
			{
				edgeWeights.add(0);
//				System.out.print(vertixSize.get(j));
			}
			
			for (int j = 0; j < numEdges; j++)
			{
				edgeWeights.set(j, edgeWeights.get(j) + 1);	//increment all by 1
				
				for (int k = 0; k < numEdges; k++)
				{
					if (edgeGraph.get(j).get(1) == edgeGraph.get(k).get(0) && edgeWeights.get(j) >= edgeWeights.get(k))
					{
						edgeWeights.set(k, edgeWeights.get(k) + 1);
					}
				}
			}
//			System.out.println(edgeWeights);
			
			
			Integer max = Collections.max(edgeWeights);
			Stack<Integer> myStack = new Stack<Integer>();
			int temp = max;
			int srcEdge = 0;
			
			System.out.println(max);
			outFile.println(max);
			
			
			for (int j = 0; j < edgeWeights.size(); j++)
			{
				if (edgeWeights.get(j) == max)
				{
					srcEdge = j;	//5
					myStack.add(srcEdge + 1);
					temp--;
				}
			}
			
			while (temp != 0)
			{
//				int src = edgeGraph.get(edgeGraph.size() - 1).get(0); 	// 3
				for (int k = srcEdge; k >= 0; k--)
				{
//					System.out.println("k: " + k + "\t\tsrcEdge: " + srcEdge);
//					System.out.println("edgeWeights.get(k): " + edgeWeights.get(k) + "\t\ttemp: " + temp);
					if (edgeWeights.get(k) == temp && edgeGraph.get(srcEdge).get(0) == edgeGraph.get(k).get(1))
					{
						myStack.add(k + 1);
						srcEdge = edgeGraph.get(k).get(0);
						temp--;
					}
				}
				
			}
//			System.out.println(myStack);
			int x = 0;
			while(!myStack.isEmpty())
			{
				outFile.print(myStack.pop() + " ");
			}
			outFile.println("\n");
			System.out.println("\n");
			
		}
		outFile.close();
		scan.close();
	}

}
