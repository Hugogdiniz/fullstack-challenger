package br.me.desafio.fullstackchallenger.entity;

import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Provider {

    @Id
    private Long id;
    private String name;
    /*  private String nameContact;
        private String emailContact;
        private PersonType personType;
        private String cpfOrCnpj;
        private String activityDescription;*/
    private Address address;
    private List<PhoneNumber> phoneList = new ArrayList<>();

    public Provider(){

    }

    public Provider(Long id, String name, Address address, List<PhoneNumber> phoneList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneList = phoneList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneNumber> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(id, provider.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}