package br.me.desafio.fullstackchallenger.entity;

import br.me.desafio.fullstackchallenger.enums.PersonType;
import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Provider {

    @Id
    private String id;
    private String name;
    private PersonType personType;
    private String cpf;
    private String cnpj;
    private String activityDescription;
    private Endereco endereco;
    private String nomeContato;
    private String emailContato;

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

/*  private String nameContact;
        private String emailContact;
        private PersonType personType;
        private String cpfOrCnpj;
        private String activityDescription;*/
//    private Address address;
//    private List<PhoneNumber> phoneList = new ArrayList<>();

    public Provider(){

    }

    public Provider(String id, String name, Address address, List<PhoneNumber> phoneList) {
        this.id = id;
        this.name = name;
//        this.address = address;
//        this.phoneList = phoneList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public List<PhoneNumber> getPhoneList() {
//        return phoneList;
//    }

//    public void setPhoneList(List<PhoneNumber> phoneList) {
//        this.phoneList = phoneList;
//    }

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


    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
