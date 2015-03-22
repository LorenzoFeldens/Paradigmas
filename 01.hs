--Aluno: Lorenzo Feldens


-- Veirica se duas listas possuem o mesmo primeiro elemento (Exercício 1)
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads lis1 lis2
	| (head lis1) ==  (head lis2) = True
	| otherwise = False

-- Eleva ao cubo cada elemento da lista (Exercício 2)
pot3 :: [Int] -> [Int]
pot3 [] = []
pot3 ns = (head ns)^3 : pot3 (tail ns)

-- Adiciona 10 a cada elemento da lista, recursivamente (Exercício 3)
add10 :: [Int] -> [Int]
add10 [] = []
add10 ns = (head ns)+10 : add10 (tail ns)

-- Adiciona uma virgula no final de cada string recursivamente (Exercício 4)
addComma :: [String] -> [String]
addComma [] = []
addComma ns = ((head ns) ++ ",") : addComma (tail ns)

-- Adiciona 10 a cada elemento da lista (Exercício 5)
add102 :: [Int] -> [Int]
add102 ns = map (+10) ns

-- Adiciona uma virgula no final de cada string (Exercício 5)
addComma2 :: [String] -> [String]
addComma2 [] = []
addComma2 ns = map (++",") ns

-- Formata como itens de lista em HTML (Exercício 6)
htmlListItems :: [String] -> [String]
htmlListItems [] = []
htmlListItems ns = map (html2) ns 

-- Função auxiliar Exercício 6
html2 :: String -> String
html2 ns = "<LI>" ++ ns ++ "</LI>"

-- Verifica a presença de um char em uma string recursivamente (Exercício 7)
charFound :: Char -> String -> Bool
charFound c s
	| s == [] = False
	| (head s) == c = True
	| otherwise = charFound c (tail s)

-- Verifica a presença de um char em uma string (Exercício 8)
charFound2 :: Char -> String -> Bool
charFound2 c s = if (filter (==c) s) == []
	then False
	else True

-- Diferença entre elementos de duas listas
difLis :: [Int] -> [Int] -> [Int]
difLis a b = zipWith (-) a b


-- Funções de Alta Ordem

-- Calcula 2*n+1 para cada elemento da lista (Exercício 1)
exer1 :: [Int] -> [Int]
exer1 [] = []
exer1 a = map (\x -> 2*x+1) a

-- Calcula 4*x+2*y+1 com pares de elementos de duas listas (Exercício 2)
exer2 :: [Int] -> [Int] -> [Int]
exer2 x y = zipWith (\x y -> 4*x+2*y+1) x y

-- Cria strings com 10 caracteres (Execício 3)
exer3 :: [String] -> [String]
exer3 s
	|s == [] = []
	|length (head s) >= 10 = take 10 (head s) : exer3 (tail s)
	|length (head s) < 10 = take 10 ((head s) ++ "..........") : exer3 (tail s)

-- Calcula o ano de nascimento aproximado de maiores de 20 anos (Exercício 4)
exer4 :: [Int] -> [Int]
exer4 a = map (\x -> 2015-x) (filter (>=20) a)