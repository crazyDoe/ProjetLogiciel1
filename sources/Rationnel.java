public class Rationnel{
	private int n,a,b,state;

	public Rationnel(int pN)
	{
		this.n = pN;
		state = 1;
	}

	public Rationnel(int pA,int pB)
	{
		this.a = pA;
		this.b = pB;
		state = 2;
	}	

	public Rationnel(int pN,int pA,int pB)
	{
		this.n = pN;
		this.a = pA;
		this.b = pB;
		state = 3;
		simplification();
	}

	public boolean estNul()
	{
		if(state == 1)
			return n == 0;
		return n * b + a == 0;

	} 

	public Rationnel inverse()
	{
		Rationnel retour = new Rationnel(b, n * b + a);
		return retour;
	}

	public Rationnel ajouter(Rationnel r)
	{
		Rationnel retour = new Rationnel(this.n + r.n, this.a * r.b + r.a + this.b, this.b * r.b);
		return retour;
	}

	public Rationnel multiplier(Rationnel r)
	{
		int nbFact = this.n * this.b + this.a;
		Rationnel retour = new Rationnel(this.n * r.n, r.a * nbFact + r.b * this.a * r.n, this.b * r.b);
		return retour;
	}

	public int compareTo(Rationnel r)
	{
		int nb1,nb2;
		nb1 = n * b + a;
		nb2 = r.n * r.b + r.a;
		if(nb1<nb2)
			return -1;
		else if(nb2>nb1)
			return 1;
		return 0;

	}

	public int pgcd(int x,int y)
	{

	if(y == 0 )
		return x;
	else
		return pgcd(y,x%y);
	}


	public void simplification()
	{
		int pgcd;
		while(a > b)
		{
			n++;
			a = a - b;
		}
		pgcd = pgcd(a,b);
		a /= pgcd;
		b /= pgcd;

	}



	public String toString()
	{
		if(estNul())
		{
			return "0";
		}

		if(state == 1)
		{
			return n+"";
		}

		if (state == 3)
		{
			return n + " + "+a+"/"+b;
		}
	
		return a+"/"+b;

	}

}