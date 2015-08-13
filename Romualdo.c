#include <stdio.h>
#include <stdlib.h>
#include <strings.h>

typedef struct lista{
    char login[25];
    struct lista *prox;
} Lista;

FILE* abrir (char *nome);
Lista *ler (FILE *f);
Lista *insere(Lista *l,char *lin);
void novo (Lista *l, char *nome);

int main(){
    FILE *f;
    char nome[25];
    Lista *l;

    f=abrir(nome);
    l=ler(f);
    fclose(f);
    novo(l,nome);

    return 0;
}

FILE* abrir (char *nome){
    FILE *f;


    printf("Nome do arquivo: (.txt)\n");
    gets(nome);
    f=fopen(nome,"r");

    if (f==NULL){
        printf("Erro ao carregar arquivo!");
        exit(1);
    }
    return f;
}

Lista *ler (FILE *f){
    Lista *l=NULL;
    char lin[25];

    while (!feof(f)){
        fscanf(f,"%s",lin);
        if (strlen(lin)<=8){
            l=insere(l,lin);
        }
    }
    if (ferror(stdin)){
        fclose(f);
        exit(2);
    }

    return l;
}

Lista *insere(Lista *l,char *lin){
    Lista *p,*q,*r;
    p=malloc(sizeof(Lista));
    strcpy(p->login,lin);

    if (l==NULL){
        p->prox=NULL;
        return p;
    }
    q=NULL;
    r=l;
    while (r!=NULL && strcmp(lin,r->login)>0){
        q=r;
        r=r->prox;
    }

    p->prox=r;
    if (q==NULL){
        return p;
    }
    q->prox=p;

    return l;
}

void novo (Lista *l, char *nome){
    FILE *f;
    char nnome[25];
    strcpy(nnome,"new_");
    strcat(nnome,nome);
    f=fopen(nnome,"w");
    while (l!=NULL){
        fprintf(f,"%s@mycompany.com\n",l->login);
        l=l->prox;
    }
    fclose(f);
}
