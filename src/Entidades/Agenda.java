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
		if (_contacts.size() < _maximunContact)
		{
			Contacto contact = new Contacto();
			
			System.out.print("Añadir nombre del contacto: ");
			contact.setName( signInDataString());
			System.out.print("Añadir Teléfono del contacto: ");
			contact.setTelephone(signInDataString());
			
			while(contact.getTelephone().equals(""))
			{
				System.out.print("El número de teléfono es obligatorio, ingreselo por favor");
				System.out.print("Añadir Teléfono del contacto: ");
				contact.setTelephone(signInDataString());
				
			}
			
			System.out.print("Añadir dirección del contacto: ");
			contact.setAdress(signInDataString());
			System.out.print("Añadir código Postal del contacto: ");
			contact.setCodePostal(signInDataString());
			
			_contacts.add(contact);
			
			System.out.println("************************************************");
			System.out.println("**El contacto hacido añadido satifactoriamente**");
			System.out.println("************************************************\n\n");
		}
		else
		{
			System.out.println("Alert: Sele informa que su agenda ha llegado a máximo de contactos "+"("+_maximunContact+")");
		}
		
	}
	
	public void showAllContacts()
	{
		System.out.println("Cantidad de contactos " + "(" + _contacts.size() + ")");
		if(_contacts.size() != 0)
		{
			tripContacto(_contacts);
			
		}
		else
		{
			System.out.println("*******************************************************************");
			System.out.println("**En esta apartado apareceran los contactos que usted ha agregado**");
			System.out.println("*******************************************************************\n\n");
			
		}
	}
	
	public void searchContactForNombre()
	{
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
		
		if(contactsFound.size() != 0)
		{
			tripContacto(contactsFound);
		}
		else
		{
			System.out.println("**El contacto " + name + ", no existe :( **\n\n");
		}
		
		
	}
	public void searchContactForTelephone()
	{
		System.out.println("Ingrese el número de teléfono del contacto que desea buscar:");
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
			System.out.println("**El número de teléfono"+ telephone +" no existe:( **\n\n");
		}
	}
	
	public void deleteContact()
	{
		if(_contacts.size() != 0)
		{
			System.out.println("Ingrese el nombre del contacto que desea borrar:");
			String name = signInDataString();
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
				System.out.println("Seleccione el identificador (ID) del contacto a borrar");
				int index = sc.nextInt();
				if( index <= contactsFound.size() && index > 0 )
				{
					index -= 1;
					Contacto deletedContacts = contactsFound.get((index));
					_contacts.remove(deletedContacts);
					System.out.println("**El contacto "+ deletedContacts.getName() +", hacido borrado existosamente**");
				}
				else
				{
					System.out.println("**El identificador (ID) ingresado no es valido :(**");
				}
				
				
			}
			else
			{
				System.out.println("**El contacto "+ name +", no existe:( **\n\n");
			}
			
		}
		else
		{
			System.out.println("**No hay contacto para borrar  **\n\n");
		}
		
		
		
	}
	
	public void setNumContact()
	{
		if(_contacts.size() != 0)
		{
			System.out.println("Ingrese el nombre del contacto que desea modificar:");
			String name = signInDataString();
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
					System.out.println("Ingrese el nuevo número de teléfono: ");
					_contacts.get(indexListContacts).setTelephone(signInDataString());
					System.out.println("**El contacto "+ modifyContact.getName() +", hacido modificado correctamente**");
				}
				else
				{
					System.out.println("**El identificador (ID) ingresado no es valido :(**");
				}
				
				
			}
			else
			{
				System.out.println("**El contacto "+ name +", no existe:( **\n\n");
			}
			
		}
		else
		{
			System.out.println("**No hay contacto para modificar**\n\n");
		}
	}
	
    //methods extras 
	
	private String signInDataString()
	{
		String value = sc.next();
		System.out.println();
		return value;
	}
	
	private void tripContacto( ArrayList<Contacto> arrayContacts)
	{
		for(int i = 0; i < arrayContacts.size(); i++)
		{
			System.out.println((i + 1) + " " +arrayContacts.get(i).getName() + " " + arrayContacts.get(i).getTelephone() + " " 
					+ arrayContacts.get(i).getAdress() + " " + arrayContacts.get(i).getCodePostal());
		}
	}
	
	
	
	
}
