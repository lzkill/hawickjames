package com.lzkill.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.jgrapht.graph.DirectedPseudograph;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class EnumerateElementaryCircuitsFromFile {

	public static void main(String[] args) {
		DirectedPseudograph<String, Edge> g = new DirectedPseudograph<String, Edge>(
				Edge.class);

		long time = System.currentTimeMillis();
		Utils.reportPerformanceFor("starting at", time);

		try {
			g = GraphBuilder.buildFromFile(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Utils.reportPerformanceFor("graph loading from file", time);
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
