package com.lzkill.main;

import java.util.List;

import org.jgrapht.graph.DirectedPseudograph;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class EnumerateElementaryCircuitsFromRandom {

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

		List<List<String>> cycles = hj.findSimpleCycles();

		Utils.reportPerformanceFor("simple cycles finding", time);

		System.out.println("no of simple cycles: " + cycles.size());

		for (List<String> c : cycles) {
			System.out.println(c.toString());
		}
	}
}
