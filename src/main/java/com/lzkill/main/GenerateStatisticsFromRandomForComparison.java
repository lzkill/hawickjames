package com.lzkill.main;

import org.jgrapht.alg.cycle.JohnsonSimpleCycles;
import org.jgrapht.alg.cycle.SzwarcfiterLauerSimpleCycles;
import org.jgrapht.alg.cycle.TarjanSimpleCycles;
import org.jgrapht.alg.cycle.TiernanSimpleCycles;
import org.jgrapht.graph.DefaultDirectedGraph;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class GenerateStatisticsFromRandomForComparison {

	public static void main(String[] args) {

		DefaultDirectedGraph<String, Edge> g = null;
		long refTime = 0;

		System.out
				.println("n;m;cyclesHawickJames;timeHawickJames;memHawickJames;cyclesJhonson;timeJohnson;memJohnson;cyclesSzwarcfiterLauer;timeSzwarcfiterLauer;memSzwarcfiterLauer;cyclesTarjan;timeTarjan;memTarjan;cyclesTiernan;timeTiernan;memTiernan");

		for (int i = 0; i < Integer.parseInt(args[0]); i++) {

			g = new DefaultDirectedGraph<String, Edge>(Edge.class);

			GraphBuilder.buildRandomically(g,
					Utils.randInt(1, Integer.parseInt(args[1])),
					Utils.randInt(0, Integer.parseInt(args[2])));

			HawickJamesSimpleCycles<String, Edge> hj = new HawickJamesSimpleCycles<String, Edge>(
					g);
			long cyclesHawickJames = 0;
			refTime = System.currentTimeMillis();
			cyclesHawickJames = hj.findSimpleCycles().size();
			double timeHawickJames = (System.currentTimeMillis() - refTime) / 1000.0;
			double memHawickJames = Utils.usedMemory() / (1024.0 * 1024.0);
			memHawickJames = Math.round(memHawickJames * 100) / 100.0;

			hj = null;
			System.gc();

			JohnsonSimpleCycles<String, Edge> j = new JohnsonSimpleCycles<String, Edge>(
					g);
			long cyclesJhonson = 0;
			refTime = System.currentTimeMillis();
			cyclesJhonson = j.findSimpleCycles().size();
			double timeJohnson = (System.currentTimeMillis() - refTime) / 1000.0;
			double memJohnson = Utils.usedMemory() / (1024.0 * 1024.0);
			memJohnson = Math.round(memJohnson * 100) / 100.0;

			j = null;
			System.gc();

			SzwarcfiterLauerSimpleCycles<String, Edge> sl = new SzwarcfiterLauerSimpleCycles<String, Edge>(
					g);
			long cyclesSzwarcfiterLauer = 0;
			refTime = System.currentTimeMillis();
			cyclesSzwarcfiterLauer = sl.findSimpleCycles().size();
			double timeSzwarcfiterLauer = (System.currentTimeMillis() - refTime) / 1000.0;
			double memSzwarcfiterLauer = Utils.usedMemory() / (1024.0 * 1024.0);
			memSzwarcfiterLauer = Math.round(memSzwarcfiterLauer * 100) / 100.0;

			sl = null;
			System.gc();

			TarjanSimpleCycles<String, Edge> tj = new TarjanSimpleCycles<String, Edge>(
					g);
			long cyclesTarjan = 0;
			refTime = System.currentTimeMillis();
			cyclesTarjan = tj.findSimpleCycles().size();
			double timeTarjan = (System.currentTimeMillis() - refTime) / 1000.0;
			double memTarjan = Utils.usedMemory() / (1024.0 * 1024.0);
			memTarjan = Math.round(memTarjan * 100) / 100.0;

			tj = null;
			System.gc();

			TiernanSimpleCycles<String, Edge> tn = new TiernanSimpleCycles<String, Edge>(
					g);
			long cyclesTiernan = 0;
			refTime = System.currentTimeMillis();
			cyclesTiernan = tn.findSimpleCycles().size();
			double timeTiernan = (System.currentTimeMillis() - refTime) / 1000.0;
			double memTiernan = Utils.usedMemory() / (1024.0 * 1024.0);
			memTiernan = Math.round(memTiernan * 100) / 100.0;

			tn = null;

			assert (cyclesHawickJames == cyclesJhonson);
			assert (cyclesJhonson == cyclesSzwarcfiterLauer);
			assert (cyclesSzwarcfiterLauer == cyclesTarjan);
			assert (cyclesTarjan == cyclesTiernan);

			System.out.println(g.vertexSet().size() + ";" + g.edgeSet().size()
					+ ";" + cyclesHawickJames + ";" + timeHawickJames + ";"
					+ memHawickJames + ";" + cyclesJhonson + ";" + timeJohnson
					+ ";" + memJohnson + ";" + cyclesSzwarcfiterLauer + ";"
					+ timeSzwarcfiterLauer + ";" + memSzwarcfiterLauer + ";"
					+ cyclesTarjan + ";" + timeTarjan + ";" + memTarjan + ";"
					+ cyclesTiernan + ";" + timeTiernan + ";" + memTiernan);

			g = null;

			System.gc();
		}
	}
}
