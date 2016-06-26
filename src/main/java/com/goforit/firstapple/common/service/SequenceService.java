package com.goforit.firstapple.common.service;

/**
 * Created by junqingfjq on 16/6/24.
 */
public interface SequenceService {

    public enum Strategy{
        DEFAULT(10,"0"),
        FLOW(16,"0");

        private final int size;

        private final String padString;

        private Strategy(int size,String padString){
            this.size=size;
            this.padString=padString;
        }

        public int getSize(){return this.size;}

        public String getPadString(){return this.padString;}
    }

    public enum TableName{
        USER,
    }

    String generate(TableName tableName);

    String generate(TableName tableName,Strategy strategy);
}
