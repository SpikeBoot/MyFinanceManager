package org.spikeboot.myfinancemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_transaction")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_transaction")
    private boolean typeTransaction;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private CategoryTransaction categoryTransaction;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private double value;

    public UserTransaction() {
    }

    public UserTransaction(boolean typeTransaction, CategoryTransaction categoryTransaction, String description, double value) {
        this.typeTransaction = typeTransaction;
        this.categoryTransaction = categoryTransaction;
        this.description = description;
        this.value = value;
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

    public CategoryTransaction getCategoryTransaction() {
        return categoryTransaction;
    }

    public void setCategoryTransaction(CategoryTransaction categoryTransaction) {
        this.categoryTransaction = categoryTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "id=" + id +
                ", typeTransaction=" + typeTransaction +
                ", categoryTransaction=" + categoryTransaction +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
