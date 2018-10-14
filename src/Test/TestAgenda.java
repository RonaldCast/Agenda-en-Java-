package Test;

import Entidades.Agenda;
import Entidades.Menu;


public class TestAgenda {

	public static void main(String[] args) {
		
		Agenda newAgenda = new Agenda(5);
		Menu menu = new Menu(newAgenda);
		while(true)
		{
			menu.seletedOption();
		}
	}
}
