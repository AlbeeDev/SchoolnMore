#include<stdio.h>
#include<string.h>
int main(){
	char pagina[]={
	"<!DOCTYPE html>\n"
	"<html>\n"
	"\t<head>\n"
	"\t\t<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n"
	"\t\t<title>Pagina generata automaticamente</title>\n"
	"\t</head>\n"
	"\t<body>\n"
	"\t\t<p style='color: red;'>\n"
	"\t\t\tQuesta pagina &egrave; stata generata automaticamente\n"
	"\t\t\tda un programma scritto in linguaggio C.\n"
	"\t\t</p>\n"
	"\t</body>\n"
	"</html>"	
	};
	FILE *test;
	test=fopen("test.html","w");
	fputs(pagina,test);
	fclose(test);
}
