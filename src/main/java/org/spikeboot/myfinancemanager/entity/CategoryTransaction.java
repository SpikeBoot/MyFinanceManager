package org.spikeboot.myfinancemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_transaction")
public class CategoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_transaction")
    private boolean typeTransaction;

    @Column(name = "name")
    private String name;

    public CategoryTransaction() {
    }

    public CategoryTransaction(boolean typeTransaction, String name) {
        this.typeTransaction = typeTransaction;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(boolean typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
