package br.com.af.techcontrol.rest.entity.base;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "roles_privileges", joinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(
					name = "privilege_id", referencedColumnName = "id"))
	private Collection<Privilege> privileges = new ArrayList<Privilege>();

	
}
