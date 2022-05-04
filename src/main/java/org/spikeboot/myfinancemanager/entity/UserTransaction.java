package org.spikeboot.myfinancemanager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_transaction")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    /**
     * categoryTransactionId
     * This field uses in controller for add instance in field CategoryTransaction for this class
     * And not use in CRUD operations
     */

    @Transient
    private int categoryTransactionId;

    public UserTransaction() {
    }

    public UserTransaction(CategoryTransaction categoryTransaction,
                           String description,
                           double value) {

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

    public int getCategoryTransactionId() {
        return categoryTransactionId;
    }

    public void setCategoryTransactionId(int categoryTransactionId) {
        this.categoryTransactionId = categoryTransactionId;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "id=" + id +
                ", categoryTransaction=" + categoryTransaction +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTransaction that = (UserTransaction) o;
        return id == that.id &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(categoryTransaction, that.categoryTransaction) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryTransaction, description, value);
    }
}
