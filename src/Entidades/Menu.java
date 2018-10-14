package Entidades;

import java.util.Scanner;

public class Menu {

	private static Scanner sc = new Scanner(System.in);
	private Agenda newAgenda;
	
	public Menu(Agenda newAgenda)
	{
		this.newAgenda = newAgenda; 
	}
	
	private int option()
	{
		System.out.println();
		System.out.println("|ID |----------------------------------------");
		System.out.println("|1. |Añadir Contacto");
		System.out.println("|2. |Todos los contactos");
		System.out.println("|3. |Buscar contacto por nombre");
		System.out.println("|4. |Buscar contacto por número de teléfono");
		System.out.println("|5. |Borrar Contacto");
		System.out.println("|6. |Borrar el télefono");
		System.out.println("|7. |Modificar número de teléfono");
		System.out.println("---------------------------------------------");
		System.out.print("Ingrese el idetificador (ID) de la operación a realizar: ");
		return sc.nextInt();
	}
	
	public void seletedOption()
	{
		int idSelected = option();
		
		switch(idSelected)
		{
			case 1: newAgenda.addContact();
				break;
			case 2: newAgenda.showAllContacts();
				break;
			case 3: newAgenda.searchContactForNombre();
				break;
			case 4: newAgenda.searchContactForTelephone();
				break;
			case 5: newAgenda.deleteContact();
				break;
			case 6: newAgenda.deleteTelephone();
				break;
			case 7: newAgenda.modifyTelephoneContact();
				break;
			default:System.out.println("Esta opción esta incorrecta");
				break;
		}
	}
}
