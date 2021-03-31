package com.neux.garden.ec.runtime.jpa.bean;

public enum Sequences {
    ExProductOrder("ex_product_order_sequence"),
    ;

    private String sequence;

    Sequences(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
