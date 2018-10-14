package Entidades;

import java.util.ArrayList; 
import java.util.Scanner;

public class Agenda {
	
	private int _maximunContact;
	private ArrayList<Contacto> _contacts; 
	private Scanner sc = new Scanner(System.in);

	public Agenda(int maximunContact)
	{
		this._maximunContact = maximunContact;
		this._contacts = new ArrayList<Contacto>();
	}
	
	public void addContact()
	{
		Message.title("Agregar Contactos"); 
		
		if (_contacts.size() < _maximunContact)
		{
			Contacto contact = new Contacto();
			
			System.out.print("A�adir nombre del contacto: ");
			contact.setName(signInDataString());
			while(contact.getName().equals(""))
			{
				System.out.println("El nombre del contacto es obligatorio, por favor ingresarlo");
				System.out.print("A�adir nombre del contacto: ");
				contact.setName(signInDataString());
			}
			
			System.out.print("A�adir Tel�fono del contacto: ");
			contact.setTelephone(signInDataString());
			
			while(contact.getTelephone().equals(""))
			{
				System.out.println("El n�mero de tel�fono es obligatorio, por favor ingresarlo");
				System.out.print("A�adir Tel�fono del contacto: ");
				contact.setTelephone(signInDataString());
				
			}
			
			System.out.print("A�adir direcci�n del contacto: ");
			contact.setAdress(signInDataString());
			System.out.print("A�adir c�digo Postal del contacto: ");
			contact.setCodePostal(signInDataString());
			
			_contacts.add(contact);
			
			Message.success("El contacto hacido a�adido satifactoriamente");
			
		}
		else
		{
			Message.warning("Se le informa que su agenda ha llegado al m�ximo de contactos "+"("+_maximunContact+")");
		}
		
	}
	
	public void showAllContacts()
	{
		Message.title("Todos los contactos"); 
		System.out.println("(" + _contacts.size() + ")contactos");
		if(_contacts.size() != 0)
		{
			tripContacto(_contacts);
		}
		else
		{
			Message.success("En esta apartado apareceran los contactos que usted agregado");
		}
	}
	
	public void searchContactForNombre()
	{
		Message.title("Buscar contactos por nombre"); 
		
		System.out.println("Ingrese el nombre del contacto que desea buscar:");
		String name = signInDataString();
		ArrayList<Contacto> contactsFound = new ArrayList<Contacto>();
		
		for (Contacto contact : _contacts)
		{
			if(contact.getName().equalsIgnoreCase(name))
			{
				contactsFound.add(contact);
			}
		}
		
		System.out.println(contactsFound.size());
		if(contactsFound.size() != 0)
		{
			tripContacto(contactsFound);
		}
		else
		{
			Message.warning("El contacto " + name + ", no existe");
		}
			
	}
	
	public void searchContactForTelephone()
	{
		
		Message.title("Buscar contacto por mediante su numero de tel�fono"); 
		
		System.out.println("Ingrese el n�mero de tel�fono del contacto que desea buscar:");
		String telephone = signInDataString();
		ArrayList<Contacto> contactsFound = new ArrayList<Contacto>();
		
		for (Contacto contact : _contacts)
		{
			if(contact.getTelephone().equalsIgnoreCase(telephone))
			{
				contactsFound.add(contact);
			}
		}
		
		if(contactsFound.size() != 0)
		{
			tripContacto(contactsFound);
		}
		else
		{
			Message.warning("**El n�mero de tel�fono "+ telephone +" no existe");
		}
	}
	
	public void deleteContact()
	{
		
		Message.title("Borrar contacto"); 
		
		if(_contacts.size() != 0)
		{
			System.out.println("Ingrese el nombre del contacto que desea borrar:");
			String name = sc.next();
			ArrayList<Contacto> contactsFound = new ArrayList<Contacto>();
			
			for (Contacto contact : _contacts)
			{
				if(contact.getName().equalsIgnoreCase(name))
				{
					contactsFound.add(contact);
				}
			}
			if(contactsFound.size() != 0)
			{
				tripContacto(contactsFound);
				System.out.println("Seleccione el identificador (ID) del contacto a borrar:");
				int index = sc.nextInt();
				if( index <= contactsFound.size() && index > 0 )
				{
					index -= 1;
					Contacto deletedContacts = contactsFound.get((index));
					_contacts.remove(deletedContacts);
					
					Message.success("El contacto "+ deletedContacts.getName() +", hacido borrado existosamente");
					
				}
				else
				{
					Message.warning("El identificador (ID) ingresado no es valido");
				}
			}
			else
			{
				Message.warning("El contacto "+ name +", no existe");
			}
		}
		else
		{
			Message.warning("No hay contacto para borrar");
		}
	}
	
	public void deleteTelephone()
	{
		Message.title("Borrar el tel�fono de un contacto"); 
		
		System.out.println("Ingrese el nombre del contacto que desea borrar su t�lefono:");
		String name = sc.next();
		ArrayList<Contacto> contactsFound = new ArrayList<Contacto>();
		
		if(_contacts.size() != 0)
			{
			for (Contacto contact : _contacts)
			{
				if(contact.getName().equalsIgnoreCase(name))
				{
					contactsFound.add(contact);
				}
			}
			
			if(contactsFound.size() != 0)
			{
				tripContacto(contactsFound);
				System.out.println("Seleccione el identificador (ID) del contacto a borrar");
				int index = sc.nextInt();
				if( index <= contactsFound.size() && index > 0 )
				{
					index -= 1;
					Contacto deletedContacts = contactsFound.get((index));
					int indexContact = _contacts.indexOf(deletedContacts);
					_contacts.get(indexContact).setTelephone("vacio");
					
					Message.success("El tel�fono del contacto "+ name +", hacido borrado");
				}
				else
				{
					Message.warning("El identificador (ID) ingresado no es valido");
				}
			}
			else
			{
				Message.warning("El contacto "+ name +", no existe");
			}
		}
		else
		{
			Message.warning("No hay contacto para realizar esta acci�n");
		}
	}
	
	public void modifyTelephoneContact()
	{
		Message.title("Modificar contacto"); 
		
		if(_contacts.size() != 0)
		{
			System.out.println("Ingrese el nombre del contacto que desea modificar:");
			String name = sc.next();
			ArrayList<Contacto> contactsFound = new ArrayList<Contacto>();
			
			for (Contacto contact : _contacts)
			{
				if(contact.getName().equalsIgnoreCase(name))
				{
					contactsFound.add(contact);
				}
			}
			if(contactsFound.size() != 0)
			{
				tripContacto(contactsFound);
				System.out.println("Seleccione el identificador (ID) del contacto a modificar");
				int index = sc.nextInt();
				if( index <= contactsFound.size() && index > 0 )
				{
					index -= 1;
					Contacto modifyContact = contactsFound.get((index));
					int indexListContacts = _contacts.indexOf(modifyContact);
					System.out.println("Ingrese el nuevo n�mero de tel�fono: ");
					String newTelephone = sc.next(); 
					_contacts.get(indexListContacts).setTelephone(newTelephone);
					
					Message.success("El contacto "+ modifyContact.getName() +", hacido modificado correctamente");
	
				}
				else
				{
					Message.warning("El identificador (ID) ingresado no es valido");
				}
			}
			else
			{
				Message.warning("El contacto "+ name +", no existe");
			}
		}
		else
		{
			Message.warning("No hay contacto para modificar");
		}
	}
	
	//resolver 
	private String signInDataString()
	{
		System.out.println();
		String value = sc.nextLine();
		System.out.println();
		return value;
	}
	
	
	private void tripContacto( ArrayList<Contacto> arrayContacts)
	{
		for(int i = 0; i < arrayContacts.size(); i++)
		{
			System.out.println("Id: " + (i + 1) + "\n " +arrayContacts.get(i).toString());
		}
	}

}
