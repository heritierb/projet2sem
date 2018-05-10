package graphisme;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list_directory test = new list_directory(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/photos",
				".jpg");
		for(int i=0; i<test.getFichiers().size(); i++)
			System.out.println(test.getFichiers().get(i));
	}

}
