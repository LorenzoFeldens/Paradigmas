% Exercício 1:
% 	Define uma lista com elementos predecessores de 
% uma primeira lista
%
% false.
% L = [9, 10].
% false.
% X = 3.

% Exercício 2:
ziplus([],[],[]).
ziplus([H|T],[H1|T1],[H2|T2]) :- H2 is H + H1, ziplus(T,T1,T2).

% Exercício 3:
countdown(0,[0]).
countdown(N,[H|T]) :- H is N,N1 is N - 1,countdown(N1,T).

% Exercício 4:
pot(N,N,[]).
pot(N,N1,[H|T]) :- H is 2 ^ N1,N2 is N1 + 1,pot(N,N2,T).

potencias(0,[]).
potencias(N,L) :- pot(N,0,L).

% Exercício 5:
positivos([],[]).
positivos([H|T],[H1|T1]) :- H >= 0,H1 is H,positivos(T,T1).
positivos([_|T],L) :- positivos(T,L).

% Exercício 6:
mesmaPosicao(C,[H|_],[H1|_]) :- C = H, H1 = H.
mesmaPosicao(C,[_|T],[_|T1]) :- mesmaPosicao(C,T,T1).

% Exercício 7:
intercala(_,[U],[H]) :- H is U.
intercala(X,[H|T],[H1,H2|T1]) :- H1 = H, H2 = X, intercala(X,T,T1).

% Exercício 8:
remove(X,[X|T],T).
remove(X,[_|T],L) :- remove(X,T,L).

comissao(0,_,[]).
comissao(NP,LP,[H|T]) :- NP1 is NP - 1, remove(H,LP,LP1), comissao(NP1,LP1,T).

% Exercício 9:
azulejos(0,0) :- !.
azulejos(NA,NP) :- sqrt(NA,M),floor(M,N), NA1 is NA - N*N,azulejos(NA1,NP1),NP is 1 + NP1.