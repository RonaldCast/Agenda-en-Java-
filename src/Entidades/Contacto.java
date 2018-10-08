package Entidades;

public class Contacto {

	private String _name;
	private String _telephone;
	private String _adress;
	private String _codePostal;
	
	public Contacto()
	{
		
	}
	public Contacto(String name, String telephone, String adress, String codePostal)
	{
		this._name = name;
		this._telephone = telephone;
		this._adress = adress;
		this._codePostal = codePostal; 
		
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
	
	
}
