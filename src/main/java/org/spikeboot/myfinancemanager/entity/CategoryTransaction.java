package org.spikeboot.myfinancemanager.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "categoryTransaction",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<UserTransaction> userTransactions;

    public CategoryTransaction() {
    }

    public CategoryTransaction(boolean typeTransaction, String name) {
        this.typeTransaction = typeTransaction;
        this.name = name;
    }

    public void addCategoryTransactionToUserTransaction(UserTransaction userTransaction){
        if(userTransaction == null){
            userTransactions = new ArrayList<>();
        }
        userTransactions.add(userTransaction);
        userTransaction.setCategoryTransaction(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getTypeTransaction() {
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

    @Override
    public String toString() {
        return "CategoryTransaction{" +
                "id=" + id +
                ", typeTransaction=" + typeTransaction +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryTransaction that = (CategoryTransaction) o;
        return id == that.id &&
                typeTransaction == that.typeTransaction &&
                Objects.equals(name, that.name) &&
                Objects.equals(userTransactions, that.userTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeTransaction, name, userTransactions);
    }
}
