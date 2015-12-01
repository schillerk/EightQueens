# EightQueens
Since I started Peter Norvig's book on Artificial Intelligence, I felt compelled to work through at least a couple of the problems he mentions. Reading through the first section, what's more exciting than anything else is the opportunity to combine multiple solutions into one. It's a bit generous to call this code "genetic" or to say that I've really used SA, but it's a start.

For anyone who wasn't faced with it growing up, the eight queens problem is simple: A queen is a chess piece that can move any number of squares horizontally, vertically or diagonally; your goal is to put eight of them on a board so that none of them can attack any of the others.

A potential solution can be represented as an array where each element refers to the position of the queen on the board. For example, a queen in the bottom right corner would be represented by a seven in index seven of the array. Because evolution works better when you have a population bigger than one, we're using a 2 dimensional array with 10 proposed solutions in any given generation.

Since we only want the best solutions of any given generation to evolve, we need a fitness function to determine how good any given solution is. For the eight queens problem, this just means counting the number of possible attacks by checking the attack paths of each queen.

if (p[x][i] == p[x][j] && i != j){score[x]++; }
if ((p[x][i]-i) == (p[x][j]-j) && i != j){score[x]++; }
if ((p[x][i]+i) == (p[x][j]+j) && i != j){score[x]++; }

Based on these scores, we also need to choose which solutions get to breed. Initially, I was using the algorithm that determines how many seats each state gets in the house of representatives, but it turned out to be more effective to only let the best solution of any given generation survive.

At that point, it's a simple matter of "mutating" the solution and propagating a new generation.

for (int j=0; j<z; j++)
{
	gene = (int)(Math.random()*8);
	out[i][gene] = (int)(Math.random()*8);
}

The simulated annealing part of this is a single line of code. I said it was generous.

return (300-(x%300))/100;


This means that as time moves on, fewer and fewer genes get mutated with each generation. The reasoning here being that we're getting closer to an optimal solution and don't need to "shake things up" as much. The % function here serves to reset the "temperature" of the system in the case that a solution isn't reached after 300 steps.

Full program can be found here. 