package com.printmaster.nk.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

import com.printmaster.nk.model.User;

@Entity
@Table(name = "roles")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -357378939455722167L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles", 
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )
    private Set<User> users;

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

    
}