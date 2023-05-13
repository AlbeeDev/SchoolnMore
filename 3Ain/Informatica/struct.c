#include<stdio.h>
#include<math.h>
struct ratio {
	float num, den, val;
};

int gcd(int x, int y)
{
	if(y==0)
		return x;
	else if(x==0)
		return 1;
	else
		return gcd(y, x%y);
}

void null(float x)
{
	if(x==0){
		printf("null ");
	}
}

struct ratio add(struct ratio x, struct ratio y)
{
	struct ratio result;
	result.den = x.den*y.den;
	result.num = x.num*y.den + y.num*x.den;
	int mcd=gcd(result.num, result.den);
	result.num /= mcd;
	result.den /= mcd;
	if(result.den<0)
	{
		result.den=-result.den;
		result.num=-result.num;
	}
	result.val=result.num/result.den;
	return result;
}

struct ratio difference(struct ratio x, struct ratio y)
{
	struct ratio result;
	result.den = x.den*y.den;
	result.num = x.num*y.den - y.num*x.den;
	int mcd=gcd(result.num, result.den);
	result.num /= mcd;
	result.den /= mcd;
	if(result.den<0)
	{
		result.den=-result.den;
		result.num=-result.num;
	}
	result.val=result.num/result.den;
	return result;
	
}

struct ratio multiplication(struct ratio x, struct ratio y)
{
	struct ratio result;
	result.den = x.den*y.den;
	result.num = x.num*y.num;
	int mcd=gcd(result.num, result.den);
	result.num /= mcd;
	result.den /= mcd;
	if(result.den<0)
	{
		result.den=-result.den;
		result.num=-result.num;
	}
	result.val=result.num/result.den;
	return result;
	
}
struct ratio division(struct ratio x, struct ratio y)
{
	struct ratio result;
	result.den = x.den*y.num;
	result.num = x.num*y.den;
	int mcd=gcd(result.num, result.den);
	result.num /= mcd;
	result.den /= mcd;
	if(result.den<0)
	{
		result.den=-result.den;
		result.num=-result.num;
	}
	result.val=result.num/result.den;
	return result;
	
}
struct ratio power(struct ratio x, struct ratio y)
{
	struct ratio result;
	result.den = pow(x.den,(y.num/y.den));
	result.num = pow(x.num,(y.num/y.den));
	int mcd=gcd(result.num, result.den);
	result.num /= mcd;
	result.den /= mcd;
	if(result.den<0)
	{
		result.den=-result.den;
		result.num=-result.num;
	}
	result.val=result.num/result.den;
	return result;
	
}
int main()
{
	struct ratio a, b;
	a.num= 3;
	a.den= 2;
	b.num= 1;
	b.den= 4;
	
	struct ratio c =add(a, b);
	printf("%.0f/%.0f ", c.num, c.den);
	null(c.num);
	if(c.den==1)
		printf("%.0f\n",c.val);
	else
		printf("%.2f\n",c.val);
	
	struct ratio d =difference(a, b);
	printf("%.0f/%.0f ", d.num, d.den);
	null(d.num);
	if(d.den==1)
		printf("%.0f\n",d.val);
	else
		printf("%.2f\n",d.val);
	
	struct ratio e =multiplication(a, b);
	printf("%.0f/%.0f ", e.num, e.den);
	null(e.num);
	if(e.den==1)
		printf("%.0f\n",e.val);
	else
		printf("%.2f\n",e.val);
	
	struct ratio f =division(a, b);
	printf("%.0f/%.0f ", f.num, f.den);
	null(f.num);
	if(f.den==1)
		printf("%.0f\n",f.val);
	else
		printf("%.2f\n",f.val);

	struct ratio g =power(a, b);
	printf("%.2f/%.2f ", g.num, g.den);
	null(g.num);
	if(g.den==1)
		printf("%.0f\n",g.val);
	else
		printf("%.2f\n",g.val);
	return 0;
}
