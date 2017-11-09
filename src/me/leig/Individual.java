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

/**
 * @author Leig
 * @version 20170301
 */

abstract class Individual implements Cloneable {

    // 个体基因型:一个基因型染色体由多个基因组成
    protected Chromosome chrom;
    // 基因长度
    protected int genelen;
    // 适应度
    protected double fitness;
    // 目标函数值
    protected double targetValue;

    // 编码
    public abstract void coding();
    // 解码
    public abstract void decode();
    // 计算个体适应度
    public abstract void calFitness();
    // 随机产生个体
    public abstract void generateIndividual();
    // 获取目标函数值
    public abstract void calTargetValue();

    public double getFitness(){
        return fitness;
    }

    public double getTargetValue(){
        return targetValue;
    }

    public int getChromlen(){
        return chrom.getLength();
    }

    public boolean setChrom(int begin , int end , String gene) {
        return chrom.setGene(begin,end,gene);
    }

    public String getChrom(int begin , int end) {
        return chrom.getGene(begin,end);
    }

    public void mutateSingleBit(int index) {
        String gene, gn;
        gene = chrom.getGene(index , index);
        gn = gene.equals("0") ? "1" : "0";
        chrom.setGene(index, index, gn);
    }

    @Override
    public Object clone() {
        Individual indv = null;

        try {
            indv = (Individual)super.clone();
            indv.chrom = (Chromosome)chrom.clone();
        } catch(CloneNotSupportedException e ) {
            System.out.println(e.getMessage());
        }

        return indv;
    }
}