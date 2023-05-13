#include <stdio.h>
#include <stdlib.h>
typedef float poly[11]; 


void zero(poly result);


unsigned degree(poly p);


void print(poly p);


void sum(poly result, poly p1, poly p2);


void neg(poly result, poly p);


void mul(poly result, poly p1, poly p2);


void quotient(poly result, poly p1, poly p2);


void reminder(poly result, poly p1, poly p2);



void gcd(poly result, poly p1, poly p2);


void radopposte(poly result, poly p);


void radreciproche(poly result, poly p);


unsigned maxnulls(poly p);


unsigned maxpos(poly p);


unsigned maxneg(poly p);


float polyval(poly p, float x);


unsigned max(unsigned x, unsigned y)
{
	return x>y ? x : y;
}

void zero(poly result)
{
	unsigned i;
	for(i=0; i<sizeof(poly)/sizeof(result[0]); ++i)
		result[i]=0;
}

void print(poly p)
{
	unsigned i, deg=degree(p);
	if(deg==0)
		printf("polinomio nullo");
	else
		printf("grado: %u", deg-1);	
	for(i=deg; i-->0; )
		printf(", %9.2f * x^%u", p[i], i);
	printf("\n");
}

void sum(poly result, poly p1, poly p2)
{
	
	unsigned deg = max(degree(p1), degree(p2)); 
	unsigned i;
	for(i=0; i<deg; ++i)
		result[i] = p1[i] + p2[i]; 
	
}

int main(void)
{
	poly p1, p2, result;
	float x;

	zero(p1);
	zero(p2);
	zero(result);

	printf("Calcoli polinomi di <Mario> <Rossi>\n");
	
	print(p1);
	print(p2);

	
	sum(result, p1, p2);
	print(result);
	neg(result, p1);
	print(result);
	mul(result, p1, p2);
	print(result);
	quotient(result, p1, p2);
	print(result);
	reminder(result, p1, p2);
	print(result);
	radopposte(result, p1);
	print(result);
	radreciproche(result, p1);
	print(result);

	printf("zero: %u, pos: %u, neg: %u\n", maxnulls(p1), maxpos(p1), maxneg(p1));
	for(x=-2; x!=2; x++)
		printf("polyval(%9.2f): %9.2f\n", x, polyval(p1, x));

	return 0;
}
