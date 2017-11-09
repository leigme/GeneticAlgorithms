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

class Chromosome implements Cloneable {

    private StringBuffer chromosome;

    //染色体长度
    private int chromosomeLength;

    //默认基因填充字符
    private char defaultChar;

    public Chromosome(int chromosomeLength){
        chromosome = new StringBuffer(chromosomeLength);
        chromosome.setLength(chromosomeLength);
        defaultChar = '0';
        this.chromosomeLength = chromosomeLength;
    }

    /**
     * 设置基因
     *
     * @param begin
     * @param end
     * @param gene
     * @return
     */
    public boolean setGene(int begin, int end, String gene) {

        int len = gene.length();

        if(len > end - begin + 1) {
            return false;
        }

        //index => chromosome , idx => gene
        for (int index = begin, idx = 0; index <= end; index++, idx++) {
            if(idx < len) {
                chromosome.setCharAt(index, gene.charAt(idx));
            } else {
                chromosome.setCharAt(index, defaultChar);
            }
        }
        return true;
    }

    /**
     * 获取基因
     *
     * @param begin
     * @param end
     * @return
     */
    public String getGene(int begin, int end) {

        char[] dest = new char[end - begin + 1];

        chromosome.getChars(begin, end + 1, dest, 0);

        return new String(dest);
    }

    public int getLength(){
        return chromosomeLength;
    }

    public String toString(){
        return chromosome.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Chromosome c = null;

        try {
            c = (Chromosome)super.clone();
            c.chromosome = new StringBuffer(chromosome);
        } catch(CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}