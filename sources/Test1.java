public class Test1{

	public static int pgcd(int x,int y)
	{

	if(y == 0 )
		return x;
	else
		return pgcd(y,x%y);
	}



	public static void main(String[] args) {
		System.out.println(new Rationnel(0,40,24));

			}

}
