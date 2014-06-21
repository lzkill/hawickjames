package com.lzkill.main;

import org.jgrapht.graph.DirectedPseudograph;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class CountElementaryCircuitsFromRandom {

	public static void main(String[] args) {
		DirectedPseudograph<String, Edge> g = new DirectedPseudograph<String, Edge>(
				Edge.class);

		long time = System.currentTimeMillis();
		Utils.reportPerformanceFor("starting at", time);

		GraphBuilder.buildRandomically(g, Integer.parseInt(args[0]),
				Integer.parseInt(args[1]));

		Utils.reportPerformanceFor("random graph generation", time);

		System.out.println("no of vertices: " + g.vertexSet().size());
		System.out.println("no of edges: " + g.edgeSet().size());

		HawickJamesSimpleCycles<String, Edge> hj = new HawickJamesSimpleCycles<String, Edge>(
				g);

		time = System.currentTimeMillis();

		long nCycles = hj.countSimpleCycles();

		Utils.reportPerformanceFor("simple cycles counting", time);

		System.out.println("no of simple cycles: " + nCycles);
	}
}
