public class QueensIV
{
	public void QueensIV(){}

	public static void main(String[] args)
	{
		QueensIV test = new QueensIV();
		test.run();
	}

	public void run()
	{
		int[][] p = initPopulation();
		for (int x= 0; x<10000; x++)
		{
			if(isSolved(p, x)){x = 10000;}
			p = nextGen(p, getTemp(x));
		}
	}

	public int getTemp(int x)
	{
		return (300-(x%300))/100;
	}

	public int[][] nextGen(int[][] p, int z)
	{
		int chosen = selectBreeder(p);
		int[] breeder = new int[8];
		int[][] out = new int[10][8];
		int gene;
		for (int i=0; i<8; i++)
		{
			breeder[i] = p[chosen][i];
		}
		for (int i=0; i<10; i++)
		{
			for (int x=0; x<8; x++)
			{
				out[i][x] = breeder[x];
			}
			for (int j=0; j<z; j++)
			{
				gene = (int)(Math.random()*8);
				out[i][gene] = (int)(Math.random()*8);
			}
		}
		return out;
	}

	public int selectBreeder(int[][] p)
	{
		int max = 0;
		int[] scores = score(p);
		for(int i=0; i<10; i++)
		{
			if(scores[i] > scores[max])
			{
				max = i;
			}
		}
		return max;
	}

	public int[] score(int[][] p)
	{
		int[] score = new int[10];
		for(int i=0; i<10; i++)
		{
			score[i] = 0;
		}
		for (int x=0; x<10; x++)
		{
			for(int i=0; i<8; i++)
			{
				for (int j=0; j<8; j++)
				{
					if (p[x][i] == p[x][j] && i != j){score[x]++; }
					if ((p[x][i]-i) == (p[x][j]-j) && i != j){score[x]++; }
					if ((p[x][i]+i) == (p[x][j]+j) && i != j){score[x]++; }
				}
			}
			score[x] = 56-score[x];
		}
		return score;
	}

	public int[][] initPopulation()
	{
		int[][] p = new int[10][8];
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<10; j++)
			{
				p[j][i] = (int)(Math.random()*8);
			}
		}
		return p;
	}

	public boolean isSolved(int[][] p, int x)
	{
		boolean solved = false;
		System.out.println("GENERATION " + x + "\n––––––––––––––––––");
		int[] scores = score(p);
		for (int i=0; i<10; i++)
			{
			for (int j=0; j<8; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}	
		for(int i=0; i<10; i++)
		{
			System.out.println(scores[i]);
			if(scores[i] == 56){ solved=true; }

		}
		System.out.println();
		return solved;
	}
}