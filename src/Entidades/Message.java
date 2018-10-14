package Entidades;

public class Message {

	public static void success(String content)
	{
		int lengthContent = content.length() + 4;
		StringBuffer star = new StringBuffer();
		for(int i = 0; i < lengthContent; i++ )
		{
			star.append("*");
		}
		System.out.println();
		System.out.println(star);
		System.out.println("**"+ content +"**");
		System.out.println(star+"\n\n");
	}
	
	public static void warning(String content)
	{
		System.out.println();
		System.out.println("Alerta: "+ content );
		System.out.println();
		System.out.println();
	}

	public static void title(String content)
	{
		System.out.println();
		System.out.println("*~*"+ content +"*~*");
		System.out.println();
	}
}
