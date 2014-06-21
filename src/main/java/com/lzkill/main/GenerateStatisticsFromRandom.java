package com.lzkill.main;

import org.jgrapht.graph.DirectedPseudograph;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class GenerateStatisticsFromRandom {

	public static void main(String[] args) {

		long nCycles = 0;
		DirectedPseudograph<String, Edge> g = null;
		HawickJamesSimpleCycles<String, Edge> hj = null;
		long time = 0;

		for (int i = 0; i < Integer.parseInt(args[0]); i++) {

			g = new DirectedPseudograph<String, Edge>(
					Edge.class);

			GraphBuilder.buildRandomically(g, Utils.randInt(1,Integer.parseInt(args[1])),
					Utils.randInt(0, Integer.parseInt(args[2])));

			hj = new HawickJamesSimpleCycles<String, Edge>(
					g);

			time = System.currentTimeMillis();

			nCycles = hj.countSimpleCycles();

			Utils.reportPerformanceFor(g.vertexSet().size() + " "+ g.edgeSet().size() + " " + 
					String.valueOf(nCycles), time);
			
			g = null;
			hj = null;
			
			System.gc();
		}
	}
}
