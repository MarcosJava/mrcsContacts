package mrcsFelipe.financeiro.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Clientes implements Serializable{
	
	private int id;
	
	private String name;

	public Clientes(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		
		Clientes c1 = new Clientes(6921, "ALEXSANDRO MOREIRA RAMOS");
		Clientes c2 = new Clientes(2786, "ARTHUR NOBRE DA LUZ E SOUZA");
		Clientes c3 = new Clientes(2786, "ARTHUR NOBRE DA LUZ E SOUZA");
		Clientes c4 = new Clientes(2786, "ARTHUR NOBRE DA LUZ E SOUZA");
		Clientes c5 = new Clientes(5421, "ENZO MORBIDELLI ALMEIDA");
		
		List<Clientes> lstClientes = new ArrayList<Clientes>();
		lstClientes.add(c1);
		lstClientes.add(c2);
		lstClientes.add(c3);
		lstClientes.add(c4);
		lstClientes.add(c5);
		
		System.out.println("COM LIST");
		for (Clientes clientes : lstClientes) {
			System.out.println(clientes);
		}
		
		Set<Clientes> setClientes = new HashSet<Clientes>(lstClientes);
		System.out.println("COM SET -- usando HASHSET");
		for (Clientes clientes : setClientes) {
			System.out.println(clientes + "  HASH CODE = "+ clientes.hashCode());
		}
		
		
		Set<Clientes> setClientes2 = new LinkedHashSet<Clientes>(lstClientes);
		System.out.println("COM SET -- usando LINKHASHSET");
		for (Clientes clientes : setClientes2) {
			System.out.println(clientes + " LINK HASH CODE = "+ clientes.hashCode());
		}
		
		
		Set<Clientes> setClientes3 = new TreeSet<Clientes>(lstClientes);
		System.out.println("COM SET -- usando TreeSet");
		for (Clientes clientes : setClientes3) {
			System.out.println(clientes + " TreeSet");
		}
		
		System.out.println("COM INTERATOR");
		Iterator<Clientes> itClientes = lstClientes.iterator();
		while(itClientes.hasNext()){
			System.out.println(itClientes.next());
		}
		
		
		
		
		
		
		
		System.err.println("DIEGUETE , Estamos juntos irmão <3");
		
	}
	
	
}
