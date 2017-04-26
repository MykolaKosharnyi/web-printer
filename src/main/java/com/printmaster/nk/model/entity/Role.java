package com.printmaster.nk.model.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -357378939455722167L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="name")
    private String name;
       
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="user_roles", 
//        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
//        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
//    )
//    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

    
}