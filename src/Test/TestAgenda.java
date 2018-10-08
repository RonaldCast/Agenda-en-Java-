package Test;


import java.util.Scanner;
import Entidades.Agenda;


public class TestAgenda {

	private static Scanner sc = new Scanner(System.in);
	private static Agenda newAgenda = new Agenda(10);
	
	public static void main(String[] args) {
		
		
		while(true)
		{
			menu();
		}
		
		
	}
	
	private static void menu()
	{
		
		
		System.out.println("|ID |----------------------------------------");
		System.out.println("|1. |Añadir Contacto");
		System.out.println("|2. |Todos los contactos");
		System.out.println("|3. |Buscar contacto por nombre");
		System.out.println("|4. |Buscar contacto por número de teléfono");
		System.out.println("|5. |Borrar Teléfono");
		System.out.println("|6. |Modificar número de teléfono");
		System.out.println("---------------------------------------------");
		System.out.print("Ingrese el idetificador (ID) de la operación a realizar: ");
		int idSelected = sc.nextInt();
		System.out.println();
		System.out.println();
		
		switch(idSelected)
		{
			case 1:newAgenda.addContact();
				break;
			case 2:newAgenda.showAllContacts();
				break;
			case 3:newAgenda.searchContactForNombre();
				break;
			case 4:newAgenda.searchContactForTelephone();
				break;
			case 5:newAgenda.deleteContact();
				break;
			case 6:newAgenda.setNumContact();
				break;
			default:System.out.println("Esta opción esta incorrecta");
				break;
		}
	}

}
