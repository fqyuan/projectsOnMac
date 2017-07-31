package com.fqy.cdn;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int netNodeNum;
	private int consumeNodeNum;
	private int linkNum;
	private int perServerCost;
	private List<Edge> edgeList;
	private List<ConsumeNode> consumeNodeList;
	private int[][] edgeCapacity;
	private int[][] edgeCost;
	private List<Integer> netNodeFlow;
	private int totalNeededFlow;

	public Graph(String[] graphContent) {
		initialGraph();
		parseInput(graphContent);
	}

	public void setConsumeNodeList() {
		consumeNodeList = new ArrayList<ConsumeNode>();
	}

	public void setEdgeList() {
		edgeList = new ArrayList<Edge>();
	}

	public void setNetNodeFlow() {
		netNodeFlow = new ArrayList<Integer>();
	}

	// With Flaw
	public void initialGraph() {
		setConsumeNodeList();
		setEdgeList();
		setNetNodeFlow();
	}

	public void parseInput(String[] graphContent) {
		int nulLLine = 0;
		int linkCnt = 0;
		for (int i = 0; i < graphContent.length; i++) {
			if (graphContent[i].trim().equals("")) {
				// i++;
				nulLLine++;
				continue;
			}
			if (nulLLine == 0) {
				String[] str = graphContent[i].split(" ");
				setNetNodeNum(Integer.parseInt(str[0]));
				setLinkNum(Integer.parseInt(str[1]));
				setConsumeNodeNum(Integer.parseInt(str[2]));
				setEdgeCapacity(netNodeNum, netNodeNum);
				setEdgeCost(netNodeNum, netNodeNum);

			}
			if (nulLLine == 1) {
				setPerServerCost(Integer.parseInt(graphContent[i]));
			}
			if (nulLLine == 2) {
				String[] str = graphContent[i].split(" ");
				int startNode = Integer.parseInt(str[0]);
				int endNode = Integer.parseInt(str[1]);
				int cap = Integer.parseInt(str[2]);
				int perCost = Integer.parseInt(str[3]);
				// Set the edges of the graph, linkCnt is a local variable.
				edgeList.add(new Edge(linkCnt++, startNode, endNode, cap, perCost));
				// addEdge2(startNode, endNode, cap, perCost);
				// Set the capacity and cost matrix of the graph using array
				edgeCapacity[startNode][endNode] = cap;
				edgeCapacity[endNode][startNode] = cap;
				edgeCost[startNode][endNode] = perCost;
				edgeCost[endNode][startNode] = perCost;
			}
			if (nulLLine == 3) {
				String[] str = graphContent[i].split(" ");
				int id = Integer.parseInt(str[0]);
				int netNodeId = Integer.parseInt(str[1]);
				int bandwidthDemand = Integer.parseInt(str[2]);
				consumeNodeList.add(new ConsumeNode(id, netNodeId, bandwidthDemand));
				// consumeNodeNum++;
			}
		}
		// Updated 3.22
		setTotalNeedFlow();
	}

	private void setPerServerCost(int num) {
		perServerCost = num;
	}

	private void setNetNodeNum(int num) {
		netNodeNum = num;
	}

	// Update 3.22
	public void setEdgeCapacity(int row, int col) {
		edgeCapacity = new int[row][col];
	}

	// Get edgeCapcity and edgeCost matrix
	public int[][] getEdgeCapacity() {
		return edgeCapacity;
	}

	// Update 3.22
	public void setEdgeCost(int row, int col) {
		edgeCost = new int[row][col];
	}

	public int[][] getEdgeCost() {
		return edgeCost;
	}

	// Get net node count
	public int getNetNodeNum() {
		return netNodeNum;
	}

	// Get per sever cost
	public int getPerServerCost() {
		return perServerCost;
	}

	// Get Consume Node List
	public List<ConsumeNode> getConsumeNodeList() {
		return consumeNodeList;
	}

	// Get the consumeNodeId if connected
	public int getConsumeNodeId(int netNodeId) {
		int k = -1;
		for (int i = 0; i < consumeNodeList.size(); i++) {
			if (consumeNodeList.get(i).getNetNodeId() == netNodeId) {
				k = i;
				break;
			}
		}

		return k;
	}

	/*
	 * Updated
	 */
	public List<Integer> getNetNodeFlow() {
		return netNodeFlow;
	}

	// get the input/output of given node
	public void fillNetNodeFlow() {
		for (int i = 0; i < netNodeNum; i++) {
			int netFlow = 0;
			for (int j = 0; j < netNodeNum; j++) {
				netFlow += edgeCapacity[i][j];
			}
			netNodeFlow.add(netFlow);
		}
	}

	// Set the total flow needed, not needed here.
	public void setTotalNeedFlow() {
		for (int i = 0; i < consumeNodeList.size(); i++)
			totalNeededFlow += consumeNodeList.get(i).getBandwidthDemand();
	}

	// Get the total flow needed of the graph
	public int getTotalNeededFlow() {
		return totalNeededFlow;
	}

	// get the output flow of given network node
	public int getNetNodeFLow(int netNodeId) {
		return netNodeFlow.get(netNodeId);
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public int getConsumeNodeNum() {
		return consumeNodeNum;
	}

	public void setConsumeNodeNum(int consumeNodeNum) {
		this.consumeNodeNum = consumeNodeNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(int linkNum) {
		this.linkNum = linkNum;
	}
}
