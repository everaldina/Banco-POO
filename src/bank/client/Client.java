package bank.client;

import java.time.LocalDate;
import bank.utils.CpfUtils;

import bank.utils.Gender;

public class Client {
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Gender gender;


    public Client(String name, String cpf, LocalDate birthDate, Gender gender) throws IllegalArgumentException {

        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else
            throw new IllegalArgumentException("Invalid name");

        if (CpfUtils.isValid(cpf))     
            this.cpf = cpf;
        else
            throw new IllegalArgumentException("Invalid CPF");
        
        if (birthDate != null && birthDate.isBefore(LocalDate.now()))
            this.birthDate = birthDate;
        else
            throw new IllegalArgumentException("Invalid birth date");

        this.gender = gender;
    }

    public Client(String name, String cpf, LocalDate birthDate) {
        this(name, cpf, birthDate, Gender.OTHER);
    }

    

    @Override
    public String toString() {
        return "Client [name=" + name + ", cpf=" + cpf + ", birthDate=" + birthDate + ", gender=" + gender.getAbreviation() + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    
    
}
