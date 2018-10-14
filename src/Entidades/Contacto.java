package Entidades;

public class Contacto {

	private int _id;
	private String _name;
	private String _telephone;
	private String _adress;
	private String _codePostal;
	private static int _count;
	public Contacto()
	{
		_count += 1; 
	}
	public Contacto(String name, String telephone, String adress, String codePostal)
	{
		_count += 1; 
		this._id = _count;
		this._name = name;
		this._telephone = telephone;
		this._adress = adress;
		this._codePostal = codePostal; 
		
		
	}
	
	public int getId()
	{
		return _id;
	}
	
	
	public Contacto(String name, String telephone, String adress)
	{
		this._name = name;
		this._telephone = telephone;
		this._adress = adress;
	}
	
	public Contacto(String name, String telephone)
	{
		this._name = name;
		this._telephone = telephone;
	}
	
	public Contacto(String telephone)
	{
		this._telephone = telephone;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		this._name = name; 
	}


	public String getAdress() 
	{
		return _adress;
	}


	public void setAdress(String adress) 
	{
		this._adress = adress;
	}
	
	public String getTelephone()
	{
		return _telephone;
	}
	
	public void setTelephone(String telephone)
	{
		this._telephone = telephone; 
	}
	
	public String getCodePostal()
	{
		return _codePostal;
	}
	
	public void setCodePostal(String codePostal)
	{
		this._codePostal = codePostal; 
	}
	
	@Override
	public String toString()
	{
		return 
				 "~Nombre: " + _name + "\n" 
				+ "~Teléfono: "+ _telephone + "\n" 
				+ "~Dirección: " + _adress + "\n" 
				+ "~Código postal: "+ _codePostal + "\n" ;
				
	}
	
	
}
