package com.codegym.entity;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contractId;
    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false)
    private AttachService attachServiceId;
    @Column(nullable = false)
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Integer id, Contract contractId, AttachService attachServiceId, Integer quantity) {
        this.id = id;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(Contract contractId, AttachService attachServiceId, Integer quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
