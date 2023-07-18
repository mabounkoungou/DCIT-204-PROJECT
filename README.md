visit the github via https://github.com/mabounkoungou/DCIT-204-PROJECT.git


EXPLANATION OF THE PROGRAM

The code is inside the com.src.ShortestPath package, which indicates the package structure.

The necessary imports are included:

javax.swing.* imports the Swing classes for creating the GUI.
java.awt.* imports the AWT classes for handling the GUI components.
java.awt.event.ActionEvent and java.awt.event.ActionListener import classes for handling action events.
The Main class is declared, which contains the main method and GUI components.

The class variables are declared:

frame, label, source_label, destination_label, and route are JLabel objects used for displaying text in the GUI.
button is a JButton object used for triggering the shortest path calculation.
panel is a JPanel object used as a container for GUI components.
source and Destination are JTextField objects used for inputting the source and destination locations.
The constructor of the Main class is defined but left empty.

The main method is the entry point of the program:

It creates a new JFrame object, which represents the main window of the GUI.
It initializes the GUI components, including labels, text fields, and a button.
The button's action listener is defined using an anonymous inner class that handles the button click event.
Inside the button's action listener, a predefined graph is created with various nodes representing locations and edges representing connections between locations.
The source and destination locations are retrieved from the input text fields, and the corresponding nodes are assigned based on the input.
The shortestPath method of the Graph class is called with the source and destination nodes to calculate the shortest path.
The resulting path is displayed in a new JLabel object called route, which is added to the GUI panel.
The GUI components are arranged using the GridLayout manager, and the panel is added to the frame.

The frame's properties are set, including the title, default close operation, and visibility.

In summary, this code creates a GUI for finding the shortest path between two locations in a predefined graph. The user can input the source and destination locations, and the program calculates and displays the shortest path between them.



The Graph class is defined in the com.src.ShortestPath package.

The class has two instance variables:

nodes is a Set that stores the nodes of the graph.
directed is a boolean flag indicating whether the graph is directed or undirected.
The constructor for the Graph class initializes the nodes set and sets the directed flag based on the constructor parameter.

The addNode method allows adding one or more nodes to the graph by adding them to the nodes set.

The addEdge method adds an edge between two nodes with a specified weight:

The method ensures that the source and destination nodes are added to the nodes set.
The addEgdeHelper method is called to add the edge to the source node's edge list, preventing duplicates.
If the graph is undirected and the source and destination nodes are different, the method also adds the reverse edge.
The addEgdeHelper method adds an edge to the source node's edge list if it doesn't already exist.

The printEdges method prints the edges of each node in the graph:

It iterates over the nodes and their corresponding edge lists.
If an edge list is empty, it indicates that the node has no edges.
Otherwise, it prints the destination node's name and weight for each edge.
The hasEdge method checks if an edge exists between the source and destination nodes by iterating over the source node's edge list.

The resetNodesVisited method resets the visited state of all nodes in the graph to prepare for a new shortest path calculation.

The shortestPath method calculates the shortest path between a start node and an end node using Dijkstra's algorithm:

It maintains a changedAt map to keep track of the previous node that leads to the current node on the shortest path.
It maintains a shortestPath map to store the shortest path weight to each node.
Initially, all nodes except the start node have their shortest path weight set to infinity.
It iteratively selects the closest unvisited node based on the current shortest path weights.
For each unvisited neighbor of the current node, it updates the shortest path weight if a shorter path is found.
The method continues until the end node is reached or there are no more reachable unvisited nodes.
If the end node is reached, the method prints the shortest path and its weight.
If the end node is not reached, it indicates that there is no path between the start and end nodes.
The closestReachableUnvisited method finds the unvisited node with the shortest path weight from the shortestPathMap.

Overall, this code provides the functionality to represent a graph, add nodes and edges, find the shortest path between nodes using Dijkstra's algorithm, and perform other graph-related operations.






The Node class is defined in the com.src.ShortestPath package.

The class has several instance variables:

n is an integer representing the weight or numerical identifier of the node.
name is a string representing the name or description of the node.
visited is a boolean flag indicating whether the node has been visited or not.
edges is a LinkedList that stores the edges connected to the node.
The constructor for the Node class initializes the n, name, and visited variables based on the constructor parameters:

The edges list is also initialized as an empty LinkedList.
The isVisited method returns the value of the visited flag, indicating whether the node has been visited or not.

The visit method sets the visited flag to true, marking the node as visited.

The unvisit method sets the visited flag to false, marking the node as unvisited.

Overall, the Node class provides a representation of a node in a graph, including its weight, name, visited status, and the edges connected to it.




The Edge class is defined in the com.src.ShortestPath package.

The class has three instance variables:

source is a reference to the source node of the edge.
destination is a reference to the destination node of the edge.
weight is a double value representing the weight of the edge.
The constructor for the Edge class initializes the source, destination, and weight variables based on the constructor parameters.

The toString method overrides the default toString method of the Object class to provide a custom string representation of the edge. It returns a formatted string that includes the names of the source and destination nodes, along with the weight of the edge.

The compareTo method implements the Comparable interface and compares two edges based on their weights. It returns -1 if the current edge has a smaller weight than the other edge, 0 if they have equal weights, and 1 if the current edge has a greater weight than the other edge.

Overall, the Edge class represents an edge in a graph and provides methods to access its source, destination, weight, and compare it to other edges based on their weights.



The functionality of the program is to provide a graphical user interface (GUI) for finding the shortest path between two locations in a predefined graph. Here's how the application works:

The application creates a GUI window using Swing components, such as JFrame, JPanel, JLabel, JTextField, and JButton.

The GUI window displays a label with a list of available locations.

The user can enter their current location and final destination in the provided text fields.

When the user clicks the "Click here" button, an action listener is triggered.

Inside the action listener, the program retrieves the source and destination locations entered by the user.

The application constructs a graph and adds nodes representing various locations. Each location is assigned a unique identifier and a name.

Edges are added to the graph to represent connections between locations. The edges are weighted based on the distance or cost between the locations.

The program then calculates the shortest path between the source and destination nodes using Dijkstra's algorithm implemented in the shortestPath method of the Graph class.

The shortest path, along with its cost and estimated time, is displayed in a new label in the GUI window.

If there is no path between the source and destination nodes, a message indicating the lack of a path is displayed.

The user can enter new source and destination locations, and the process can be repeated.

In summary, the application allows users to input their current location and desired destination, and it calculates and displays the shortest path between these locations based on a predefined graph. It provides a user-friendly GUI interface for interacting with the shortest path functionality.









