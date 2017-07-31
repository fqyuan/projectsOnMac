package com.filetool.main;

import com.cacheserverdeploy.deploy.Deploy;
import com.filetool.util.FileUtil;
import com.filetool.util.LogUtil;

//
public class Main {
	/*
	 * Arg:/Users/fqyuan/Documents/Java_Work/CDN/case_example/m2.txt
	 * /Users/fqyuan/Documents/Java_Work/CDN/case_example/res.txt
	 */
	public static void main1(String[] args) {
		if (args.length != 2) {
			System.err.println("please input args: graphFilePath, resultFilePath");
			return;
		}

		String graphFilePath = args[0];
		String resultFilePath = args[1];

		LogUtil.printLog("Begin");

		// 璇诲彇杈撳叆鏂囦欢
		String[] graphContent = FileUtil.read(graphFilePath, null);

		// Test part:
		// for (int i = 0; i < graphContent.length; i++)
		// System.out.println(graphContent[i]);

		/********
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		/*
		 * int arr[] = { 0, 1, 24 }; ArrayList<Integer> serverId = new
		 * ArrayList<>(); for (int i = 0; i < arr.length; i++)
		 * serverId.add(arr[i]); // graph.parseInput(graphContent); MCFF mc =
		 * new MCFF(graph); mc.getResult(serverId);
		 */

		// Genetic running
		// System.out.println("Genetic Methods runing here: ");
		// Graph graph = new Graph(graphContent);
		// MCFF mc = new MCFF(graph);
		// int netSize = graph.getNetNodeNum();
		// Population myPop = new Population(100, netSize, true);
		// GA.evolvePopulation(myPop, netSize, mc);
		// for (int i = 0; i < 20; i++) {
		// // mc = new MCFF(new Graph(graphContent));
		// myPop = GA.evolvePopulation(myPop, netSize, mc);
		// System.out.println("Iteration:" + i + ": " + 1.0 /
		// myPop.getFittest(mc).getFitness(mc));
		// }
		//
		// // Get the best routes:
		// ArrayList<Integer> al = new ArrayList<Integer>();
		// for (int i = 0; i < netSize; i++) {
		// if (GA.bestLocation.getGene(i) == 1)
		// al.add(i);
		// }
		// System.out.println(al);
		// mc.getResult(al);
		// System.out.println(mc.getMinCostFlow(al));
		// mc.getResult(al);
		/*********************
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		String[] resultContents = Deploy.deployServer(graphContent);

		// 鍐欏叆杈撳嚭鏂囦欢
		if (hasResults(resultContents)) {
			FileUtil.write(resultFilePath, resultContents, false);
		} else {
			FileUtil.write(resultFilePath, new String[] { "NA" }, false);
		}
		LogUtil.printLog("End");
	}

	private static boolean hasResults(String[] resultContents) {
		if (resultContents == null) {
			return false;
		}
		for (String contents : resultContents) {
			if (contents != null && !contents.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
