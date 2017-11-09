/**********************************************************************
 *	湖南长沙阳环科技实业有限公司
 *    @Copyright (c) 2003-2017 yhcloud, Inc. All rights reserved.
 *
 *	This copy of Ice is licensed to you under the terms described in the
 *	ICE_LICENSE file included in this distribution.
 *
 *	@license http://www.yhcloud.com.cn/license/
 **********************************************************************/
package me.leig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Leig
 * @version 20170301
 */

class GeneticAlgorithms {

    // 交叉概率
    public static double crossoverRate;
    // 变异概率
    public static double mutateRate;
    // 进化代数
    public static int maxGeneration;
    // 群体大小
    public static int populationSize;

    static {
        //crossoverRate = 0.6;
        //mutateRate = 0.001;
        //maxGeneration  = 100;
        //populationSize = 500;
        maxGeneration  = 100;
        populationSize = 500;
        crossoverRate = 0.6;
        mutateRate = 0.001;
    }

    public static void main(String[] args)throws IOException {

        FileWriter fw = new FileWriter("result.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        Population pop = new Population(populationSize);
        pop.initPopulation();

        pw.println("初始种群:\n" + pop);
        while(!pop.isEvolutionDone()){
            pop.evolve();
            pw.print("第" + pop.getGeneration() + "代Best:" + pop.bestIndividual );
            pw.print("第" + pop.getGeneration() + "代current:" + pop.currentBest );
            pw.println("");
        }
        pw.println();
        pw.println("第" + pop.getGeneration() + "代群体:\n" + pop);

        pw.close();
    }

    public void print(){

    }
}