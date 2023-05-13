#include <stdio.h>
#include <stdlib.h>
int main(){
  unsigned n, r, c;

  // soluzione 1
  n = 5;
  for (r=0; r<2*n-1; r++)
  {
    for (c=0; c<2*n-1; c++)
    {
      unsigned maxr = abs((int)n-2-(int)r)+1;
      unsigned maxc = abs((int)n-1-(int)c)+1;
      unsigned max = maxr > maxc ? maxr : maxc;
      printf("%2u", max);
    }
  printf("\n");
  }
printf("\n");
  // soluzione 2
  n = 9;
  for (r=0; r<n; r++)
  {
    for (c=0; c<n; c++)
    {
      unsigned maxr = abs((int)n/2-(int)r)+1;
      unsigned maxc = abs((int)n/2-(int)c)+1;
      unsigned max = maxr > maxc ? maxr : maxc;
      printf("%2u", max);
    }
    printf("\n");
  }

  return 0;
}
